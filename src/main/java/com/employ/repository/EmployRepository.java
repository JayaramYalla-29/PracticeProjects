package com.employ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employ.entity.Employee;

public interface EmployRepository extends JpaRepository<Employee, Long> {

}
