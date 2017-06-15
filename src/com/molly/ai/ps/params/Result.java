package com.molly.ai.ps.params;

import org.springframework.stereotype.Component;

@Component
public class Result {
private String source;
private String resolvedQuery;
private String action;
private Boolean actionIncomplete;
private Parameters parameters;
private Contexts[] contexts;
private MetaData metadata;
private Fulfillment fulfillment;
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getResolvedQuery() {
	return resolvedQuery;
}
public void setResolvedQuery(String resolvedQuery) {
	this.resolvedQuery = resolvedQuery;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public Boolean getActionIncomplete() {
	return actionIncomplete;
}
public void setActionIncomplete(Boolean actionIncomplete) {
	this.actionIncomplete = actionIncomplete;
}
public Parameters getParameters() {
	return parameters;
}
public void setParameters(Parameters parameters) {
	this.parameters = parameters;
}
public Contexts[] getContexts() {
	return contexts;
}
public void setContexts(Contexts[] contexts) {
	this.contexts = contexts;
}
public MetaData getMetadata() {
	return metadata;
}
public void setMetadata(MetaData metadata) {
	this.metadata = metadata;
}
public Fulfillment getFulfillment() {
	return fulfillment;
}
public void setFulfillment(Fulfillment fulfillment) {
	this.fulfillment = fulfillment;
} 
}
