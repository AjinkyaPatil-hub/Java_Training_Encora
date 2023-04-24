package com.assg.encapsulation;

/*
 *  case1 :For Year: If year is less than 2023 then it consider as 2023 , and if year is more than 2030 then it should consider as 2030
 *  case 2:For Month: If month is less than 1 then it should consider as 1 , and if month is more than 12 then it should consider as 12 
 *  case 3:For Day: 
 *  			If entered day is less than 1 then it should consider as 1
 *  			else if more then it should calculate appropriate date considering the leap year logic and consider the max day of that month 
 */

public class Entry {

	public static void main(String[] args) {
		// DD-MM-YYY

		Date date = new Date(30, 88, 2028);
		System.out.println(date);
		System.out.println("..Thank You Dipesh Sir..");
	}
}
