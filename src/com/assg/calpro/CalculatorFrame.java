package com.assg.calpro;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorFrame extends Frame {

	private TextField firstTf;

	private TextField secondTf;

	private Label ansLabel;

	public CalculatorFrame() {
		this.setTitle("My Calculator");
		this.setVisible(true);
		this.setBounds(100, 200, 400, 300);

		// default window size when window is opened
		this.setSize(1023, 495);
		this.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("Courier", Font.ITALIC, 20);

		ansLabel = new Label();

		this.add(ansLabel);

		// Main Title
		Label heading = new Label();
		heading.setText("Welcome To Encora Calculator");
		heading.setAlignment(Label.CENTER);
		heading.setBounds(530, 262, 300, 30);
		heading.setFont(font);
		heading.setBackground(Color.orange);
		this.add(heading);
		this.setLayout(null);

		// First label
		Label firstLabel = new Label();
		firstLabel.setText("Enter first number");
		firstLabel.setBounds(450, 335, 100, 20);
		firstLabel.setBackground(Color.LIGHT_GRAY);
		this.add(firstLabel);
		this.setLayout(null);

		// text field to take input
		firstTf = new TextField();
		firstTf.setBounds(571, 330, 80, 30);
		add(firstTf);

		// Second label
		Label secondLabel = new Label();
		secondLabel.setText("Enter second number");
		secondLabel.setBounds(663, 334, 120, 20);
		secondLabel.setBackground(Color.LIGHT_GRAY);
		this.add(secondLabel);
		this.setLayout(null);

		// text field to take input
		secondTf = new TextField();
		secondTf.setBounds(810, 326, 80, 30);
		add(secondTf);

		// add button
		Button addButton = new Button("Add");
		addButton.setBounds(454, 410, 80, 30);
		addButton.setBackground(Color.PINK);
		addButton.addActionListener(new NewActionHandler(this));

		// subtract button
		Button subButton = new Button("Subtract");
		subButton.setBounds(569, 408, 80, 30);
		subButton.setBackground(Color.PINK);
		subButton.addActionListener(new NewActionHandler(this));
		this.setLayout(null);

		// multiply button
		Button mulButton = new Button("Multiply");
		mulButton.setBounds(682, 410, 80, 30);
		mulButton.setBackground(Color.PINK);
		mulButton.addActionListener(new NewActionHandler(this));
		this.setLayout(null);

		// divide button
		Button divButton = new Button("Divide");
		divButton.setBounds(795, 409, 80, 30);
		divButton.setBackground(Color.PINK);
		divButton.addActionListener(new NewActionHandler(this));
		this.setLayout(null);

		this.add(addButton);
		this.add(subButton);
		this.add(mulButton);
		this.add(divButton);

		// To close a window
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				CalculatorFrame cf = (CalculatorFrame) e.getSource();
				cf.dispose();
			}

		});
	}

	public TextField getFirstTf() {
		return firstTf;
	}

	public void setFirstTf(TextField firstTf) {
		this.firstTf = firstTf;
	}

	public TextField getSecondTf() {
		return secondTf;
	}

	public void setSecondTf(TextField secondTf) {
		this.secondTf = secondTf;
	}

	public Label getAnsLabel() {
		return ansLabel;
	}

	public void setAnsLabel(Label ansLabel) {
		this.ansLabel = ansLabel;
	}
}
