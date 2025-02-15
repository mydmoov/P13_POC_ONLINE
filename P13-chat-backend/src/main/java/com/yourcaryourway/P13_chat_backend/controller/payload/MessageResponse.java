package com.yourcaryourway.P13_chat_backend.controller.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
    private String content;
    private String sender;
}
