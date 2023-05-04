package com.assg.app;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.TextField;
import java.awt.Toolkit;

public class MyFrame extends Frame {

	Image img;

	public MyFrame() {

	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 330, 178, this);
		else
			g.clearRect(0, 0, getSize().width, getSize().height);
	}

	public MyFrame(String title, boolean visible, int x, int y, int widht, int height) {
		this.setTitle(title);
		this.setVisible(visible);
		this.setBounds(x, y, widht, height);

		// default window size when window is opened
		this.setSize(1023, 495);

		// to set image
		MediaTracker mt = new MediaTracker(this);
		img = Toolkit.getDefaultToolkit().getImage("C:/Users/ajinkyap/Downloads/Encora.jpg");
		mt.addImage(img, 0);

		Font font = new Font("Courier", Font.ITALIC, 20);

		Label ansLabel = new Label();

		this.add(ansLabel);

		// Main Title
		Label heading = new Label();
		heading.setText("Welcome To Encora Calculator");
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
		TextField firstTf = new TextField();
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
		TextField secondTf = new TextField();
		secondTf.setBounds(810, 326, 80, 30);
		add(secondTf);

		// add button
		Button addButton = new Button("Add");
		addButton.setBounds(454, 410, 80, 30);
		addButton.setBackground(Color.PINK);
		addButton.addActionListener(new ActionHandler(firstTf, secondTf, ansLabel));

		// subtract button
		Button subButton = new Button("Subtract");
		subButton.setBounds(569, 408, 80, 30);
		subButton.setBackground(Color.PINK);
		subButton.addActionListener(new ActionHandler(firstTf, secondTf, ansLabel));
		this.setLayout(null);

		// multiply button
		Button mulButton = new Button("Multiply");
		mulButton.setBounds(682, 410, 80, 30);
		mulButton.setBackground(Color.PINK);
		mulButton.addActionListener(new ActionHandler(firstTf, secondTf, ansLabel));
		this.setLayout(null);

		// divide button
		Button divButton = new Button("Divide");
		divButton.setBounds(795, 409, 80, 30);
		divButton.setBackground(Color.PINK);
		divButton.addActionListener(new ActionHandler(firstTf, secondTf, ansLabel));
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
}
