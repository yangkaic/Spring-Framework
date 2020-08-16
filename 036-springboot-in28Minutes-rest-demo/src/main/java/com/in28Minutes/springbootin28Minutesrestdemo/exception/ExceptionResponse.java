package com.in28Minutes.springbootin28Minutesrestdemo.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	
	private String message;
	
	private String details;
	
	public ExceptionResponse() {}

	public ExceptionResponse(Date timeStamp, String message, String details) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	


}
