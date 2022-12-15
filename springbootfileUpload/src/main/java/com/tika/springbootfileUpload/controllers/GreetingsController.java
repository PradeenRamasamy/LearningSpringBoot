package com.tika.springbootfileUpload.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tika.springbootfileUpload.util.TikaAnalysis;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */

	
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        
    	InputStream stream=this.getClass().getClassLoader().getResourceAsStream("jar.pdf");
    	try {
    		Metadata metadata = new Metadata();
            metadata.add(Metadata.RESOURCE_NAME_KEY, "jar");
            TikaInputStream tikaStream=  TikaInputStream.get(stream);
         //  name=  detecor.detect(tikaStream, metadata).toString();
		 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "Hello " + name + "!";
        
    }
}
