package com.molly.ai.zillow.entity;

import javax.xml.bind.annotation.XmlElement;

public class Message {
	@XmlElement
	String text;
	@XmlElement
	int code;
	
}