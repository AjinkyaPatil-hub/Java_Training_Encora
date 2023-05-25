package com.encora.employee.serviceImpl;

import java.sql.Connection;
import java.util.List;

import com.encora.employee.common.utils.EmployeeCache;
import com.encora.employee.dto.EmployeDTO;
import com.encora.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	Connection conn = null;
	int employeeID = 1;

	@Override
	public String saveEmployee(EmployeDTO employeeDTO) {
		long startTime = System.currentTimeMillis();
		// generate radndom ID (We can also use Math.random() to generate unique ID)
		employeeDTO.setEmployeeID(employeeID);
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		employeeCache.getEmployeeList().add(employeeDTO);
		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
		employeeID = employeeID + 1;
		return "Employee Saved Successfully";
	}

	@Override
	public EmployeDTO searchEmployee(int empId) {
		long startTime = System.currentTimeMillis();
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeDTO> employeeList = cache.getEmployeeList();
		for (EmployeDTO dto : employeeList) {
			if (dto.getEmployeeID() == empId) {
				System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
				return dto;
			}
		}
		return null;
	}

	@Override
	public String updateEmployee(EmployeDTO employeeDTO) {
		long startTime = System.currentTimeMillis();

		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeDTO> employeeList = cache.getEmployeeList();
		// get employee by ID
		for (EmployeDTO dto : employeeList) {
			if (dto.getEmployeeID() == employeeDTO.getEmployeeID()) {
				dto.setEmployeeName(employeeDTO.getEmployeeName());
				dto.setGender(employeeDTO.getGender());
				dto.setEmployeeAddress(employeeDTO.getEmployeeAddress());
				dto.setPf(employeeDTO.getPf());
				dto.setGraduity(employeeDTO.getGraduity());
				dto.setMealCard(employeeDTO.getMealCard());
				dto.setOfficeLocation(employeeDTO.getOfficeLocation());
				dto.setSalary(employeeDTO.getSalary());
				return "Employee updated successfully..";
			}
		}
		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
		return "Employee not found to update..";
	}

	@Override
	public boolean deleteEmployee(int empId) {
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeDTO> employeeList = cache.getEmployeeList();
		int index = -1;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmployeeID() == empId) {
				index = i;
			}
		}
		if (index >= 0) {
			employeeList.remove(index);
			return true;
		} else
			return false;
	}

	@Override
	public EmployeDTO findFirstEmployee() {
		long startTime = System.currentTimeMillis();
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeDTO> employeeList = cache.getEmployeeList();
		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
		return employeeList.get(0);
	}

	@Override
	public EmployeDTO findLastEmployee() {
		long startTime = System.currentTimeMillis();
		EmployeeCache cache = EmployeeCache.getInstance();
		EmployeDTO employeDTO = cache.getEmployeeList().get(cache.getEmployeeList().size() - 1);
		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
		return employeDTO;
	}

	@Override
	public EmployeDTO findNextEmployee(int empId) {
		long startTime = System.currentTimeMillis();
		// if employee_id is not present after clicking next button it will display
		// first record from the db.
		if (empId == 0) {
			return findFirstEmployee();
		}

		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeDTO> employeeList = cache.getEmployeeList();
		int index = 0;
		// iterate over list and find the index of the current employee
		for (int i = 0; i < employeeList.size(); i++) {
			EmployeDTO dto = employeeList.get(i);
			if (dto.getEmployeeID() == empId) {
				index = i;
				break;
			}
		}
		// edge case if employee ID is last in the list
		if (index == employeeList.size() - 1) {
			return null;
		}

		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
		return employeeList.get(index + 1);
	}

	@Override
	public EmployeDTO findPrevEmployee(int empId) {
		long startTime = System.currentTimeMillis();
		// if employee_id is not present after clicking next button it will display
		// first record in the db.
		if (empId == 0) {
			return findFirstEmployee();
		}
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeDTO> employeeList = cache.getEmployeeList();
		int index = 0;
		for (int i = 0; i < employeeList.size(); i++) {
			EmployeDTO dto = employeeList.get(i);
			if (dto.getEmployeeID() == empId) {
				index = i;
				break;
			}
		}
		if (index == 0) {
			return null;
		}

		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
		return employeeList.get(index - 1);
	}
}
