package com.example.axon;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.util.UUID;

@Aggregate
public class Message  {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Message.class);
	
	@AggregateIdentifier
	private UUID id;
	
	@SuppressWarnings("unused")
	private String message;

	public Message() {
	}

	@CommandHandler
	public Message(SendMessageCommand command) {
		LOGGER.info("SendMessageCommand command received in Aggregate");
		LOGGER.info("Preparing MessageSentEvent event to fire...");
		apply(new MessageSentEvent(command.getId(), command.getMessage()));
	}

	@EventSourcingHandler
	public void on(MessageSentEvent event) {
		LOGGER.info("Update aggregate from MessageSentEvent");
		this.id = event.getId();
		this.message = event.getMessage();
	}

}