package com.employee.app.controller;

import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.employee.app.converter.EmployeeConverter;
import com.employee.app.dto.EmployeeDTO;
import com.employee.app.exception.ResourceNotFoundException;
import com.employee.app.model.CorrespondenceAddress;
import com.employee.app.model.Employee;
import com.employee.app.repository.employeeRepository;
import com.employee.app.repository.correspondenceRepository;
import com.employee.app.service.employeeService;
import com.employee.app.service.caService;
@RestController
@RequestMapping("/api")
public class employeeController {

	@Autowired
	employeeRepository repo;
	correspondenceRepository repo1;
	
	//Rest APIS for crud operation
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping("/")
	public List<Employee> getEmployees()
	{
		return repo.findAll();

	}
	 
	 @PostMapping(path="/employee",consumes= {"application/json"})
	 public Employee addEmployee(@RequestBody Employee e) {
	        boolean isExists = repo.existsByEmail(e.getEmail());
	        if (!isExists) {
	        	e.setStatus("ACTIVE");
	    		repo.save(e);
	    		return e;
	        }
			return null;
	    }
//	@PutMapping("/{id}")
//	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
//		Employee employee = repo.findById(id);
//	       employee.setFirst_name(emp.getFirst_name());
//		   employee.setLast_name(emp.getLast_name());
//		   employee.setEmail(emp.getEmail());
//		   employee.setPermanent_address(emp.getPermanent_address());
//
//	    return repo.save(employee);
//	}
	
	@PutMapping(path="/employee",consumes= {"application/json"})
	public Employee UpdateEmployee(@RequestBody Employee emp)
	{
		repo.save(emp);
		return emp;
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		Employee a = repo.getOne(id);
		repo.delete(a);
		return "deleted";
	}
	
	@PostMapping("status/{id}")
	public Employee disableStatus(@PathVariable("id") int id) {
		
		Employee employeeObj =repo.findById(id);
		employeeObj.setStatus("IN-ACTIVE");
		return repo.save(employeeObj);
	}

}


//@PostMapping(path="/employee",consumes= {"application/json"})
//public Employee addEmployee(@RequestBody Employee emp)
//{
//	emp.setStatus("active");
//	repo.save(emp);
//	return emp;
//}



	
//	  @PutMapping("/{id}")
//    public CorrespondenceAddress updateAddress(@RequestBody CorrespondenceAddress ca, @PathVariable("id") int id) {
//	  CorrespondenceAddress c = this.repo1.findById(id) .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
//       c.setHousename(ca.getHousename());
//   	   c.setStreet(ca.getStreet());
//   	   c.setPostoffice(ca.getPostoffice());
//   	   c.setDistrict(ca.getDistrict());
//       return this.repo1.save(c);
//  }	
//	@Autowired
//	private employeeService service;
//	private caService service1;
//	employeeRepository repo;
//	correspondenceRepository repo1;
//
//	@PostMapping("/emp")
//	public List<Employee> employeeList() {
//	List<Employee> emp = service.employeelistAll();
//		return emp;
//	}
//	
//	//Starting Point of Spring-Boot App
//
//	@GetMapping("/view")
//	public ModelAndView mv(Model model) {
//		model.addAttribute("Employee", service.employeelistAll());
//		ModelAndView mv = new ModelAndView("Index");
//		return mv;
//	}
//	
////	@PostMapping(path="/employee",consumes="application/json")
////	public Employee addEmployee(@RequestBody Employee emp) {
////		repo.save(emp);
////		return emp;
////	}
//	@DeleteMapping("/employee/{id}")
//	public String deleteEmployee(@PathVariable("id") int id) {
//		Employee emp= repo.getOne(id);
//		repo.delete(emp);
//		return "deleted";
//	}
//	
//	@PutMapping(path="/employee",consumes="application/json")
//	public Employee updateEmployee(@RequestBody Employee emp) {
//		repo.save(emp);
//		return emp;
//	}
//	//Function Return Employee By ID
//
//	@RequestMapping("/employeedetails/{id}")
//	public ModelAndView employee(@PathVariable("id") int id, Model model) {
//
//		System.out.println("id==========" + id);
//
//		Optional<Employee> emp = service.findById(id);
//
//		if (emp.isPresent())
//
//		model.addAttribute("details", emp.get());
//		ModelAndView mv = new ModelAndView("Employee");
//		return mv;
//
//}
//	
//	@PostMapping("/caddress")
//	public List<CorrespondenceAddress> caList() {
//
//	List<CorrespondenceAddress> ca = service1.calistAll();
//		return ca;
//	}
//	@GetMapping("/")
//	public ModelAndView mv1(Model model1) {
//		model1.addAttribute("CorrespondenceAddress", service1.calistAll());
//		ModelAndView mv1 = new ModelAndView("Index");
//		return mv1;
//	}
////	@PutMapping(path="/caddress",consumes="application/json")
////	public CorrespondenceAddress addCorrespondenceAddress(@RequestBody CorrespondenceAddress ca) {
////		repo1.save(ca);
////		return ca;
////	}
//	@DeleteMapping("/caddress/{id}")
//	public String deleteCaddress(@PathVariable("id") int id) {
//		CorrespondenceAddress ca= repo1.getOne(id);
//		repo1.delete(ca);
//		return "deleted";
//	}
//	@PutMapping(path="/caddress",consumes="application/json")
//	public CorrespondenceAddress updateCorrespondenceAddress(@RequestBody CorrespondenceAddress ca) {
//		repo1.save(ca);
//		return ca;
//	}
//	
//	@RequestMapping("/employecaddress/{id}")
//	public ModelAndView employeeca(@PathVariable("id") int id, Model model1) {
//
//		System.out.println("id==========" + id);
//
//		Optional<CorrespondenceAddress> ca = service1.findById(id);
//
//		if (ca.isPresent())
//
//		model1.addAttribute("caddress", ca.get());
//		ModelAndView mv1 = new ModelAndView("CorrespondenceAddress");
//		return mv1;
//		
//
//}


//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.employee.app.model.Employee;
//import com.employee.app.exception.ResourceNotFoundException;
//import com.employee.app.repository.employeeRepository;
//
//@RestController
//@RequestMapping("/api/users")
//public class employeeController {
//
//    @Autowired
//    private employeeRepository employeeRepository;
//
//    // get all users
//   @GetMapping
//    public List < Employee > getAllUsers() {
//        return this.employeeRepository.findAll();
//    }
//
//    // get user by id
//    @GetMapping("/{id}")
//    public Employee getUserById(@PathVariable(value = "id") int userId) {
//        return this.employeeRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//    }
//
//    // create user
//    @PostMapping
//    public Employee createUser(@RequestBody Employee emp) {
//       return this.employeeRepository.save(emp);
//    }
//
//    // update user
//    @PutMapping("/{id}")
//     public Employee updateUser(@RequestBody Employee user, @PathVariable("id") int userId) {
//    	Employee existingEmployee = this.employeeRepository.findById(userId)
//           .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//        existingEmployee.setFirst_name(user.getFirst_name());
//        existingEmployee.setLast_name(user.getLast_name());
//        existingEmployee.setEmail(user.getEmail());
//        existingEmployee.setPermanent_address(user.getPermanent_address());
//        return this.employeeRepository.save(existingEmployee);
//    }
//
//    // delete user by id
//    @DeleteMapping("/{id}")
//    public ResponseEntity < Employee > deleteUser(@PathVariable("id") int userId) {
//    	Employee existingEmployee = this.employeeRepository.findById(userId)
//            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//        this.employeeRepository.delete(existingEmployee);
//       return ResponseEntity.ok().build();
//   }
//    
//
//}