package com.tika.springbootfileUpload.validtion;

import static com.tika.springbootfileUpload.constant.GenericConstant.MIMETYPES;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.tika.Tika;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;

public class FileUploadValidation implements GenericValidation {

	@Autowired
	private Tika tika;
	@Autowired
	public Detector detecor;

	/**
	 * @param stream
	 * @throws FileUploadException
	 */
	public boolean isValidFileMIMEType(InputStream stream, String fileName) throws FileUploadException {

		try {
			Metadata metadata = new Metadata();
			metadata.add(Metadata.RESOURCE_NAME_KEY, fileName);
			TikaInputStream tikaStream = TikaInputStream.get(stream);
			String fileInputTypes = detecor.detect(tikaStream, metadata).toString();
			boolean isValid = Arrays.stream(MIMETYPES).anyMatch(fileInputTypes::contains);
			if (!isValid) {
				throw new FileUploadException("invalid input File informtion");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return true;
	}

}
