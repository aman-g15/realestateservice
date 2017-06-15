package com.molly.ai.zillow.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "searchresults")
public class ZillowResponseObject {
	@XmlElement
	private Request request;
	@XmlElement
	private Message message;
	@XmlElement
	private Response response;
}
