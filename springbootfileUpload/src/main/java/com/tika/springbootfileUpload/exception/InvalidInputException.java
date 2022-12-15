package com.tika.springbootfileUpload.exception;

public class InvalidInputException extends RuntimeException {

	 private static final long serialVersionUID = -7806029002430564887L;

	    private String message;

	    public InvalidInputException() {
	    }

	    public InvalidInputException(String message) {
	        this.message = message;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

}
