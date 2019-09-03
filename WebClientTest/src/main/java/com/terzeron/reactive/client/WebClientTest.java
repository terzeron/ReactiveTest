package com.terzeron.reactive.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

public class WebClientTest {
    public static void main(String[] args) throws Exception {
        WebClient client1 = WebClient.create();

        WebClient client2 = WebClient.create("https://google.com");
//        WebClient.UriSpec<RequestBodySpec> request2 = client1.method(HttpMethod.GET);
//        String response2 = request2.exchange()
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//        System.out.println(response2);

        WebClient client3 = WebClient
                .builder()
                .baseUrl("https://google.com")
                .defaultCookie("cookeyKey", "cookeyValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "https://google.com"))
                .build();
        String response3 = client3.get().exchange().block().bodyToMono(String.class).block();
        System.out.println(response3);
//        String response4 = client3.get().retrieve().bodyToMono(String.class).block();
//        System.out.println(response4);
    }
}
