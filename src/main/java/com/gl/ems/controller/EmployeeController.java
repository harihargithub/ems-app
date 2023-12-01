package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.ems.model.Employee;
import com.gl.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = this.employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employees") Employee employee) {
		this.employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employees/list";
	}

}
