package com.gl.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.model.Employee;
import com.gl.ems.repository.EmployeeJpaRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final EmployeeJpaRepository employeeJpaRepository;

	public EmployeeServiceImpl(EmployeeJpaRepository employeeJpaRepository) {
		this.employeeJpaRepository = employeeJpaRepository;
	}

	@Override
	public Employee save(Employee employee) {
		return this.employeeJpaRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = this.employeeJpaRepository.findAll();
		return employees;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Optional<Employee> optionalEmployee = this.employeeJpaRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		throw new IllegalArgumentException("Enter valid Employee Id");
	}

	@Override
	public Employee deleteEmployeeById(int id) {
		this.employeeJpaRepository.deleteById(id);
		return null;
	}

}
