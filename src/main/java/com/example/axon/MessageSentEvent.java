package com.example.axon;

import java.util.UUID;

import org.axonframework.serialization.Revision;

import lombok.Value;

@Value
@Revision("1.0")
public class MessageSentEvent {
	private UUID id;
	private String message;
}
