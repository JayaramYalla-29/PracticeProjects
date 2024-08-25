package com.employ.mapper;

import com.employ.dto.EmployDto;
import com.employ.entity.Employee;

public class EmployeMapper {
	
	public static EmployDto mapToEmployDto (Employee employee) {
		return new EmployDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
	public static Employee maptoEmployee (EmployDto employDto) {
		return new Employee(
				employDto.getId(),
				employDto.getFirstName(),
				employDto.getLastName(),
				employDto.getEmail()
				);
	}

}
