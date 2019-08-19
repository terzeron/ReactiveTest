package com.terzeron.reactive;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Step2 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = ForkJoinPool.commonPool();

        //es.execute(() -> print("My single thread pool"));
        Future<String> future =  es.submit(() -> longTermJob("fork join pool"));
        //Thread.sleep(1000);
        print(future.get()); // blocking in future.get()

        es.shutdown();
    }

    private static String longTermJob(String name) throws Exception {
        print("start job");
        Thread.sleep(5000);
        print("end job");
        return "**" + name + "**";
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
