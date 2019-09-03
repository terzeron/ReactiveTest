package com.terzeron.reactive.ch01_02;

public class Test1 {
    public Test1() {
        System.out.println("---- Test1 ----");
    }

    static class ShoppingService {
        static int calculate(int i, int j) {
            return i + j;
        }
    }
    public void run() {
        int result = ShoppingService.calculate(10, 3);
        System.out.println(result);
    }

}
