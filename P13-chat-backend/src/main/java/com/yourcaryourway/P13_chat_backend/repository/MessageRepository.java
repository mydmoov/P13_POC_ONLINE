package com.yourcaryourway.P13_chat_backend.repository;


import com.yourcaryourway.P13_chat_backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
