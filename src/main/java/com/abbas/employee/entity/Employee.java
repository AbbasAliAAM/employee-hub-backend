package com.abbas.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String designation;

	// No-argument constructor
	public Employee() {
	}

	// All-argument constructor
	public Employee(String name, String designation) {

		this.name = name;
		this.designation = designation;
	}

	// Getter and Setter for id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Getter and Setter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getter and Setter for designation
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}