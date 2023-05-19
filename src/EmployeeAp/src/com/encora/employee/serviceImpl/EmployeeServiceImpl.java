package com.encora.employee.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.encora.employee.dto.EmployeDTO;
import com.encora.employee.service.EmployeeService;
import com.mysql.cj.jdbc.Driver;

public class EmployeeServiceImpl implements EmployeeService {
	Connection conn = null;

	@Override
	public String saveEmployee(EmployeDTO employeeDTO) {

		try {
			conn = getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO emp_db.employee_info\r\n"
					+ "(employee_name, gender, pf, graduity, meal_card, office_location, employee_salary, employee_address)\r\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);\r\n" + "");
			ps.setString(1, employeeDTO.getEmployeeName());
			ps.setString(2, employeeDTO.getGender());
			ps.setBoolean(3, employeeDTO.getPf());
			ps.setBoolean(4, employeeDTO.getGraduity());
			ps.setBoolean(5, employeeDTO.getMealCard());
			ps.setString(6, employeeDTO.getOfficeLocation());
			ps.setFloat(7, employeeDTO.getSalary());
			ps.setString(8, employeeDTO.getEmployeeAddress());
			ps.execute();
			System.out.println("Employee Saved Successfully");
			return "Employee Saved Successfully";
		} catch (SQLException e) {
			e.getStackTrace();
			System.out.println("Exception occured while perfoming Database Connection " + e.getMessage());
			return "Exception occured while perfoming Database Connection" + e.getMessage();
		} catch (NumberFormatException nfs) {
			nfs.getStackTrace();
			System.out.println("Please check entered values " + nfs.getMessage());
			return "Please check entered values" + nfs.getMessage();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Please check entered values " + e.getMessage());
			return "Please check entered values" + e.getMessage();
		} finally {
			try {
				closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Exception occured while closing Database Connection " + e.getMessage());
				return "Exception occured while closing Database Connection" + e.getMessage();
			}

		}
	}

	@Override
	public EmployeDTO searchEmployee(int empId) {
		EmployeDTO searchedEmployee = null;
		try {
			searchedEmployee = new EmployeDTO();
			conn = getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(
					"SELECT employee_id, employee_name, gender, pf, graduity, meal_card, office_location, employee_address, employee_salary FROM emp_db.employee_info where employee_id = ?;");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				searchedEmployee.setEmployeeID(rs.getInt(1));
				searchedEmployee.setEmployeeName(rs.getString(2));
				searchedEmployee.setGender(rs.getString(3));
				searchedEmployee.setPf(rs.getBoolean(4));
				searchedEmployee.setGraduity(rs.getBoolean(5));
				searchedEmployee.setMealCard(rs.getBoolean(6));
				searchedEmployee.setOfficeLocation(rs.getString(7));
				searchedEmployee.setEmployeeAddress(rs.getString(8));
				searchedEmployee.setSalary(rs.getFloat(9));
				return searchedEmployee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return searchedEmployee;
	}
	
	@Override
	public void updateEmployee(EmployeDTO employeeDTO) {
	
		try {
			conn = getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE emp_db.employee_info SET employee_name=?, gender=?, pf=?, graduity=?, meal_card=?, office_location=?, employee_address=? WHERE employee_id=?;");
			ps.setString(1, employeeDTO.getEmployeeName());
			ps.setString(2, employeeDTO.getGender());
			ps.setBoolean(3, employeeDTO.getPf());
			ps.setBoolean(4, employeeDTO.getGraduity());
			ps.setBoolean(5, employeeDTO.getMealCard());
			ps.setString(6, employeeDTO.getOfficeLocation());
			//TODO float is giving problem in saving the value
//			ps.setFloat(7, employeeDTO.getSalary());
			ps.setString(7, employeeDTO.getEmployeeAddress());
			ps.setInt(8, employeeDTO.getEmployeeID());
			ps.execute();
			System.out.println("Employee updated..");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getMySQLConnection() throws SQLException {
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection("jdbc:mysql://localhost:3000", "root", "root123");
	}

	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
