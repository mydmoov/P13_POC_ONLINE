package com.yourcaryourway.P13_chat_backend.mappers;

import com.yourcaryourway.P13_chat_backend.controller.payload.MessageRequest;
import com.yourcaryourway.P13_chat_backend.controller.payload.MessageResponse;
import com.yourcaryourway.P13_chat_backend.model.Message;
import org.mapstruct.Mapper;

import java.util.List;

// Cette annotation permet à MapStruct de générer un bean Spring pour le mapper
@Mapper(componentModel = "spring")
public interface MessageMapper {

    // Méthode pour mapper MessageRequest en Message (dommaine)
    Message toDomain(MessageRequest dto);

    // Méthode pour mapper Message (dommaine) en MessageResponse (DTO)
    MessageResponse toMessageResponse(Message domain);

    // Méthode pour mapper une liste de Message en liste de MessageResponse
    List<MessageResponse> toMessagesResponse(List<Message> domains);
}
