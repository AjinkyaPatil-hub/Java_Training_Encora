package com.encora.employee.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.encora.employee.dto.EmployeDTO;

public class EmployeeCache {

	public List<EmployeDTO> employeeList;

	public static EmployeeCache employeeCache = new EmployeeCache();

	private EmployeeCache() {

	}

	public List<EmployeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeDTO> employeeList) {
		this.employeeList = employeeList;
	}

	public static EmployeeCache getInstance() {
		// double check if object gets garbage collector after some time...
		if (employeeCache == null) {
			employeeCache = new EmployeeCache();
		}
		return employeeCache;
	}

	public void refresEmployeeCache() {
		employeeList = new ArrayList<>();
		populateSomeDummyData();
	}

	private void populateSomeDummyData() {
		EmployeDTO emp1 = new EmployeDTO(101, "Ajinkya", "Male", true, false, true, "Pune", "Pune-Solapur", 5454f);
		EmployeDTO emp2 = new EmployeDTO(102, "Dipesh-Sir", "Male", true, true, true, "Pune", "mumbai-pune", 58454f);
		employeeList.add(emp1);
		employeeList.add(emp2);
	}
}
