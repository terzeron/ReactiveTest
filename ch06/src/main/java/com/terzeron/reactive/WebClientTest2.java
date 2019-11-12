package com.terzeron.reactive;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

public class WebClientTest2 {
    public static void main(String[] args) throws InterruptedException {
        WebClient client1 = WebClient.create();
        client1
                .get()
                .uri("http://localhost:8080/users/3")
                .retrieve() // body
                .bodyToMono(String.class)
                .subscribe(System.out::println);

        WebClient
                .builder()
                .baseUrl("http://localhost:8080/users")
                .build()
                .get()
                .retrieve()
                .bodyToFlux(User.class)
                .subscribe(System.out::println);

        WebClient
                .builder()
                .baseUrl("http://localhost:8080/users")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .get()
                .exchange()
                .block()
                .bodyToFlux(User.class)
                .subscribe(System.out::println);

        WebClient
                .builder()
                .baseUrl("http://localhost:8080/users")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .get()
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(User.class))
                .subscribe(System.out::println);

        WebClient
                .builder()
                .baseUrl("http://localhost:8080/users")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .get()
                .exchange()
                .subscribe(clientResponse -> {
                    System.out.println(clientResponse.statusCode());
                    HttpHeaders headers = clientResponse.headers().asHttpHeaders();
                    for (String key : headers.keySet()) {
                        System.out.println(key + " " + headers.get(key));
                    }
                });

        while (true) {
            Thread.sleep(1000);
        }
    }
}
