package com.nology.springproject.temp;

import com.sun.istack.NotNull;

public class TempDTO {
	@NotNull
	public String firstName;
	@NotNull
	public String lastName;
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

}
