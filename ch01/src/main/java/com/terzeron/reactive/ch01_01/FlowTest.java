package com.terzeron.reactive.ch01_01;

import java.time.LocalDateTime;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;


public class FlowTest {
    public FlowTest() {
        System.out.println("---- FlowTest ----");
    }

    public void run() throws Exception {
        SubmissionPublisher<String> publisher = new SubmissionPublisher();
        publisher.subscribe(new SimpleSubscriber("A"));

        publisher.submit("1st item");
        publisher.submit("2nd item");

        publisher.subscribe(new SimpleSubscriber("B"));
        publisher.submit("3rd item");
        publisher.close();

        Thread.sleep(5000);
    }

    public static class SimpleSubscriber implements Flow.Subscriber<String> {
        private Flow.Subscription subscription;
        private String name;

        public SimpleSubscriber(String name) {
            this.name = name;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            print("onSubscribe");
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            print("onNext " + name + " " + item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            print("onError" + throwable);
        }

        @Override
        public void onComplete() {
            print("onComplete");
        }
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
