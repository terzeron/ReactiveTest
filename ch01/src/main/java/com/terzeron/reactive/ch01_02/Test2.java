package com.terzeron.reactive.ch01_02;

import java.util.function.Consumer;

public class Test2 {
    static class ShoppingService {
        static void calculate(int i, int j, Consumer<Integer> c) {
            c.accept(i + j);
        }
    }

    public static void main(String[] args) {
        ShoppingService.calculate(10, 3, System.out::print);
    }

}
