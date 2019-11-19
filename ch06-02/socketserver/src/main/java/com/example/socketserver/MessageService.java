package com.example.socketserver;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MessageService {
    public Collection<Message> generate100RandomMessages() {
        Collection<Message> messages = new ArrayList<>();

        for(int i = 0 ; i < 100 ; i++) {
            String title = "Message" + i;
            String contents = RandomStringUtils.randomAlphabetic(50);
            messages.add(new Message(title, contents));
        }

        return messages;
    }
}
