package com.yourcaryourway.P13_chat_backend.service;


import com.yourcaryourway.P13_chat_backend.controller.payload.MessageResponse;
import com.yourcaryourway.P13_chat_backend.model.Message;
import com.yourcaryourway.P13_chat_backend.controller.payload.MessageRequest;

import java.util.List;

public interface MessageService {

    /**
     *
     * @param messageRequest  the message send
     */
     void saveMessage(MessageRequest messageRequest);

    /**
     *
     * @return {@link MessageResponse} list
     */
    List<MessageResponse> getAllMessages();
}
