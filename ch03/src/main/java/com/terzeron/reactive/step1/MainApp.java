package com.terzeron.reactive.step1;

import org.springframework.util.concurrent.*;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("main()");
        requestData().addCallback(new ListenableFutureCallback<Object>() {
            @Override
            public void onSuccess(Object o) {
                System.out.println("onSuccess");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("onFailure");
            }
        });
    }

    public static ListenableFuture<?> requestData() {
        System.out.println("requestData()");
        AsyncRestTemplate httpClient = new AsyncRestTemplateImpl();
        AsyncDatabaseClient databaseClient = new AsyncDatabaseClientImpl();

        // api 호출 후 db에 저장하고 사용자에게 데이터 리턴.
        ListenableFuture result = httpClient.execute();
        CompletionStage<String> future = databaseClient.store(AsyncAdapters.toCompletion(result));

        return AsyncAdapters.toListenable(future);
    }
}

