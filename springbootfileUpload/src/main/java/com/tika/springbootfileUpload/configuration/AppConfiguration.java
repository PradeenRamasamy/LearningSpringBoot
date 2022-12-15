package com.tika.springbootfileUpload.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.tika.detect.CompositeDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.microsoft.POIFSContainerDetector;
import org.apache.tika.parser.pkg.ZipContainerDetector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfiguration {
	@Bean
	  public Detector getDefaultDectector()
	  {
		     
		        List<Detector> detectors = new ArrayList<>();

		        // zip compressed container types
		        detectors.add(new ZipContainerDetector());
		        // Microsoft stuff
		        detectors.add(new POIFSContainerDetector());
		        // mime magic detection as fallback
		        detectors.add(MimeTypes.getDefaultMimeTypes());

		        Detector detector = new CompositeDetector(detectors);
		    

		    return detector;
		}
}
