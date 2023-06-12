package com.assg.model;

public class AnnualReport {

	private int year;
	private String industryAggregationNZSIOC;
	private String industryCodeNZSIOC;
	private String industryNameNZSIOC;
	private String units;
	private String variableCode;
	private String variableName;
	private String variableCategory;
	private String value;
	private String industryCodeANZSIC06;

	public AnnualReport() {
	}

	public AnnualReport(int year, String industryAggregationNZSIOC, String industryCodeNZSIOC,
			String industryNameNZSIOC, String units, String variableCode, String variableName, String variableCategory,
			String value, String industryCodeANZSIC06) {
		super();
		this.year = year;
		this.industryAggregationNZSIOC = industryAggregationNZSIOC;
		this.industryCodeNZSIOC = industryCodeNZSIOC;
		this.industryNameNZSIOC = industryNameNZSIOC;
		this.units = units;
		this.variableCode = variableCode;
		this.variableName = variableName;
		this.variableCategory = variableCategory;
		this.value = value;
		this.industryCodeANZSIC06 = industryCodeANZSIC06;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIndustryAggregationNZSIOC() {
		return industryAggregationNZSIOC;
	}

	public void setIndustryAggregationNZSIOC(String industryAggregationNZSIOC) {
		this.industryAggregationNZSIOC = industryAggregationNZSIOC;
	}

	public String getIndustryCodeNZSIOC() {
		return industryCodeNZSIOC;
	}

	public void setIndustryCodeNZSIOC(String industryCodeNZSIOC) {
		this.industryCodeNZSIOC = industryCodeNZSIOC;
	}

	public String getIndustryNameNZSIOC() {
		return industryNameNZSIOC;
	}

	public void setIndustryNameNZSIOC(String industryNameNZSIOC) {
		this.industryNameNZSIOC = industryNameNZSIOC;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getVariableCode() {
		return variableCode;
	}

	public void setVariableCode(String variableCode) {
		this.variableCode = variableCode;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getVariableCategory() {
		return variableCategory;
	}

	public void setVariableCategory(String variableCategory) {
		this.variableCategory = variableCategory;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIndustryCodeANZSIC06() {
		return industryCodeANZSIC06;
	}

	public void setIndustryCodeANZSIC06(String industryCodeANZSIC06) {
		this.industryCodeANZSIC06 = industryCodeANZSIC06;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnnualReport [year=");
		builder.append(year);
		builder.append(", industryAggregationNZSIOC=");
		builder.append(industryAggregationNZSIOC);
		builder.append(", industryCodeNZSIOC=");
		builder.append(industryCodeNZSIOC);
		builder.append(", industryNameNZSIOC=");
		builder.append(industryNameNZSIOC);
		builder.append(", units=");
		builder.append(units);
		builder.append(", variableCode=");
		builder.append(variableCode);
		builder.append(", variableName=");
		builder.append(variableName);
		builder.append(", variableCategory=");
		builder.append(variableCategory);
		builder.append(", value=");
		builder.append(value);
		builder.append(", industryCodeANZSIC06=");
		builder.append(industryCodeANZSIC06);
		builder.append("]");
		return builder.toString();
	}

}
