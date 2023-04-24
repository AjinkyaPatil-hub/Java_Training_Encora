package com.assg.encapsulation.utlity;

public class DateUtility {

	public static boolean isLeapYear(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
			return true;
		else
			return false;

	}

	public static int lastDateOfMonth(int month, boolean leap) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 2) {
			if (leap)
				return 29;
			else
				return 28;
		} else {
			return 30;
		}
	}
}
