package com.employee.app.converter;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import com.employee.app.dto.EmployeeDTO;
import com.employee.app.model.Employee;

@Component
public class EmployeeConverter {
//	public EmployeeDTO EmployeeToDTO(Employee employee) {
//		EmployeeDTO dto=new EmployeeDTO();
//        dto.setFirst_name(employee.getFirst_name());
//        dto.setLast_name(employee.getLast_name());
//        dto.setEmail(employee.getEmail());
//        dto.setPermanent_address(employee.getStatus());
//        dto.setCa(employee.getCa());        
//		return dto;		
//	}
//    public List<EmployeeDTO> EmployeeToDTO(List<Employee> employee){
//	return employee.stream().map(x ->EmployeeToDTO(x)).collect(Collectors.toList());	
//}
//
//    public Employee DTOToEmployee(EmployeeDTO dto) {
//	    Employee employee=new Employee();
//	    employee.setFirst_name(dto.getFirst_name());
//	    employee.setLast_name(dto.getLast_name());
//	    employee.setEmail(dto.getEmail());
//	    employee.setPermanent_address(dto.getStatus());
//	    employee.setCa(dto.getCa());
//		return employee;		
//	}
//    public List<Employee> DTOToEmployee(List<EmployeeDTO> dto){
//	return dto.stream().map(x ->DTOToEmployee(x)).collect(Collectors.toList());	
//    }


}
