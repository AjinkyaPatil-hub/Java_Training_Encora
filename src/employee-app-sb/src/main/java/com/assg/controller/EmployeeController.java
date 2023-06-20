package com.assg.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assg.dto.EmployeDTO;
import com.assg.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/hello/{empName}")
	public String sayHii(@PathVariable("empName") String empName) {
		return "Hello " + empName + " Welcome " + new Date();
	}

	@PostMapping("/employee")
	public EmployeDTO saveEmployee(@RequestBody EmployeDTO employeeDTO) {
		return employeeService.saveOrUpdateEmployee(employeeDTO);
	}

	@GetMapping("/employee/{empId}")
	public EmployeDTO getEmployee(@PathVariable("empId") Integer empId) {
		return employeeService.getEmployeeById(empId);
	}

	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer empId) {
		return employeeService.deleteEmployeeById(empId);
	}
}
