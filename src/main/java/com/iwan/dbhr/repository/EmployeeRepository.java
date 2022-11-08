package com.iwan.dbhr.repository;

import org.springframework.stereotype.Repository;

import com.iwan.dbhr.model.Employee;
import com.iwan.dbhr.repository.generic.GenericRepository;

@Repository
public interface EmployeeRepository extends GenericRepository<Employee> {

}
