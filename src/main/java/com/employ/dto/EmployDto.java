package com.employ.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;

}
