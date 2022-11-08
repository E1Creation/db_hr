package com.iwan.dbhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwan.dbhr.model.Employee;
import com.iwan.dbhr.repository.generic.GenericRepository;
import com.iwan.dbhr.service.generic.GenericService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService extends GenericService<Employee> {
    private GenericRepository<Employee> eRepository;
}
