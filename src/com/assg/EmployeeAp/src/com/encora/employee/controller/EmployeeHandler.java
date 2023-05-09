package com.encora.employee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encora.employee.dto.EmployeDTO;
import com.encora.employee.view.EmployeeFrame;

public class EmployeeHandler implements ActionListener {

	EmployeeFrame ef;

	public EmployeeHandler(EmployeeFrame employeeFrame) {
		this.ef = employeeFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().toLowerCase();

		EmployeDTO dto = getEmployee(ef);
		switch (action) {
		case "save":
			saveOrUpdate(dto);
			break;
		case "update":
			saveOrUpdate(dto);
			break;
		case "search":
			EmployeDTO employee = searchEmployeeByID(dto.getEmployeeID());
			break;
		case "delete":
			boolean isEmployeeDeleted = deleteEmployeeByID(dto.getEmployeeID());
			break;
		default:
			break;
		}
	}

	private boolean deleteEmployeeByID(int employeeID) {
		// TODO Auto-generated method stub
		return false;
	}

	private EmployeDTO searchEmployeeByID(int employeeID) {
		// TODO Auto-generated method stub
		return null;
	}

	private void saveOrUpdate(EmployeDTO dto) {

	}

	private EmployeDTO getEmployee(EmployeeFrame ef) {
		EmployeDTO empDTO = new EmployeDTO();
		empDTO.setEmployeeID(Integer.parseInt(ef.getEmployeeIdTxt().getText()));
		empDTO.setEmployeeName(ef.getEmployeeNameTxt().getText());
		empDTO.setGender(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		empDTO.setPf(ef.getPfOption().getState());
		empDTO.setGraduity(ef.getGradutiyOption().getState());
		empDTO.setMealCard(ef.getMealCardOption().getState());
		empDTO.setOfficeLocation(ef.getOfficeLocation().getSelectedItem());
		empDTO.setEmployeeAddress(ef.getEmployeeAddressTxtArea().getText());
		System.out.println(empDTO);
		return empDTO;
	}

}
