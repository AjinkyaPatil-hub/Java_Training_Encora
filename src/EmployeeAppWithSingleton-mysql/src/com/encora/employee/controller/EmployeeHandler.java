package com.encora.employee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encora.employee.dto.EmployeDTO;
import com.encora.employee.service.EmployeeService;
import com.encora.employee.serviceImpl.EmployeeServiceImpl;
import com.encora.employee.view.EmployeeFrame;

public class EmployeeHandler implements ActionListener {

	EmployeeFrame ef;
	EmployeeService employeeService;

	public EmployeeHandler(EmployeeFrame employeeFrame) {
		this.ef = employeeFrame;
		this.employeeService = new EmployeeServiceImpl();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ef.getDisplayOutputTxt().setText("");
			String action = e.getActionCommand().toLowerCase();
			ef.getDisplayOutputTxt().setBounds(133, 516, 200, 50);
			EmployeDTO dto = null;
			switch (action) {
			case "save":
				dto = getEmployee(ef);
				String saveEmployee = employeeService.saveEmployee(dto);
				ef.getDisplayOutputTxt().setText(saveEmployee);
				break;
			case "update":
				dto = getEmployee(ef);
				employeeService.updateEmployee(dto);
				break;
			case "search":
				EmployeDTO searchedEmployee = employeeService
						.searchEmployee(Integer.parseInt(ef.getEmployeeIdTxt().getText()));
				System.out.println("Searched Employee:  " + searchedEmployee);
				int employeeIdFromUI = Integer.parseInt(ef.getEmployeeIdTxt().getText());
				if (employeeIdFromUI == searchedEmployee.getEmployeeID())
					printOnUI(searchedEmployee);
				else
					clearTextFromUI();
				ef.getDisplayOutputTxt().setText("Employee not found for ID: " + ef.getEmployeeIdTxt().getText());

				break;
			case "delete":
				int empID = Integer.parseInt(ef.getEmployeeIdTxt().getText());
				boolean deletedEmployee = employeeService.deleteEmployee(empID);
				if (deletedEmployee) {
					ef.getDisplayOutputTxt().setText("Employee Deleted successfully ");
				} else {
					ef.getDisplayOutputTxt().setText("Employee ID not found ");
				}

				break;
			case "first":
				EmployeDTO firstEmp = employeeService.findFirstEmployee();
				printOnUI(firstEmp);
				break;
			case "last":
				EmployeDTO lastEmp = employeeService.findLastEmployee();
				printOnUI(lastEmp);
				break;
			case "next":
				int nextEmpId = 0;
				if (ef.getEmployeeIdTxt().getText().length() > 0) {
					nextEmpId = Integer.parseInt(ef.getEmployeeIdTxt().getText());
				}
				EmployeDTO nextEmp = employeeService.findNextEmployee(nextEmpId);
				System.out.println(nextEmp);
				if (nextEmp != null) {
					printOnUI(nextEmp);
				} else {
					clearTextFromUI();
					ef.getDisplayOutputTxt().setText("Next Employee not found. ");
				}
				break;
			case "prev":
				int prevEmpId = 0;
				if (ef.getEmployeeIdTxt().getText().length() > 0) {
					prevEmpId = Integer.parseInt(ef.getEmployeeIdTxt().getText());
				}
				EmployeDTO prevEmp = employeeService.findPrevEmployee(prevEmpId);
				System.out.println(prevEmp);
				if (prevEmp != null) {
					printOnUI(prevEmp);
				} else {
					clearTextFromUI();
					ef.getDisplayOutputTxt().setText("Prev Employee not found. ");
				}
				break;
			case "clear":
				clearTextFromUI();
			default:
				break;
			}
		} catch (NumberFormatException nfs) {
			ef.getDisplayOutputTxt().setText("Please enter correct value " + nfs.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			ef.getDisplayOutputTxt().setText(ex.getMessage());
		}
	}

	private void clearTextFromUI() {
		ef.getEmployeeIdTxt().setText("");
		ef.getEmployeeNameTxt().setText("");
		ef.getMaleOption().setState(false);
		ef.getFemaleOption().setState(false);
		ef.getOtherOption().setState(false);
		ef.getOfficeLocation().insert("", 0);
		ef.getEmployeeSalaryTxt().setText("");
		ef.getEmployeeAddressTxtArea().setText("");
	}

	private void printOnUI(EmployeDTO searchedEmployee) {
		ef.getEmployeeIdTxt().setText("" + searchedEmployee.getEmployeeID());
		ef.getEmployeeNameTxt().setText(searchedEmployee.getEmployeeName());
		if ("Male".equalsIgnoreCase(searchedEmployee.getGender())) {
			ef.getMaleOption().setState(true);
		} else if ("Female".equalsIgnoreCase(searchedEmployee.getGender())) {
			ef.getFemaleOption().setState(true);
		} else {
			ef.getOtherOption().setState(true);
		}
		ef.getPfOption().setState(searchedEmployee.getPf());
		ef.getGradutiyOption().setState(searchedEmployee.getGraduity());
		ef.getMealCardOption().setState(searchedEmployee.getMealCard());
		ef.getOfficeLocation().select(searchedEmployee.getOfficeLocation());

		ef.getEmployeeAddressTxtArea().setText(searchedEmployee.getEmployeeAddress());
		ef.getEmployeeSalaryTxt().setText(searchedEmployee.getSalary() + "");

		System.out.println("Printed On UI");
	}

	private EmployeDTO getEmployee(EmployeeFrame ef) {
		EmployeDTO empDTO = new EmployeDTO();
		try {
			empDTO.setEmployeeID(Integer.parseInt(ef.getEmployeeIdTxt().getText()));
			empDTO.setEmployeeName(ef.getEmployeeNameTxt().getText());
			empDTO.setGender(ef.getGenderGroup().getSelectedCheckbox().getLabel());
			empDTO.setPf(ef.getPfOption().getState());
			empDTO.setGraduity(ef.getGradutiyOption().getState());
			empDTO.setMealCard(ef.getMealCardOption().getState());
			empDTO.setOfficeLocation(ef.getOfficeLocation().getSelectedItem());
			empDTO.setEmployeeAddress(ef.getEmployeeAddressTxtArea().getText());
			empDTO.setSalary(Float.parseFloat(ef.getEmployeeSalaryTxt().getText()));
			System.out.println(empDTO);
			return empDTO;
		} catch (NumberFormatException nfs) {
			throw new NumberFormatException("Please check entered values.." + nfs.getMessage());
		}
	}

}
