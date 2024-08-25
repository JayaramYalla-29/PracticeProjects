package com.employ.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employ.dto.EmployDto;
import com.employ.entity.Employee;
import com.employ.exception.ResourceNotFoundException;
import com.employ.mapper.EmployeMapper;
import com.employ.repository.EmployRepository;
import com.employ.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployRepository emprepo;

	@Override
	public EmployDto createEmployee(EmployDto employdto) {
		Employee employee = EmployeMapper.maptoEmployee(employdto);
		Employee savedEmployee = emprepo.save(employee);
		return EmployeMapper.mapToEmployDto(savedEmployee);
	}

	@Override
	public EmployDto getEmployeeById(Long employId) {
		Employee employee = emprepo.findById(employId).orElseThrow(() -> new ResourceNotFoundException("Employ is not exist with given Id" + employId));
		return EmployeMapper.mapToEmployDto(employee);
	}

	@Override
	public List<EmployDto> getAllEmployees() {
		List<Employee> employees = emprepo.findAll();
		return employees.stream().map((employee) -> EmployeMapper.mapToEmployDto(employee)).collect(Collectors.toList());
	}


	@Override
	public EmployDto updateEmployeeById(Long employId, EmployDto updatedEmployee) {
		Employee employee = emprepo.findById(employId).orElseThrow(
				() -> new ResourceNotFoundException("Employ is not exist with given Id" + employId) );
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmployeeobj = emprepo.save(employee);
		return EmployeMapper.mapToEmployDto(updatedEmployeeobj);
	}

	@Override
	public void deleteEmployeeById(Long employId) {
		Employee employee = emprepo.findById(employId).orElseThrow(() -> new ResourceNotFoundException("Employ is not exist with given Id" + employId));
		emprepo.deleteById(employId);
		
	}

}
