package com.example.axon;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageRestController {
	
	private static final Logger LOGGER = getLogger(MessageRestController.class);
	
	@Autowired
    private CommandGateway commandGateway;
	
    @GetMapping("/send")
	public String sendMessage() {
    	LOGGER.info("Sending Message Command from RestController");
    	commandGateway.send(new SendMessageCommand(UUID.randomUUID(), "Hello Axon Spring CQRS Test"));		
		return "Success";
    }

}