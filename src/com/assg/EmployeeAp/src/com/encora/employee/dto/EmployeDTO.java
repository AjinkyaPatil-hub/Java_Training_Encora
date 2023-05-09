package com.encora.employee.dto;


public class EmployeDTO {

private int employeeID;
	
	private String employeeName;
	
	private String gender;
	
	private Boolean pf;
	
	private Boolean graduity;
	
	private Boolean mealCard;
	
	private Boolean nps;
	
	private Boolean medilcaim;
	
	private String officeLocation;
	
	private String employeeAddress;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getPf() {
		return pf;
	}

	public void setPf(Boolean pf) {
		this.pf = pf;
	}

	public Boolean getGraduity() {
		return graduity;
	}

	public void setGraduity(Boolean graduity) {
		this.graduity = graduity;
	}

	public Boolean getMealCard() {
		return mealCard;
	}

	public void setMealCard(Boolean mealCard) {
		this.mealCard = mealCard;
	}

	public Boolean getNps() {
		return nps;
	}

	public void setNps(Boolean nps) {
		this.nps = nps;
	}

	public Boolean getMedilcaim() {
		return medilcaim;
	}

	public void setMedilcaim(Boolean medilcaim) {
		this.medilcaim = medilcaim;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "EmployeDTO [employeeID=" + employeeID + ", employeeName=" + employeeName + ", gender=" + gender
				+ ", pf=" + pf + ", graduity=" + graduity + ", mealCard=" + mealCard + ", nps=" + nps + ", medilcaim="
				+ medilcaim + ", officeLocation=" + officeLocation + ", employeeAddress=" + employeeAddress + "]";
	}

}
