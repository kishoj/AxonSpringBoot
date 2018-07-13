package com.example.axon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntry, String> {
	MessageEntry findOneByMessageId(String messageId);
}