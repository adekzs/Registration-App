package com.adeks.registration.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import java.io.InputStream
;

public class Student implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String middleName;
	private String surName;
	private String address;
	private String phone;
	private String email;
	


	private InputStream inputstream;
	
		
	public Student() {
		
	}
	
	public Student(Integer id, String firstName, String middleName, String surName, String address, String phone,
			String email, InputStream inputstream) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surName = surName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.inputstream = inputstream;
	}
	
	
	
	
	public InputStream getInputstream() {
		return inputstream;
	}

	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getSurName() {
		return surName;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}

	
	
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", middleName=" + middleName + ", surName=" + surName + ", address="
				+ address + ", phone=" + phone + ", email=" + email + ", id=" + id +"]";
	}
	
	
	
	
}
