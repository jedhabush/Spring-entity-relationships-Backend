package com.nology.springproject.job;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.nology.springproject.temp.Temp;

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
	
	//get specific ID
	
	public Optional<Job> getJob(Long id){
		
		return jrepo.findById(id);
	}
	
	
	//update method
	public Job jobUpdate(Long id , JobDTO jobData) {
		
		Optional<Job> job = getJob(id);
		if(job.isEmpty()) return null;
		
		Job existentJob = jrepo.findById(id).get();
		
		
		if(jobData.getName() != null && !jobData.getName().equals("")) {
			existentJob.setName(jobData.getName());
		}
		
		
		if(jobData.getStartDate() != null && !jobData.getStartDate().equals("")) {
			existentJob.setStartDate(jobData.getStartDate());
		}
		
		if(jobData.getEndDate() != null && !jobData.getEndDate().equals("")) {
			existentJob.setEndDate(jobData.getEndDate());
		}
		
		return jrepo.save(existentJob);
	}
	
	//Delete method
	public String jobDelete(Long id ) {
		Optional<Job> fetchJob = getJob(id);
		if(fetchJob.isEmpty()) return null;
		jrepo.deleteById(id);
		
		return  "";
	}

}
