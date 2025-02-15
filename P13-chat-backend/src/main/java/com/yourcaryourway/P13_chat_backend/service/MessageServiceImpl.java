package com.yourcaryourway.P13_chat_backend.service;

import com.yourcaryourway.P13_chat_backend.controller.payload.MessageResponse;
import com.yourcaryourway.P13_chat_backend.mappers.MessageMapper;
import com.yourcaryourway.P13_chat_backend.model.Message;
import com.yourcaryourway.P13_chat_backend.repository.MessageRepository;
import com.yourcaryourway.P13_chat_backend.controller.payload.MessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageRepository messageRepository;

    // Injection du MessageMapper
    @Autowired
    private MessageMapper messageMapper;

    @Transactional
    @Override
    public void saveMessage(MessageRequest messageRequest) {
        // Utilisez le mapper injecté pour convertir MessageRequest en Message
        final Message message = messageMapper.toDomain(messageRequest);
        messageRepository.save(message);
    }

    @Override
    public List<MessageResponse> getAllMessages() {
        List<Message> messages = messageRepository.findAll();

        // Utilisez le mapper injecté pour transformer la liste de Message en MessageResponse
        return messageMapper.toMessagesResponse(messages);
    }
}
