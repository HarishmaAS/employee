package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.converter.EmployeeConverter;
import com.employee.app.dto.EmployeeDTO;
import com.employee.app.model.Employee;
import com.employee.app.model.CorrespondenceAddress;
import com.employee.app.repository.employeeRepository;
import com.employee.app.service.employeeService;

@RestController
@RequestMapping("/dtoapi")
public class employeedtoController {
	@Autowired
	employeeService service;
	EmployeeConverter converter;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") int id){
		return ResponseEntity.ok().body(service.getEmployeeById(id).get());
	}
	
	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees(){
		return service.getAllEmployees();
	}
	 
	 @PostMapping("/employees")
	 public Employee createEmployee(@RequestBody EmployeeDTO e) {
	        boolean isExists = service.existsByEmail(e.getEmail());
	        if (!isExists) {
	        	e.setStatus("ACTIVE");
	    		return service.createEmployee(e);
	        }
			return null;
	    }

//	 @GetMapping("/employeess")
//		public List<EmployeeDTO> getAllEmployees(){
//		    List<Employee> findAll=repo.findAll();
//			return converter.EmployeeToDTO(findAll);
//		} 
//	
	
}
