package com.terzeron.reactive.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Mono;

import java.util.Collections;

@SpringBootApplication
public class WebTestClientTest {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebTestClientTest.class);

        WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/resource")
                .exchange()
                .expectStatus().isOk()
                .expectBody().equals("test response from resource");
        System.out.println("end of server test by WebTestClient");
    }
}
