package com.employee.app.service;


import java.util.List;

import java.util.Optional;

import com.employee.app.dto.EmployeeDTO;
import com.employee.app.model.Employee;



public interface employeeService {


	List<Employee> employeelistAll();
	//Optional<Employee> findById(int id);
	Employee getById(int id);
	
	List<EmployeeDTO> getAllEmployees();
	Optional<EmployeeDTO> getEmployeeById(int id);
	Employee createEmployee(EmployeeDTO employee);
	boolean existsByEmail(String email);
	
} 
