package com.shenzhen.teamway.util;

import java.io.Serializable;

public class JsonMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2246047050140216499L;
	private String success;
	private String code;
	private String message;
	private Object data;
	private String status;

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}