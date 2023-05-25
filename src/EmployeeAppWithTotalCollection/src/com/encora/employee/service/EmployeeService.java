package com.encora.employee.service;

import com.encora.employee.dto.EmployeDTO;

public interface EmployeeService {

	public String saveEmployee(EmployeDTO employeeDTO);
	
	public EmployeDTO searchEmployee(int empId);
	
	public String updateEmployee(EmployeDTO employeeDTO);

	public boolean deleteEmployee(int empId);

	public EmployeDTO findFirstEmployee();

	public EmployeDTO findLastEmployee();

	public EmployeDTO findNextEmployee(int empId);

	public EmployeDTO findPrevEmployee(int prevEmpId);
	
	
}
