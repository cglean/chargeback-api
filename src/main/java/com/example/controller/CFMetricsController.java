package com.example.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import java.util.Map;

import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.domain.ApplicationStats;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudService;
import org.cloudfoundry.client.lib.domain.CloudSpace;
import org.cloudfoundry.client.lib.domain.InstancesInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CFMetricsController {

	
	@RequestMapping(value="/getmetrics", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public static ApplicationStats getMetrics(){
		
	 CloudCredentials credentials = new CloudCredentials("amit.bansal@capgemini.com", "trtr22");
	        CloudFoundryClient client = new CloudFoundryClient(credentials, getTargetURL("https://api.run.pivotal.io"));
	        client.login();
	        Map<String, Integer> map = client.getApplications().get(0).getResources();
	        
	        System.out.println(map.toString());
	        ApplicationStats applicationStats = client.getApplicationStats("spring-music");
	        applicationStats.getRecords().get(0);
	        
	        System.out.println("Disk:: " + applicationStats.getRecords().get(0).getUsage().getDisk());
	        System.out.println("Spaces:");
	        for (CloudSpace space : client.getSpaces()) {
	            System.out.printf("  %s\t(%s)%n", space.getName(), space.getOrganization().getName());
	        }
	        
	        System.out.printf("%nApplications:%n");
	        for (CloudApplication application : client.getApplications()) {
	            System.out.printf("  %s%n", application.getName());
	        }

	        System.out.printf("%nServices%n");
	        for (CloudService service : client.getServices()) {
	            System.out.printf("  %s\t(%s)%n", service.getName(), service.getLabel());
	        }
	        
	        return applicationStats;

	}
	
	
	@RequestMapping(value="/getapps", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public static InstancesInfo getApplication(){
		
	 CloudCredentials credentials = new CloudCredentials("amit.bansal@capgemini.com", "trtr22");
	        CloudFoundryClient client = new CloudFoundryClient(credentials, getTargetURL("https://api.run.pivotal.io"));
	        client.login();
	        
	        return client.getApplicationInstances("spring-music");

	}

	private static URL getTargetURL(String target) {
	        try {
	            return URI.create(target).toURL();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("The target URL is not valid: " + e.getMessage());
	        }
	    }
}
