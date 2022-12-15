package com.tika.springbootfileUpload.controllers;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.tika.springbootfileUpload.service.FileUploadService;

public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	@RequestMapping(path = "/fileUpload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Object> uploadDetils(@RequestParam String name, @RequestPart MultipartFile document) throws FileUploadException {
		String fileName = document.getName();
		try {
			fileUploadService.saveFile(document.getInputStream(), fileName);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	    return ResponseEntity.ok().build();
	}
}
