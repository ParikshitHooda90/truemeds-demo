package com.truemeds.stringutilityservice.domain;

//@Getter
//@Setter
//@NoArgsConstructor
public class CommonResponse {
	private String message;
	private boolean success;
	private String statusCode;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
