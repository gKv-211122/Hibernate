package com.hiber;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Student {

	@Id
	private int id;  // primary key, class
	
	private String firstName;
	private String lastName;
	private String email;
	
	private Certificate certi;
	
	public Student() {
		super();
		
	}
	

	public Student(int id, String firstName, String lastName, String email, Certificate certi) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.certi = certi;
	}

	// getters and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public Certificate getCerti() {
		return certi;
	}


	public void setCerti(Certificate certi) {
		this.certi = certi;
	}


	@Override
	public String toString() {

		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
