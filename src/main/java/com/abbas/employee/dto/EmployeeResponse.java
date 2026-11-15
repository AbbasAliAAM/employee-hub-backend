package com.abbas.employee.dto;

public class EmployeeResponse {
	private Integer id;
	private String name;
	private String designation;

	public EmployeeResponse() {
	}

	public EmployeeResponse(Integer id, String name, String designation) {
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
