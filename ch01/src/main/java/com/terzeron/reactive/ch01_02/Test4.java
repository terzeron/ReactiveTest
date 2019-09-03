package com.terzeron.reactive.ch01_02;

import java.util.Observable;
import java.util.Observer;

public class Test4 {
    public Test4() {
        System.out.println("---- Test4 ----");
    }

    static class IntObservable extends Observable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                setChanged();
                notifyObservers(i);
            }
        }
    }

    public void run() {
        Observer observer = new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };

        IntObservable intObservable = new IntObservable();
        intObservable.addObserver(observer);
        intObservable.run();
    }
}
