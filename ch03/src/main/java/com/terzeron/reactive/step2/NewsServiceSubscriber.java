package com.terzeron.reactive.step2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

//TODO
//class NewsServiceSubscriber implements Subscriber<NewsLetter> {
//    final Queue<NewsLetter> mailbox = new ConcurrentLinkedQueue<NewsLetter>();
//    final int take;
//    final AtomicInteger remaining = new AtomicInteger();
//    Subscription subscription;
//
//    public NewsServiceSubscriber(int take) {
//        this.take = take;
//    }
//
//    void eventuallyReadDigest() {
//        //TODO
//    };
//}
