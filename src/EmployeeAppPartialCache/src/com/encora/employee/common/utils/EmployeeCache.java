package com.encora.employee.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		try {
			DBHelper helper = DBHelper.getInstance();
			Connection conn = helper.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("select * from emp_db.employee_info;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeDTO dto = new EmployeDTO();
				copyDataFromDBToDTO(dto, rs);
				employeeList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void copyDataFromDBToDTO(EmployeDTO firstEmployee, ResultSet rs) throws SQLException {
		firstEmployee.setEmployeeID(rs.getInt(1));
		firstEmployee.setEmployeeName(rs.getString(2));
		firstEmployee.setGender(rs.getString(3));
		firstEmployee.setPf(rs.getBoolean(4));
		firstEmployee.setGraduity(rs.getBoolean(5));
		firstEmployee.setMealCard(rs.getBoolean(6));
		firstEmployee.setOfficeLocation(rs.getString(7));
		firstEmployee.setEmployeeAddress(rs.getString(8));
		firstEmployee.setSalary(rs.getFloat(9));
	}

}
