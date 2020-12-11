package com.employee.app.impl;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.employee.app.model.CorrespondenceAddress;
import com.employee.app.repository.correspondenceRepository;
import com.employee.app.service.caService;

@SuppressWarnings("unused")
@Service
@Transactional
public class caserviceImpl implements caService{

	
private final correspondenceRepository repo1;
	
    public caserviceImpl(correspondenceRepository repo1) {
    	this.repo1=repo1;
    }

	@Override
	public List<CorrespondenceAddress> calistAll() {
		// TODO Auto-generated method stub
		return repo1.findAll();
	}
    
		  

	

	@Override
	public Optional<CorrespondenceAddress> findById(int aid) {
		// TODO Auto-generated method stub
		 return repo1.findById(aid);
	}
    
   



}
