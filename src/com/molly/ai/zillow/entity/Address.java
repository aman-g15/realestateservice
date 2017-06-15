package com.molly.ai.zillow.entity;

import javax.xml.bind.annotation.XmlElement;

public class Address {
	@XmlElement
	private String street;
	@XmlElement
	private String zipcode;
	@XmlElement
	private String city;
	@XmlElement
	private String state;
	@XmlElement
	private String latitude;
	@XmlElement
	private String longitude;

	}
