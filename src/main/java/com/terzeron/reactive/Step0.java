package com.terzeron.reactive;

import java.time.LocalDateTime;

public class Step0 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> print("My first thread"));
        t.start();
        t.join();
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
