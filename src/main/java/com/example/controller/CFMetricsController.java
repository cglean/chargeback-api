package com.example.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.domain.ApplicationStats;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CFMetricsController {

	
	@RequestMapping(value="/getmetrics", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public static List<ApplicationStats> getMetrics(){
		
	 CloudCredentials credentials = new CloudCredentials("amit.bansal@capgemini.com", "trtr22");
	        CloudFoundryClient client = new CloudFoundryClient(credentials, getTargetURL("https://api.run.pivotal.io"));
	        client.login();
	        List<ApplicationStats> applicationDataList = new ArrayList<>();
	        for (CloudApplication application : client.getApplications()) {
	        	applicationDataList.add(client.getApplicationStats(application.getName()));
	        
	        }
	        return applicationDataList;

	}
	
	
	@RequestMapping(value="/getapps", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public static List<CloudApplication> getApplication(){
		
	 CloudCredentials credentials = new CloudCredentials("amit.bansal@capgemini.com", "trtr22");
	        CloudFoundryClient client = new CloudFoundryClient(credentials, getTargetURL("https://api.run.pivotal.io"));
	        client.login();
	        
	        return client.getApplications();

	}

	private static URL getTargetURL(String target) {
	        try {
	            return URI.create(target).toURL();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("The target URL is not valid: " + e.getMessage());
	        }
	    }
}
