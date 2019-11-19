package com.example.socketserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/sse/")
public class SSEController {

    @Autowired
    private MessageService messageService;

    @GetMapping(produces = "text/event-stream")
    public Flux<Message> streamMessages() {

        log.info("GET event");
        return Flux
                .fromIterable(messageService.generate100RandomMessages())
                .log();
    }
}
