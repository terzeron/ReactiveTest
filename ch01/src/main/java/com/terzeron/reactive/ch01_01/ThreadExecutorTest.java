package com.terzeron.reactive.ch01_01;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExecutorTest {
    public ThreadExecutorTest() {
        System.out.println("---- ThreadExecutorTest ----");
    }

    public void run() throws Exception {
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
        Thread.sleep(3000);
        return "**" + name + "**";
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
