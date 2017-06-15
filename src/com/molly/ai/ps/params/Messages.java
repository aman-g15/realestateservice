package com.molly.ai.ps.params;

import org.springframework.stereotype.Component;

@Component
public class Messages {
private Number type;
private String speech;
public Number getType() {
	return type;
}
public void setType(Number type) {
	this.type = type;
}
public String getSpeech() {
	return speech;
}
public void setSpeech(String speech) {
	this.speech = speech;
}
}
