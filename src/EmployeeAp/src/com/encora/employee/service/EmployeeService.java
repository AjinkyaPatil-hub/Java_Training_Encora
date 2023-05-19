package com.encora.employee.service;

import com.encora.employee.dto.EmployeDTO;

public interface EmployeeService {

	public String saveEmployee(EmployeDTO employeeDTO);
	
	public EmployeDTO searchEmployee(int empId);
	
	public void updateEmployee(EmployeDTO employeeDTO);
	
}
