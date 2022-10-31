package com.nology.springproject.job;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nology.springproject.temp.Temp;

@Entity

public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	//relationship between temp and job 
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "temp_id")
	@JsonBackReference
	private Temp temp;
	
	// constructor -> using getters and setters
	public Job(String name, LocalDate startDate, LocalDate endDate) {
		this.setName(name);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}
	// temp relationship setters and getters
	public Temp getTemp() {
		return temp;
	}
	public void setTemp(Temp temp) {
		this.temp = temp;
	}
	
	// default constructor 
	public Job() {
		
	}
	// setters and getters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
}
