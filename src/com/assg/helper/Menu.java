package com.assg.helper;

import java.util.Scanner;

import com.assg.service.Maths;

public class Menu {

	public static int show() {
		System.out.print("Please enter choice number to perform operation");
		System.out
				.println("\n 1: Addition \n 2: Multipication \n 3: Substraction \n 4: Square \n 5: Cube \n 6: Divison");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public static void doOpeation() {
		Scanner scan = new Scanner(System.in);

		Maths maths = new Maths();

		while (true) {
			System.out.println("Please Enter 2 numbers");
			double input1 = takeInput(scan.next());
			double input2 = takeInput(scan.next());
			int ip = show();
			switch (ip) {
			case 1:
				maths.add(input1, input2);
				break;
			case 2:
				maths.mul(input1, input2);
				break;
			case 3:
				maths.sub(input1, input2);
				break;
			case 4:
				maths.square(input1);
				maths.square(input2);
				break;
			case 5:
				maths.cube(input1);
				maths.cube(input2);
				break;
			case 6:
				double no = input1;
				double div = input2;
				if (div != 0) {
					maths.div(no, div);
				} else {
					System.out.println("Cannot divide by zero number");
				}
				break;
			default:
				System.out.println("You have entered wrong operation choice, Please enter right choice..");
				break;
			}
			System.out.println("Do you exit press 'E' button or press any key to continue");
			String input = scan.next();
			if (input.equalsIgnoreCase("E")) {
				break;
			}
		}
	}

	private static double takeInput(String ip) {
		return Double.parseDouble(ip);
	}
}
