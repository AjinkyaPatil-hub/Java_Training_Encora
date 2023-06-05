package com.assg.encora.mode;

public class StudentResult {

	private int studentId;

	private String studentName;

	private String university;

	private int total;

	private String resultStatus;

	private int totalMarks;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "StudentResult [studentId=" + studentId + ", studentName=" + studentName + ", university=" + university
				+ ", total=" + total + ", resultStatus=" + resultStatus + ", totalMarks=" + totalMarks + "]";
	}

}
