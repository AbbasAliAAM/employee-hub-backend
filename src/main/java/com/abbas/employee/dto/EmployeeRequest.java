package com.abbas.employee.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeRequest {
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Designation is required")
	private String designation;

	public EmployeeRequest() {
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
