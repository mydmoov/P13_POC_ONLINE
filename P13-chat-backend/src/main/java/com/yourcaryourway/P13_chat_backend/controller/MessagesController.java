package com.yourcaryourway.P13_chat_backend.controller;


import com.yourcaryourway.P13_chat_backend.controller.payload.MessageResponse;
import com.yourcaryourway.P13_chat_backend.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/messages")
public class MessagesController  {

    private final MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("")
    public List<MessageResponse> getMessages() {
        List<MessageResponse> messages = this.messageService.getAllMessages();
        return messages;
    }

}
