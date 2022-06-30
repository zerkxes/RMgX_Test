package com.aniket.Assets2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.Assets2.Repository.EmployeeRepository;
import com.aniket.Assets2.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee addEmp(Employee e) {
		empRepo.save(e);
		return e;
	}
}
