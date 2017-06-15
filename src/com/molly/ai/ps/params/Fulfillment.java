package com.molly.ai.ps.params;

import org.springframework.stereotype.Component;

@Component
public class Fulfillment {
private String speech;
private Messages[] messages;
public String getSpeech() {
	return speech;
}
public void setSpeech(String speech) {
	this.speech = speech;
}
public Messages[] getMessages() {
	return messages;
}
public void setMessages(Messages[] messages) {
	this.messages = messages;
}
}
