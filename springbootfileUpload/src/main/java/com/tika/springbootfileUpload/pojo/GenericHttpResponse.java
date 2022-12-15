package com.tika.springbootfileUpload.pojo;

public class GenericHttpResponse {

	private String error;

	public GenericHttpResponse() {

	}

	public GenericHttpResponse(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
