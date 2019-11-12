package com.terzeron.reactive;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.net.URI;

@Component
public class UserHandler {
    final UserRepository userRepository;
    User user1 = new User(1, "Mike", "Smith", "1234");
    User user2 = new User(2, "Tom", "Jones", "5678");
    User user3 = new User(3, "James", "Bond", "5th Avenue");

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(userRepository::save)
                .flatMap(u -> ServerResponse.created(URI.create("/users/" + u.getId())).build());
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(Mono.just(user1), User.class);
    }

    public Mono<ServerResponse> list(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(Flux.just(user1, user2, user3), User.class);
    }
}
