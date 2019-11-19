package com.example.socketclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

@SpringBootApplication
public class SocketclientApplication {
    public static void main(String[] args) {

        WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(
                URI.create("ws://localhost:8080/event-emitter"),
                session -> session.send(
                        Mono.just(session.textMessage("Event From Client")))
                        .thenMany(session.receive()
                                .map(WebSocketMessage::getPayloadAsText)
                                .log())
                        .then())
                .block(Duration.ofSeconds(10L));
    }
}
