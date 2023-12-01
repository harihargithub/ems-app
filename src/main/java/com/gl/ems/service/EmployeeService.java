package com.gl.ems.service;

import java.util.List;

import com.gl.ems.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	
	List<Employee> findAll();
	
	Employee findEmployeeById(int id);
	
	Employee deleteEmployeeById(int id);

}
