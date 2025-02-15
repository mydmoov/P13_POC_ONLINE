package com.yourcaryourway.P13_chat_backend.controller.payload;


public record MessageRequest(
        String sender,
        String content
        ) {

        @Override
        public String sender() {
                return sender;
        }

        @Override
        public String content() {
                return content;
        }
}
