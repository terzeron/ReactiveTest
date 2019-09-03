package com.terzeron.reactive.ch02_02;

import org.springframework.stereotype.Component;
import rx.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class TemperatureSensor {
    private final Random rnd = new Random();

    private final Observable<Temperature> dataStream =
            Observable
            .range(1, Integer.MAX_VALUE)
            .concatMap(tick -> Observable
                    .just(tick)
                    .delay(rnd.nextInt(5000), TimeUnit.MILLISECONDS)
                    .map(tickValue -> this.probe()))
            .publish()
            .refCount();

    public Temperature probe() {
        return new Temperature(16 + rnd.nextGaussian() * 10);
    }

    public Observable<Temperature> temperatureStream() {
        return dataStream;
    }
}
