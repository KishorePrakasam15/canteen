package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.EmployeeEntity;
import com.app.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@PostMapping("add")
	public ResponseEntity addEmployee(@RequestBody EmployeeEntity empDetails) {
		int empId = empDetails.getEmpId();
		boolean exist = empRepo.existsById(empId);
		if(exist) {
			return (ResponseEntity) ResponseEntity.badRequest();
		}
		empRepo.save(empDetails);
		return (ResponseEntity) ResponseEntity.ok(empDetails);
	}
	
	@GetMapping("/view")
	public Optional<EmployeeEntity> getDataByempId(@RequestParam int empId){
		return empRepo.findById(empId);
	}
	@GetMapping("/emp")
	public List<EmployeeEntity> getAllEmployee(){
		return empRepo.findAll();
	
	}
}
