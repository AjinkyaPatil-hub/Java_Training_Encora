package com.assg.app;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class MyFrame extends Frame {

	
	public MyFrame() {

	}

	public MyFrame(String title, boolean visible, int x, int y, int widht, int height) {
		this.setTitle(title);
		this.setVisible(visible);
		this.setBounds(x, y, widht, height);

		Panel controlPanel = new Panel(); 
		
		controlPanel.add(new ImageComponent("resources/Encora.jpg"));
		controlPanel.setLayout(new FlowLayout());
		add(controlPanel);
		
		Font font = new Font("Courier", Font.PLAIN, 20);

		Label ansLabel = new Label();
		
		this.add(ansLabel);
		
		// Main Title
		Label heading = new Label();
		heading.setText("Welcome To Encora Calculator");
		heading.setBounds(530, 262, 300, 30);
		heading.setFont(font);
		this.add(heading);
		this.setLayout(null);

		// First label
		Label firstLabel = new Label();
		firstLabel.setText("Enter first number");
		firstLabel.setBounds(450, 335, 100, 20);
		this.add(firstLabel);
		this.setLayout(null);

		// text field to take input
		TextField firstTf = new TextField();
		firstTf.setBounds(571, 330, 80, 30);
		add(firstTf);

		// Second label
		Label secondLabel = new Label();
		secondLabel.setText("Enter second number");
		secondLabel.setBounds(663, 334, 120, 20);
		this.add(secondLabel);
		this.setLayout(null);

		// text field to take input
		TextField secondTf = new TextField();
		secondTf.setBounds(810, 326, 80, 30);
		add(secondTf);

		// add button
		Button addButton = new Button("Add");
		addButton.setBounds(454, 410, 80, 30);
		addButton.addActionListener(new ActionHandler(firstTf, secondTf,ansLabel));

		// subtract button
		Button subButton = new Button("Subtract");
		subButton.setBounds(569, 408, 80, 30);
		subButton.addActionListener(new ActionHandler(firstTf, secondTf,ansLabel));
		this.setLayout(null);
		
		
		// multiply button
		Button mulButton = new Button("Multiply");
		mulButton.setBounds(682, 410, 80, 30);
		mulButton.addActionListener(new ActionHandler(firstTf, secondTf,ansLabel));
		this.setLayout(null);

		// divide button
		Button divButton = new Button("Divide");
		divButton.setBounds(795, 409, 80, 30);
		divButton.addActionListener(new ActionHandler(firstTf, secondTf,ansLabel));
		this.setLayout(null);

		this.add(addButton);
		this.add(subButton);
		this.add(mulButton);
		this.add(divButton);

		this.setBackground(Color.LIGHT_GRAY);
		// To close a window
		this.addWindowListener(new MainWindowHandler());
		this.addMouseListener(new MainWindowHandler());

	}

	public MyFrame(double res) {	
		Label ansLabel = new Label();
		ansLabel.setText("Answer is=  "+res);
		ansLabel.setBounds(542, 514, 100, 30);
		this.add(ansLabel);
		//this.setLayout(null);
	}
	
	public void displayRes(double res) {
		Label ansLabel = new Label();
		ansLabel.setText("Answer is=  "+res);
		ansLabel.setBounds(542, 514, 100, 30);
		this.add(ansLabel);
		//this.setLayout(null);
	}

}
