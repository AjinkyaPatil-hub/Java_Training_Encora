package com.assg.service;

import com.assg.dto.EmployeDTO;

public interface EmployeeService {

	public EmployeDTO saveOrUpdateEmployee(EmployeDTO employeeDTO);
	
	public EmployeDTO getEmployeeById(Integer employeeId);
	
	public String deleteEmployeeById(Integer employeeId);
}
