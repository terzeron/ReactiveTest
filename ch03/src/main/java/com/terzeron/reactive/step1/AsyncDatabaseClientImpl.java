package com.terzeron.reactive.step1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

class AsyncDatabaseClientImpl<T> implements AsyncDatabaseClient {
    @Override
    public <T> CompletionStage<T> store(CompletionStage<T> stage) {
        System.out.println("AsyncDatabaseClientImpl::store()");
        return new CompletionStage<T>() {

            @Override
            public <U> CompletionStage<U> thenApply(Function<? super T, ? extends U> fn) {
                System.out.println("thenApply()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> thenApplyAsync(Function<? super T, ? extends U> fn) {
                System.out.println("thenApplyAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> thenApplyAsync(Function<? super T, ? extends U> fn, Executor executor) {
                System.out.println("thenApplyAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> thenAccept(Consumer<? super T> action) {
                System.out.println("thenAccept()");
                return null;
            }

            @Override
            public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action) {
                System.out.println("thenAcceptAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor) {
                System.out.println("thenAcceptAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> thenRun(Runnable action) {
                System.out.println("thenRun()");
                return null;
            }

            @Override
            public CompletionStage<Void> thenRunAsync(Runnable action) {
                System.out.println("thenRunAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> thenRunAsync(Runnable action, Executor executor) {
                System.out.println("thenRunAsync()");
                return null;
            }

            @Override
            public <U, V> CompletionStage<V> thenCombine(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
                System.out.println("thenCombine()");
                return null;
            }

            @Override
            public <U, V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
                System.out.println("thenCombineAsync()");
                return null;
            }

            @Override
            public <U, V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
                System.out.println("thenCombineAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<Void> thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
                System.out.println("thenAcceptBoth()");
                return null;
            }

            @Override
            public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
                System.out.println("thenAcceptBothAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action, Executor executor) {
                System.out.println("thenAcceptBothAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
                System.out.println("runAfterBoth()");
                return null;
            }

            @Override
            public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
                System.out.println("runAfterBothAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
                System.out.println("runAfterBothAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn) {
                System.out.println("applyToEither()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn) {
                System.out.println("applyToEitherAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn, Executor executor) {
                System.out.println("applyToEitherAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action) {
                System.out.println("acceptEither()");
                return null;
            }

            @Override
            public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action) {
                System.out.println("acceptEitherAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor) {
                System.out.println("acceptEitherAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
                System.out.println("runAfterEither()");
                return null;
            }

            @Override
            public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
                System.out.println("runAfterEitherAsync()");
                return null;
            }

            @Override
            public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
                System.out.println("runAfterEitherAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn) {
                System.out.println("thenCompose()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn) {
                System.out.println("thenComposeAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn, Executor executor) {
                System.out.println("thenComposeAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn) {
                System.out.println("handle()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn) {
                System.out.println("handleAsync()");
                return null;
            }

            @Override
            public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor executor) {
                System.out.println("handleAsync()");
                return null;
            }

            @Override
            public CompletionStage<T> whenComplete(BiConsumer<? super T, ? super Throwable> action) {
                System.out.println("whenComplete()");
                return null;
            }

            @Override
            public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action) {
                System.out.println("whenCompleteAsync()");
                return null;
            }

            @Override
            public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action, Executor executor) {
                System.out.println("whenCompleteAsync()");
                return null;
            }

            @Override
            public CompletionStage<T> exceptionally(Function<Throwable, ? extends T> fn) {
                System.out.println("exceptionally()");
                return null;
            }

            @Override
            public CompletableFuture<T> toCompletableFuture() {
                System.out.println("toCompletableFuture()");
                return null;
            }
        };
    }
}
