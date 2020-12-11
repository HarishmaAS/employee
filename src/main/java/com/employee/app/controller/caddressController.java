package com.employee.app.controller;

import java.util.List;


import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.employee.app.exception.ResourceNotFoundException;
import com.employee.app.model.CorrespondenceAddress;
import com.employee.app.model.Employee;
import com.employee.app.repository.employeeRepository;
import com.employee.app.repository.correspondenceRepository;
import com.employee.app.service.employeeService;
import com.employee.app.service.caService;
@RestController
@RequestMapping("/api")
public class caddressController {

	@Autowired
	employeeRepository repo;
	correspondenceRepository repo1;

	@GetMapping("/{id}/address")
	public Employee getEmployee(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}

	@PutMapping("/{id}/address/{aid}")
    public CorrespondenceAddress updateCorrespondenceAddress(@RequestBody CorrespondenceAddress ca, @PathVariable("id") int id,@PathVariable("aid") int aid) {
		CorrespondenceAddress ccaa = this.repo1.findById(aid).orElseThrow(()-> new ResourceNotFoundException("Address not found"));
		ccaa.setHousename(ca.getHousename());
		ccaa.setStreet(ca.getStreet());
		ccaa.setPostoffice(ca.getPostoffice());
		ccaa.setDistrict(ca.getDistrict());
       return this.repo1.save(ccaa);
    }
	
	
//	@PostMapping(path="/employee/{id}/address",consumes= {"application/json"})
//	public CorrespondenceAddress addCorrespondenceAddres(@RequestBody CorrespondenceAddress ca,@PathVariable("id") int id)
//	{
//		repo1.save(ca);
//		return ca;
//	}
	
//	@DeleteMapping("/{id}/address/{aid}")
//	public String deleteEmployee(@PathVariable("id") int id,@PathVariable("aid") int aid)
//	{
//		CorrespondenceAddress c = repo1.getOne(aid);
//		repo1.delete(c);
//		return "deleted";
//	}

}
