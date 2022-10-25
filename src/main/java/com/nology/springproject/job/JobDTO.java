package com.nology.springproject.job;

import java.time.LocalDate;

import com.sun.istack.NotNull;

// DTO is similar to job entity without constructors and ID
public class JobDTO {

	@NotNull
	private String name;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	
	// getters and setters
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

