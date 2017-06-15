package com.molly.ai.ps.params;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseObject {
	private String speech;
	private String displayText;
	private List<String> data;
	private String[] contextOut;
	private String source;

	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public String[] getContextOut() {
		return contextOut;
	}

	public void setContextOut(String[] contextOut) {
		this.contextOut = contextOut;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
