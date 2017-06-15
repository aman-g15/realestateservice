package com.molly.ai.zillow.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Zestimate {
	@XmlElement
	private double amount;
	@XmlElement(name = "last-updated")
	private Date lastUpdated;
	@XmlElement
	private String oneWeekChange;
	@XmlElement
	private double valueChange;
	@XmlElement
	private ValuationRange valuationRange;
	@XmlElement
	private double percentile;

	}
