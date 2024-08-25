package com.employ.service;

import java.util.List;

import com.employ.dto.EmployDto;


public interface EmployeeService {
	EmployDto createEmployee(EmployDto employdto);
	
	EmployDto getEmployeeById(Long employId);
	
	List<EmployDto> getAllEmployees();
	
	EmployDto updateEmployeeById(Long employId,EmployDto updatedEmployee);
	
	void deleteEmployeeById(Long employId);

}
