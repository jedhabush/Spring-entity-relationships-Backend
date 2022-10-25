package com.nology.springproject.job;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//creating default url or endpoint
@RequestMapping(value = "/job")

public class JobController {
	@Autowired
	private JobService jservice;
	
	// Get all jobs API request
	@GetMapping
	public List<Job> getAllJobs(){
		return jservice.getAllJobs();
		
	}
	
	// Post or create job API request
	@PostMapping
	public Job createJob(@Valid @RequestBody JobDTO jobData) {
		
		return jservice.createJob(jobData);
		
	}

}
