package com.terzeron.reactive.step1;

import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AsyncRestTemplateImpl<T> implements AsyncRestTemplate {
    @Override
    public <T> ListenableFuture<T> execute() {
        System.out.println("AsyncRestTemplateImpl::execute()");
        return new ListenableFuture<T>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                System.out.println("cancel()");
                return false;
            }

            @Override
            public boolean isCancelled() {
                System.out.println("isCancelled()");
                return false;
            }

            @Override
            public boolean isDone() {
                System.out.println("isDone()");
                return false;
            }

            @Override
            public T get() throws InterruptedException, ExecutionException {
                System.out.println("get()");
                return null;
            }

            @Override
            public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                System.out.println("get()");
                return null;
            }

            @Override
            public void addCallback(ListenableFutureCallback<? super T> listenableFutureCallback) {
                System.out.println("addCallback()");

            }

            @Override
            public void addCallback(SuccessCallback<? super T> successCallback, FailureCallback failureCallback) {
                System.out.println("addCallback()");

            }
        };
    }
}
