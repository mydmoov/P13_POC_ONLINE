package com.yourcaryourway.P13_chat_backend.configuration.socket;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIOConfig {
    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname("0.0.0.0");
        config.setPort(1414);
        // Autoriser uniquement votre domaine en HTTPS
        config.setOrigin("https://poc.cortek.fr");
        config.setPingInterval(25000);
        config.setPingTimeout(60000);
        config.setAllowCustomRequests(true);
        return new SocketIOServer(config);
    }
}

