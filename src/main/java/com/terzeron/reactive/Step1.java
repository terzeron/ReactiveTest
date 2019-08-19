package com.terzeron.reactive;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step1 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(4);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);

        //es.execute(() -> print("My single thread pool"));
        Future<String> future =  es.submit(() -> longTermJob("executorservice"));
        //Thread.sleep(1000);
        print(future.get()); // blocking in future.get()

        es.shutdown();
    }

    private static String longTermJob(String name) throws Exception {
        print("start longterm job");
        Thread.sleep(5000);
        return "**" + name + "**";
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
