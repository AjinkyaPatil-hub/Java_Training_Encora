package com.assg.encapsulation;

import com.assg.encapsulation.utlity.DateUtility;

public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
		if (day < 1) {
			this.day = 1;
		} else if (day < 28) {
			this.day = day;
		} else {
			// get the year
			int inputYear = getYear();
			// check if that year is leap year
			boolean leap = DateUtility.isLeapYear(inputYear);
			int inputMonth = getMonth();
			// calculate the last day of that month
			int lastDateOfMonth = DateUtility.lastDateOfMonth(inputMonth, leap);
			if (day < lastDateOfMonth) {
				this.day = day;
			} else {
				this.day = lastDateOfMonth;
			}
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
		if (month > 12) {
			this.month = 12;
		} else if (month < 1) {
			this.month = 1;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
		if (year < 2023) {
			this.year = 2023;
		} else if (year > 2030) {
			this.year = 2030;
		}
	}

	@Override
	public String toString() {
		return day + "-" + month + "-" + year;
	}
}
