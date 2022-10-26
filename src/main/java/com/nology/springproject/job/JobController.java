package com.nology.springproject.job;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nology.springproject.temp.Temp;
import com.nology.springproject.temp.TempDTO;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Job>> getJob(@PathVariable Long id){
		
		Optional<Job> job = jservice.getJob(id);
		
		//check
		if(job.isEmpty()) {
			
			return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(job, HttpStatus.OK);
	}
	
	//controller to call the update service
@PatchMapping("/{id}")
	
	public ResponseEntity<Job> jobPatch(@PathVariable Long id, @RequestBody JobDTO jobData){
		
		Job job = jservice.jobUpdate(id, jobData);
		
		//check
				if(job == null) {
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
				}
				
				return new ResponseEntity<>(job, HttpStatus.OK);
		
}

//controller for the delete service
	@DeleteMapping("/{id}")
	public ResponseEntity<String> jobDelete(@PathVariable Long id) {
		
		String job = jservice.jobDelete(id);
		if(job == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}


}
