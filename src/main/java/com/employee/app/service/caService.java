package com.employee.app.service;


import java.util.List;

import java.util.Optional;

import com.employee.app.model.CorrespondenceAddress;



public interface caService {


	List<CorrespondenceAddress> calistAll();
	

	Optional<CorrespondenceAddress> findById(int aid);
	
} 