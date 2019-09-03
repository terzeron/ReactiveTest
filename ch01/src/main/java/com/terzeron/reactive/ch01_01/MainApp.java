package com.terzeron.reactive.ch01_01;

public class MainApp {
    public static void main(String[] args) throws Exception {
        ThreadTest test1 = new ThreadTest();
        test1.run();

        ThreadExecutorTest test2 = new ThreadExecutorTest();
        test2.run();

        ThreadExecutorForkJoinPoolTest test3 = new ThreadExecutorForkJoinPoolTest();
        test3.run();

        AsyncIOTest test4 = new AsyncIOTest();
        test4.run();

        CompletableFutureTest test5 = new CompletableFutureTest();
        test5.run();

        FlowTest test6 = new FlowTest();
        test6.run();
    }
}
