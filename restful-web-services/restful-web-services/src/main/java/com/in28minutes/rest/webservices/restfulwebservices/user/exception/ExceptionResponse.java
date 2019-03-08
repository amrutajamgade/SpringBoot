package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import java.util.Date;

public class ExceptionResponse {

	
	private Date timestamp;
	private String error_message;
	private String error_details;
	private String error_code;
	
	public ExceptionResponse() {
		
	}
	
	public ExceptionResponse(Date timestamp, String error_message, String error_details, String error_code) {
		super();
		this.timestamp = timestamp;
		this.error_message = error_message;
		this.error_details = error_details;
		this.error_code = error_code;
	}
	
	
	
	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", error_message=" + error_message + ", error_details="
				+ error_details + ", error_code=" + error_code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error_code == null) ? 0 : error_code.hashCode());
		result = prime * result + ((error_details == null) ? 0 : error_details.hashCode());
		result = prime * result + ((error_message == null) ? 0 : error_message.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionResponse other = (ExceptionResponse) obj;
		if (error_code == null) {
			if (other.error_code != null)
				return false;
		} else if (!error_code.equals(other.error_code))
			return false;
		if (error_details == null) {
			if (other.error_details != null)
				return false;
		} else if (!error_details.equals(other.error_details))
			return false;
		if (error_message == null) {
			if (other.error_message != null)
				return false;
		} else if (!error_message.equals(other.error_message))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getError_message() {
		return error_message;
	}

	
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String getError_details() {
		return error_details;
	}

	public void setError_details(String error_details) {
		this.error_details = error_details;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	
	
	

}
