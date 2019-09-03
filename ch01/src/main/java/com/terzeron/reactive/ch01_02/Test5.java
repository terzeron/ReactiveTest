package com.terzeron.reactive.ch01_02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Flow;

public class Test5 {
    public static void main(String[] args) {
        Iterable<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Flow.Publisher publisher = subscriber -> {
            Iterator it = list.iterator();
            subscriber.onSubscribe(new Flow.Subscription() {
                @Override
                public void request(long n) {
                    while (n-- > 0) {
                        if (it.hasNext()) {
                            subscriber.onNext(it.next());
                        } else {
                            subscriber.onComplete();
                        }
                    }
                }

                @Override
                public void cancel() {

                }
            });
        };

        Flow.Subscriber<Integer> s = new Flow.Subscriber<Integer>() {
            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("onNext");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        publisher.subscribe(s);
    }
}
