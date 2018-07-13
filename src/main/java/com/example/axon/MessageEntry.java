package com.example.axon;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class MessageEntry {
	@Id
	private UUID id;
	private String message;
}