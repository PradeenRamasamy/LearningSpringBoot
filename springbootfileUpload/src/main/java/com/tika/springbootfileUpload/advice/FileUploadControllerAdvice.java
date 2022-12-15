package com.tika.springbootfileUpload.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tika.springbootfileUpload.exception.InvalidInputException;

@ControllerAdvice
public class FileUploadControllerAdvice {

	@ResponseBody
	@ExceptionHandler(InvalidInputException.class)
	ResponseEntity<String> handleInconsistentEditException(InvalidInputException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
	}

}
