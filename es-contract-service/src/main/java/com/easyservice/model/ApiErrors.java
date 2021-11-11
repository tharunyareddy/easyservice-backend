/**
 *
 */
package com.easyservice.model;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDateTime;

public class ApiErrors {
	LocalDateTime timestap;
	String message;
	int status;
	String error;

	public LocalDateTime getTimestap() {
		return timestap;
	}

	public void setTimestap(LocalDateTime timestap) {
		this.timestap = timestap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ApiErrors(LocalDateTime timestap, String message, int status, String error) {
		super();
		this.timestap = timestap;
		this.message = message;
		this.status = status;
		this.error = error;
	}

	public ApiErrors() {
		super();
		// TODO Auto-generated constructor stub
	}

}
