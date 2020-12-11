package com.employee.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.employee.app.dto.EmployeeDTO;
import com.employee.app.model.Employee;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsByEmail(String email);
	Employee findById(int id);


}