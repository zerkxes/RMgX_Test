package com.aniket.Assets2.Repository;

import org.springframework.data.repository.CrudRepository;

import com.aniket.Assets2.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
