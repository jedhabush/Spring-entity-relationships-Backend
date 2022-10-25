package com.nology.springproject.temp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Temp {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private long id;
private String firstName;
private String lastName;
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


}
