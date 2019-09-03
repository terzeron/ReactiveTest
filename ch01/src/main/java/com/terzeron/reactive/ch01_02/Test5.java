package com.terzeron.reactive.ch01_02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

public class Test5 {
    boolean isStopped = false;

    public Test5() {
        System.out.println("---- Test5 ----");
    }

    public void run() throws Exception {
        Iterable<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<Integer>();

        Subscriber<Integer> subscriber = new Subscriber<>() {
            Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("onNext: " + item);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
                isStopped = true;
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
                isStopped = true;
            }
        };

        publisher.subscribe(subscriber);
        list.forEach(i -> publisher.submit(i));
        publisher.close();

        while (!isStopped) {
            Thread.sleep(1000);
        }
    }
}
