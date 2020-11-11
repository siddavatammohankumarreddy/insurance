package com.insurance.exception;

public class ErrorResponse {
	private String StatusCode;
	private String StatusMessage;

	public String getStatusCode() {
		return StatusCode;
	}

	public String getStatusMessage() {
		return StatusMessage;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}

}
