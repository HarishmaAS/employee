package com.employee.app.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.employee.app.converter.EmployeeConverter;
import com.employee.app.dto.EmployeeDTO;
import com.employee.app.model.Employee;
import com.employee.app.repository.employeeRepository;
import com.employee.app.service.employeeService;

@SuppressWarnings("unused")
@Service
@Transactional
public class employeeserviceImpl implements  employeeService{

	
private final employeeRepository repo;

    public employeeserviceImpl(employeeRepository repo) {
    	this.repo=repo;
    }

	@Override
	public List<Employee> employeelistAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
    
//	@Override
//	public Optional<Employee> findById(int id) {
//		// TODO Auto-generated method stub
//		 return repo.findById(id);
//	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeDTO> list=new ArrayList<>();
		List<Employee> employees=this.repo.findAll();
		for(Employee emp:employees) {
			list.add(new EmployeeDTO(emp.getFirst_name(),emp.getLast_name(),emp.getEmail(),emp.getPermanent_address(),emp.getStatus(),emp.getCa()));
		}
		return list;
	}

	@Override
	public Optional<EmployeeDTO> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee=this.repo.findById(id);
		return Optional.of(new EmployeeDTO(employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),employee.getPermanent_address(),employee.getStatus(),employee.getCa()));
	}

	@Override
	public Employee createEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		return this.repo.save(new Employee(employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),employee.getPermanent_address(),employee.getStatus(),employee.getCa()));
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
    
   



}
