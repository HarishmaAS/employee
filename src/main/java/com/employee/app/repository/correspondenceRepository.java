package com.employee.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.app.model.CorrespondenceAddress;

@Repository
public interface correspondenceRepository extends JpaRepository<CorrespondenceAddress, Integer> {

	

}