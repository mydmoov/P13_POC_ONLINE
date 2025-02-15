package com.yourcaryourway.P13_chat_backend.mappers;

import com.yourcaryourway.P13_chat_backend.controller.payload.MessageRequest;
import com.yourcaryourway.P13_chat_backend.controller.payload.MessageResponse;
import com.yourcaryourway.P13_chat_backend.model.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-15T18:34:27+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message toDomain(MessageRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setContent( dto.content() );
        message.setSender( dto.sender() );

        return message;
    }

    @Override
    public MessageResponse toMessageResponse(Message domain) {
        if ( domain == null ) {
            return null;
        }

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setContent( domain.getContent() );
        messageResponse.setSender( domain.getSender() );

        return messageResponse;
    }

    @Override
    public List<MessageResponse> toMessagesResponse(List<Message> domains) {
        if ( domains == null ) {
            return null;
        }

        List<MessageResponse> list = new ArrayList<MessageResponse>( domains.size() );
        for ( Message message : domains ) {
            list.add( toMessageResponse( message ) );
        }

        return list;
    }
}
