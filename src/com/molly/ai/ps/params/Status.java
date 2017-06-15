package com.molly.ai.ps.params;

import org.springframework.stereotype.Component;

@Component
public class Status {
	private Number code;
	private String errorType;
	public Number getCode() {
		return code;
	}
	public void setCode(Number code) {
		this.code = code;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
