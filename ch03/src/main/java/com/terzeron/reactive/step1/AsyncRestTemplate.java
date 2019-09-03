package com.terzeron.reactive.step1;

import org.springframework.util.concurrent.ListenableFuture;

interface AsyncRestTemplate {
    <T> ListenableFuture<T> execute();
}
