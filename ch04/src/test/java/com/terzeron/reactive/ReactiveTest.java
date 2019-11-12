package com.terzeron.reactive;

import org.junit.Test;
import org.springframework.util.DigestUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.terzeron.reactive.Utils.println;

public class ReactiveTest {
    public String calculcateHash(String text) {
        String md5Hex = DigestUtils.md5DigestAsHex(text.getBytes()).toUpperCase();
        return md5Hex;
    }

    @Test
    public void test1() throws Exception {
        Flux.range(0, 10)
                .filter(s -> s > 3)
                .doOnNext(Utils::println)
                .subscribeOn(Schedulers.newSingle("new scheduler for subscribing"))
                .map(String::valueOf)
                .publishOn(Schedulers.newSingle("new scheduler for publishing"))
                .map(this::calculcateHash)
                .doOnNext(Utils::println)
                .doOnSubscribe(s -> println("onSubscribe"))
                .blockLast();
    }

    @Test
    public void test2() throws Exception {
        Mono.fromCallable(() -> "hello")
                .doOnNext(Utils::println)
                .publishOn(Schedulers.newSingle("new scheduler for publishing"))
                .map(msg -> msg + " world!")
                .subscribeOn(Schedulers.newSingle("new scheduler for subscribing"))
                .doOnNext(Utils::println)
                .doOnSubscribe(s -> println("onSubscribe"))
                .block();
    }


}
