package com.terzeron.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routes(UserHandler userHandler) {
        return nest(path("/users"),
                nest(accept(APPLICATION_JSON), route(GET("/{id}"), userHandler::get)
                        .andRoute(method(HttpMethod.GET), userHandler::list))
                        .andNest(contentType(APPLICATION_JSON), route(POST("/"), userHandler::create)));
    }
}
