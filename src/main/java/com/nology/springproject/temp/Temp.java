package com.nology.springproject.temp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nology.springproject.job.Job;

@Entity
public class Temp {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private long id;
private String firstName;
private String lastName;


//relationship between Temp and Job

@OneToMany(mappedBy = "temp" , cascade = CascadeType.ALL)
private List<Job> jobList;

public Temp(String firstName, String lastName) {
	
	this.setFirstName(firstName);
	this.setLastName( lastName);
}

//default constructor
public Temp() {
	
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

//relationship methods

public List<Job> getJobArr() {
	return jobList;
}
public void setJobArr(List<Job> jobList) {
	this.jobList = jobList;
}


}
