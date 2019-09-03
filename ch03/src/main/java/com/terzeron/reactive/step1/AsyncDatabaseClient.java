package com.terzeron.reactive.step1;

import java.util.concurrent.CompletionStage;

interface AsyncDatabaseClient {
    <T> CompletionStage<T> store(CompletionStage<T> stage);
}
