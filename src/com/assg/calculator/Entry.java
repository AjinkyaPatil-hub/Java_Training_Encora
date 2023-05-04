package com.assg.calculator;

import com.assg.calculator.helper.Menu;

public class Entry {

	public static void main(String[] args) {
		System.out.println("!!--- Welcome to Encora Calculator---!! ");
		try {
		Menu.doOpeation();
		}catch (Exception e) {
			System.err.println("Error occured while performing operation . Please check you input once..");
		}
		System.out.println("!! --Thank You-- !!");
	}
}
