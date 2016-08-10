package com.example.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.domain.ApplicationStats;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CFMetricsController {

	@RequestMapping(value = "/getmetrics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ApplicationStats> getMetrics() {

		CloudFoundryClient client = loginCloudFoundry();
		List<ApplicationStats> applicationDataList = new ArrayList<>();
		for (CloudApplication application : client.getApplications()) {
			applicationDataList.add(client.getApplicationStats(application.getName()));

		}
		return applicationDataList;

	}

	
	/**
	 * This Controller fetches the free available resource based on the Resource Type at the Org Level
	 * @param resourceType
	 * @return
	 */
	@RequestMapping(value = "/getFreeResource/{resourceType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFreeResource(@PathVariable String resourceType) {

		CloudFoundryClient client = loginCloudFoundry();

		if (resourceType.equals("MEM")) {
			long memoryquota = client.getQuotaByName("trial", true).getMemoryLimit() * 1024 * 1024;

			for (CloudApplication application : client.getApplications()) {
				memoryquota = memoryquota
						- ((client.getApplicationStats(application.getName()).getRecords().get(0).getUsage().getMem()));
			}
			return String.valueOf(memoryquota);
		} else if (resourceType.equals("CPU")) {
			double cpuQuota = 1.0;
			for (CloudApplication application : client.getApplications()) {
				cpuQuota = cpuQuota
						- ((client.getApplicationStats(application.getName()).getRecords().get(0).getUsage().getMem()));
			}
			return String.valueOf(cpuQuota);
		} else {
			// TODO : Not implemented for Disk usage 
			return null;
		}
	}

	private URL getTargetURL(String target) {
		try {
			return URI.create(target).toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException("The target URL is not valid: " + e.getMessage());
		}
	}

	private CloudFoundryClient loginCloudFoundry() {
		CloudCredentials credentials = new CloudCredentials("amit.bansal@capgemini.com", "trtr22");
		CloudFoundryClient client = new CloudFoundryClient(credentials, getTargetURL("https://api.run.pivotal.io"));
		client.login();
		return client;
	}
}
