package com.assg.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeDTO {

	private Integer employeeID;

	private String employeeName;

	private String gender;

	private Boolean pf;

	private Boolean graduity;

	private Boolean mealCard;

	private String officeLocation;

	private String employeeAddress;

	private Float salary;

}
