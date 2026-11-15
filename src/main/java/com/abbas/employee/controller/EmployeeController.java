package com.abbas.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abbas.employee.dto.EmployeeRequest;
import com.abbas.employee.dto.EmployeeResponse;
import com.abbas.employee.entity.Employee;
import com.abbas.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService empService;

	public EmployeeController(EmployeeService employeeService) {
		this.empService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> createEmployee( @Valid @RequestBody EmployeeRequest empRequest) {
		 System.out.println("CONTROLLER REACHED");

		EmployeeResponse savedEmployee = empService.createEmployee(empRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getAllEmp() {

		List<EmployeeResponse> employees = empService.getAllEmployee();
		
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmpById(@PathVariable int id) {

		EmployeeResponse emp = empService.getEmployeeById(id);

		return ResponseEntity.ok(emp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee updatedEmp) {

		EmployeeResponse updatedEmployee = empService.updateEmployee(id, updatedEmp);

		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {

		empService.deleteEmployee(id);

		return ResponseEntity.noContent().build();
	}
	@GetMapping("/test-error")
	public ResponseEntity<String> testError() {

	    throw new RuntimeException("Testing 500 error");

	}
}