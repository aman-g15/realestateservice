package com.molly.ai.ps.params;

import org.springframework.stereotype.Component;

@Component
public class Contexts {
private String name;
private Parameters parameters;
private Number lifespan;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Parameters getParameters() {
	return parameters;
}
public void setParameters(Parameters parameters) {
	this.parameters = parameters;
}
public Number getLifespan() {
	return lifespan;
}
public void setLifespan(Number lifespan) {
	this.lifespan = lifespan;
}
}
