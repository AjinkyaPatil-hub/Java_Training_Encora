package com.assg.calculator.service;

public class Maths {

	double res = 0;

	public void add(double a, double b) {

		double res = a + b;
		System.out.println("Addition result: " + res);
	}

	public void mul(double a, double b) {

		res = a * b;
		System.out.println("Multiplication result: " + res);
	}

	public void sub(double a, double b) {

		res = a - b;
		System.out.println("Substraction result: " + res);
	}

	public void square(double a) {

		 res = a * a;
		System.out.println("Square result for number: "+Math.abs(a) +" is: " + res);
	}

	public void cube(double a) {
		 res = a * a * a;
		System.out.println("Cube result: for number "+Math.abs(a) +" is: "+ + res);
	}
	
	public void div(double a, double b) {

		double res = a / b;
		System.out.println("Division result: " + res);
	}
	
	

}
