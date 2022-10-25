package com.nology.springproject.job;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jrepo;
	
	//Write the service
	
	//get all jobs service 
	public List<Job> getAllJobs(){
		
		return jrepo.findAll(); //findAll is comeing from the jpa dependecies and interact with the db
	}
	
	//post jobs service 
	public Job createJob(JobDTO jobData) {
		Job j = new Job(jobData.getName() , jobData.getStartDate() , jobData.getEndDate());
		
		return jrepo.save(j);
		
	}
}
