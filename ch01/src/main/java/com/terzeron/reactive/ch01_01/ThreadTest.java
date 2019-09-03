package com.terzeron.reactive.ch01_01;

import java.time.LocalDateTime;

public class ThreadTest {
    public ThreadTest() {
        System.out.println("---- ThreadTest ----");
    }

    public void run() throws Exception {
        Thread t = new Thread(() -> print("My first thread"));
        t.start();
        t.join();
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
