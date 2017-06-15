package com.molly.ai.zillow.entity;

import javax.xml.bind.annotation.XmlElement;

public class Request {
	@XmlElement
	private String address;
	@XmlElement
	private String citystatezip;
	
}
