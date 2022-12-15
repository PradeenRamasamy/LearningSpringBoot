package com.tika.springbootfileUpload.service;

import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tika.springbootfileUpload.validtion.FileUploadValidation;

@Service
public class FileUploadService {
	@Autowired
	private FileUploadValidation fileuploadValidation;
	
	
	public String saveFile(InputStream stream,String fileName) throws FileUploadException {
		boolean isSaved = fileuploadValidation.isValidFileMIMEType(stream, fileName);
		if(isSaved) {
			return "Data saved successfully";
			
		}
		return "Data is not saved successfully;";
	}

}
