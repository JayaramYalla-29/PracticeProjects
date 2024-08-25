package com.employ.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employ.dto.EmployDto;
import com.employ.service.EmployeeService;
import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService empservice;
	
	@PostMapping
	public ResponseEntity<EmployDto> createEmployee(@RequestBody EmployDto employDto){
		 EmployDto savedEmploy = empservice.createEmployee(employDto);
		 return new ResponseEntity<EmployDto>(savedEmploy, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployDto> getEmployById(@PathVariable("id") Long employId){
		EmployDto employDto = empservice.getEmployeeById(employId);
		return ResponseEntity.ok(employDto);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployDto>> getAllEmployees(){
		List<EmployDto> employees = empservice.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployDto> updateEmployeeById(@PathVariable("id") Long employId,@RequestBody EmployDto updatedEmployee){
		EmployDto employee = empservice.updateEmployeeById(employId, updatedEmployee);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employId) {
		empservice.deleteEmployeeById(employId);
		return ResponseEntity.ok("Employ deleted successfully!");
	}
	

}
