package com.terzeron.reactive;

public class Utils {
    public static void println(String msg) {
        System.out.println("[" + Thread.currentThread() + "] - " + msg);
    }

    public static void println(int msg) {
        Utils.println(String.valueOf(msg));
    }
}
