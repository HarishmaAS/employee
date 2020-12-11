package com.employee.app.dto;


import com.employee.app.model.CorrespondenceAddress;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CorrespondenceAddressDTO {
	

    private String housename;
    
    private String street;
    
    private String postoffice;
    
    private String district;
    

}
