package com.abbas.employee.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.abbas.employee.dto.EmployeeRequest;
import com.abbas.employee.dto.EmployeeResponse;
import com.abbas.employee.entity.Employee;
import com.abbas.employee.exception.EmployeeNotFoundException;
import com.abbas.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository Emprepo;

	public EmployeeService(EmployeeRepository repo) {
		this.Emprepo = repo;
	}

	public EmployeeResponse createEmployee(EmployeeRequest request) {
		Employee employee = new Employee();

		employee.setName(request.getName());
		employee.setDesignation(request.getDesignation());
		Employee savedEmployee = Emprepo.save(employee);

		return new EmployeeResponse(savedEmployee.getId(), savedEmployee.getName(), savedEmployee.getDesignation());

	}

	public List<EmployeeResponse> getAllEmployee() {
		List<Employee> employees = Emprepo.findAll();
		return employees.stream().map(this::mapToResponse).toList();
	}

	public EmployeeResponse getEmployeeById(Integer id) {
		Employee employee = Emprepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		return mapToResponse(employee);
	}

	public EmployeeResponse updateEmployee(Integer id, Employee emp) {
		Employee existingEmp = Emprepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

		existingEmp.setName(emp.getName());
		existingEmp.setDesignation(emp.getDesignation());
		Employee updatedEmployee = Emprepo.save(existingEmp);
		return mapToResponse(updatedEmployee);
	}

	public boolean deleteEmployee(Integer id) {

		if (!Emprepo.existsById(id)) {
			throw new EmployeeNotFoundException(id);
		}

		Emprepo.deleteById(id);
		return true;
	}

	private EmployeeResponse mapToResponse(Employee employee) {

		return new EmployeeResponse(employee.getId(), employee.getName(), employee.getDesignation());
	}
}
