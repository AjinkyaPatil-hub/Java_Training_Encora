package com.encora.employee.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.encora.employee.common.utils.DBHelper;
import com.encora.employee.dto.EmployeDTO;
import com.encora.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	Connection conn = null;

	@Override
	public String saveEmployee(EmployeDTO employeeDTO) {

		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();
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
				DBHelper helper = DBHelper.getInstance();
				helper.closeConnection(conn);
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
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(
					"SELECT employee_id, employee_name, gender, pf, graduity, meal_card, office_location, employee_address, employee_salary FROM emp_db.employee_info where employee_id = ?;");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				copyDataFromDBToDTO(searchedEmployee, rs);
				return searchedEmployee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		return searchedEmployee;
	}

	@Override
	public void updateEmployee(EmployeDTO employeeDTO) {

		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE emp_db.employee_info SET employee_name=?, gender=?, pf=?, graduity=?, meal_card=?, office_location=?, employee_address=? WHERE employee_id=?;");
			ps.setString(1, employeeDTO.getEmployeeName());
			ps.setString(2, employeeDTO.getGender());
			ps.setBoolean(3, employeeDTO.getPf());
			ps.setBoolean(4, employeeDTO.getGraduity());
			ps.setBoolean(5, employeeDTO.getMealCard());
			ps.setString(6, employeeDTO.getOfficeLocation());
			// TODO float is giving problem in saving the value
//			ps.setFloat(7, employeeDTO.getSalary());
			ps.setString(7, employeeDTO.getEmployeeAddress());
			ps.setInt(8, employeeDTO.getEmployeeID());
			ps.execute();
			System.out.println("Employee updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
	}

	@Override
	public boolean deleteEmployee(int empId) {
		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM emp_db.employee_info WHERE employee_id=?;");
			ps.setInt(1, empId);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection();

		}
	}

	@Override
	public EmployeDTO findFirstEmployee() {
		long be = System.currentTimeMillis();
		EmployeDTO firstEmployee = new EmployeDTO();
		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();
			// ResultSet.TYPE_SCROLL_INSENSITIVE --> is used to move the rs in backword
			// direction as well
			// ResultSet.CONCUR_UPDATABLE --> concurent update must be allowed
			PreparedStatement ps = conn.prepareStatement("select * from emp_db.employee_info;",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				copyDataFromDBToDTO(firstEmployee, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		System.out.println("Toatal time: "+(System.currentTimeMillis() - be));
		return firstEmployee;
	}

	@Override
	public EmployeDTO findLastEmployee() {
		EmployeDTO firstEmployee = new EmployeDTO();
		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();
			// ResultSet.TYPE_SCROLL_INSENSITIVE --> is used to move the rs in backword
			// direction as well
			// ResultSet.CONCUR_UPDATABLE --> concurent update must be allowed
			PreparedStatement ps = conn.prepareStatement("select * from emp_db.employee_info;",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.last()) {
				copyDataFromDBToDTO(firstEmployee, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return firstEmployee;
	}

	@Override
	public EmployeDTO findNextEmployee(int empId) {
		EmployeDTO nextEmployee = new EmployeDTO();
		// if employee_id is not present after clicking next button it will display
		// first record from the db.
		if (empId == 0) {
			return findFirstEmployee();
		}
		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();

			PreparedStatement ps = conn.prepareStatement(
					"select * from emp_db.employee_info where employee_id  = (select min(employee_id) from emp_db.employee_info where employee_id  > ?);",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				copyDataFromDBToDTO(nextEmployee, rs);
			} else {
				System.out.println("Record not present");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return nextEmployee;
	}

	@Override
	public EmployeDTO findPrevEmployee(int empId) {
		EmployeDTO prevEmployee = new EmployeDTO();
		// if employee_id is not present after clicking next button it will display
		// first record in the db.
		if (empId == 0) {
			return findFirstEmployee();
		}
		try {
			DBHelper helper = DBHelper.getInstance();
			conn = helper.getMySQLConnection();

			PreparedStatement ps = conn.prepareStatement(
					"select * from emp_db.employee_info where employee_id  = (select max(employee_id) from emp_db.employee_info where employee_id  < ?);",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				copyDataFromDBToDTO(prevEmployee, rs);
			} else {
				System.out.println("Record not present");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return prevEmployee;
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

	private void closeConnection() {
		try {
			DBHelper.getInstance().closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception occured while closing Database Connection " + e.getMessage());
		}
	}

}
