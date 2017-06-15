package com.molly.ai.zillow.entity;

import javax.xml.bind.annotation.XmlElement;

public class Result {
	@XmlElement
	private long zpid;
	@XmlElement
	private Links links;
	@XmlElement
	private Address address;
	@XmlElement
	private long FIPScounty;
	@XmlElement
	private String useCode;
	@XmlElement
	private int taxAssessmentYear;
	@XmlElement
	private double taxAssessment;
	@XmlElement
	private double lotSizeSqFt;
	@XmlElement
	private int bathrooms;
	@XmlElement
	private int bedrooms;
	@XmlElement
	private Zestimate zestimate;
	@XmlElement
	private LocalRealEstate localRealEstate;
	}
