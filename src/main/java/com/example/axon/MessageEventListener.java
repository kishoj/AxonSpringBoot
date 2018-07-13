package com.example.axon;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageEventListener {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MessageEventListener.class);
	
	private MessageRepository repository;

	@Autowired
	public MessageEventListener(MessageRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(MessageSentEvent event) {
		LOGGER.info("MessageSentEvent Handled from MessageEventListener to persist in database");
		repository.save(new MessageEntry(event.getId(), event.getMessage()));
	}

}
