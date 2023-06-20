package com.assg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "employee_info")
@Entity
@Setter
@Getter
public class EmployeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeID;

	private String employeeName;

	private String gender;

	private Boolean pf;

	private Boolean graduity;

	private Boolean mealCard;

	private String officeLocation;

	private String employeeAddress;

	@Column(name = "employee_salary")
	private Float salary;
}
