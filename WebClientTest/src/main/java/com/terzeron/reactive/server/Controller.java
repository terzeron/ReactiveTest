package com.terzeron.reactive.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/resource")
    public String resource() {
        return "test response from resource";
    }
}
