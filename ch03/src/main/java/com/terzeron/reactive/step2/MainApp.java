package com.terzeron.reactive.step2;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

//public class MainApp {
//
//    public static void main(String[] args) {
//        NewsServicePublisher newsService = new NewsServicePublisher();
//        NewsServiceSubscriber subscriber = new NewsServiceSubscriber(5);
//        newsService.subscribe(subscriber);
//
//        subscriber.eventuallyReadDigest();
//    }
//}

