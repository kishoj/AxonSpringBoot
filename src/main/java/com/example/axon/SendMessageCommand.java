package com.example.axon;

import java.util.UUID;

import lombok.Value;

@Value
public class SendMessageCommand {
	private UUID id;
	private String message;
}
