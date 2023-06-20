package com.assg.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assg.dto.EmployeDTO;
import com.assg.entity.EmployeModel;
import com.assg.repository.EmployeeRepo;
import com.assg.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeDTO saveOrUpdateEmployee(EmployeDTO employeeDTO) {
		if (employeeDTO.getEmployeeID() != null) {
			Optional<EmployeModel> foundEmp = employeeRepo.findById(employeeDTO.getEmployeeID());
			if (foundEmp.isPresent()) {
				// update the employee
				EmployeModel emp = foundEmp.get();
				emp.setEmployeeName(employeeDTO.getEmployeeName());
				emp.setGender(employeeDTO.getGender());
				emp.setEmployeeAddress(employeeDTO.getEmployeeAddress());
				emp.setGraduity(employeeDTO.getGraduity());
				emp.setMealCard(employeeDTO.getMealCard());
				emp.setPf(employeeDTO.getPf());
				emp.setSalary(employeeDTO.getSalary());
				EmployeModel save = employeeRepo.save(emp);
				return mapper.map(save, EmployeDTO.class);
			}
		}
		// save the employee
		EmployeModel saveEmployee = mapper.map(employeeDTO, EmployeModel.class);
		EmployeModel savedEmployee = employeeRepo.save(saveEmployee);
		return mapper.map(savedEmployee, EmployeDTO.class);
	}

	@Override
	public EmployeDTO getEmployeeById(Integer employeeId) {

		Optional<EmployeModel> foundEmp = employeeRepo.findById(employeeId);
		if (foundEmp.isPresent()) {
			return mapper.map(foundEmp, EmployeDTO.class);
		}
		return null;
	}

	@Override
	public String deleteEmployeeById(Integer employeeId) {
		employeeRepo.deleteById(employeeId);
		return "Employee deleted";
	}

}
