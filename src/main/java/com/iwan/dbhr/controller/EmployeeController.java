package com.iwan.dbhr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iwan.dbhr.controller.generic.GenericController;
import com.iwan.dbhr.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends GenericController<Employee> {

}
