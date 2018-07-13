package com.example.axon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageEntry {
	@Id
    @GeneratedValue
    private long id;
	
    private String messageId;
    
    private String message;
    
    public MessageEntry() { }
    
    public MessageEntry(String messageId, String message) {
    	this.messageId = messageId;
    	this.message = message;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
