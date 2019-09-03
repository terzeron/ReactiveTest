package com.terzeron.reactive.step1;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

final class AsyncAdapters {
    // ListenableFuture --> CompletableFuture
    public static <T> CompletionStage<T> toCompletion(ListenableFuture<T> future) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        future.addCallback(completableFuture::complete, completableFuture::completeExceptionally);
        System.out.println("returns CompletableFuture object as CompletionStage type");
        return completableFuture;
    }

    // CompletableFuture --> ListenableFuture
    public static <T> ListenableFuture<T> toListenable(CompletionStage<T> stage) {
        SettableListenableFuture<T> future = new SettableListenableFuture<>();
        stage.whenComplete((v, t) -> {
            if (t == null) {
                System.out.println("sets result");
                future.set(v);
            } else {
                System.out.println("sets exception");
                future.setException(t);
            }
        });
        System.out.println("returns Listenable object");
        return future;
    }
}
