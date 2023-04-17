package com.assg.entry;

import java.util.Scanner;

import com.assg.service.Maths;

public class Entry {

	public static void main(String[] args) {

		System.out.println("Welcome to Encora - Calculator.. ");

		Maths maths = new Maths();

		while (true) {
			System.out.println("Please enter choice");
			System.out.println(
					"\n 1: Addition \n 2: Multipication \n 3: Substraction \n 4: Square \n 5: Cube \n 6: Divison");
			Scanner scan = new Scanner(System.in);
			int ip = scan.nextInt();
			switch (ip) {
			case 1:
				System.out.println("Please Enter 2 numbers for addition");
				maths.add(scan.nextInt(), scan.nextInt());
				break;
			case 2:
				System.out.println("Please Enter 2 numbers for multiplication");
				maths.mul(scan.nextInt(), scan.nextInt());
				break;
			case 3:
				System.out.println("Please Enter 2 numbers for substraction");
				maths.sub(scan.nextInt(), scan.nextInt());
				break;
			case 4:
				System.out.println("Please Enter  number for Square root");
				maths.square(scan.nextInt());
				break;
			case 5:
				System.out.println("Please Enter  number for Cube");
				maths.cube(scan.nextInt());
				break;
			case 6:
				System.out.println("Please Enter two numbers for division");
				int no = scan.nextInt();
				int div = scan.nextInt();
				if (div != 0) {
					maths.div(no, div);
				} else {
					System.out.println("Cannot divide by zero number");
				}
				break;
			default:
				System.out.println("You have entered wrong choice please enter right choice..");
				break;
			}
			System.out.println("Do you exit press 'E' button or press any key to continue");
			String input = scan.next();
			if (input.equalsIgnoreCase("E")) {
				break;
			}
		}
		System.out.println("--Thank You--");
	}
}
