package com.employee.app.dto;

import java.util.List;

import com.employee.app.model.CorrespondenceAddress;
import com.employee.app.model.Employee;
import com.employee.app.model.Employee.EmployeeBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String first_name;
    
    private String last_name;
    
    private String email;
    
    private String permanent_address;
    
    private String status;
    
    private List<CorrespondenceAddress> ca;
    

    


//	public Employee ToEmployee() {
//
//		return new Employee().builder();
//				
//	}

}
