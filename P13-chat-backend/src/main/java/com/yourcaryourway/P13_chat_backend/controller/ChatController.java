package com.yourcaryourway.P13_chat_backend.controller;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.yourcaryourway.P13_chat_backend.configuration.socket.SocketIOServerRunner;
import com.yourcaryourway.P13_chat_backend.controller.payload.MessageRequest;
import com.yourcaryourway.P13_chat_backend.service.MessageService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final SocketIOServerRunner server;
    private final MessageService messageService;


    public ChatController(SocketIOServerRunner server, MessageService messageService) {
        this.server = server;
        this.messageService = messageService;
    }

    @PostConstruct
    public void setupListener() {
        SocketIOServer socket = this.server.getSocket();
        socket.addEventListener("sendMessage", MessageRequest.class, (client, message, ackSender) -> {
            onChatMessage(client, message);
        });
    }

    private void onChatMessage(SocketIOClient client, MessageRequest message) {
        logger.info("Received message from client {}: sender={}, content={}",
                client.getSessionId(), message.sender(), message.content());
        try {
            // Diffuse the message to all connected clients
            this.messageService.saveMessage(message);
            server.getSocket().getBroadcastOperations().sendEvent("chatMessage", message);

        } catch (Exception e) {
            logger.error("Error handling chat message: {}", e.getMessage(), e);
        }
    }
}
