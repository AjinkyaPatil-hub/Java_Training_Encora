package com.assg.juggler;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JugglerBoard extends Frame {

	private TextField tfAtClock3;

	private TextField tfAtClock6;

	private TextField tfAtClock9;

	private Label errorLabel;

	public JugglerBoard() {

		this.setTitle("My Board");
		this.setVisible(true);
		this.setBounds(100, 200, 200, 200);

		errorLabel = new Label();

		this.add(errorLabel);

		// default window size when window is opened
		this.setSize(1023, 495);
		this.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("Courier", Font.ITALIC, 20);

		// Main Title
		Label heading = new Label();
		heading.setText("Welcome To Encora Juggler Board");
		heading.setAlignment(Label.CENTER);
		heading.setBounds(530, 162, 400, 30);
		heading.setFont(font);
		heading.setBackground(Color.orange);
		this.add(heading);
		this.setLayout(null);

		tfAtClock3 = new TextField();
		tfAtClock3.setBounds(907, 383, 80, 30);
		add(tfAtClock3);

		tfAtClock9 = new TextField();
		tfAtClock9.setBounds(521, 390, 80, 30);
		add(tfAtClock9);

		tfAtClock6 = new TextField();
		tfAtClock6.setBounds(710, 509, 80, 30);
		add(tfAtClock6);

		// buttons
		Button clockWiseButton = new Button("Clock Wise");
		clockWiseButton.setBounds(607, 642, 100, 50);
		clockWiseButton.setBackground(Color.ORANGE);
		clockWiseButton.addActionListener(new ButtonActionHandler(this, "cloclWiseButton"));
		add(clockWiseButton);

		Button antiClockWiseButton = new Button("Anti-Clock Wise");
		antiClockWiseButton.setBounds(838, 642, 100, 50);
		antiClockWiseButton.setBackground(Color.ORANGE);
		antiClockWiseButton.addActionListener(new ButtonActionHandler(this, "antiClockWiseButton"));
		add(antiClockWiseButton);

		// to close window
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				JugglerBoard b = (JugglerBoard) e.getSource();
				b.dispose();
			}
		});

		// to print x and y axis
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("X " + e.getX());
				System.out.println("Y " + e.getY());
			}
		});
	}

	public TextField getTfAtClock3() {
		return tfAtClock3;
	}

	public void setTfAtClock3(TextField tfAtClock3) {
		this.tfAtClock3 = tfAtClock3;
	}

	public TextField getTfAtClock6() {
		return tfAtClock6;
	}

	public void setTfAtClock6(TextField tfAtClock6) {
		this.tfAtClock6 = tfAtClock6;
	}

	public TextField getTfAtClock9() {
		return tfAtClock9;
	}

	public void setTfAtClock9(TextField tfAtClock9) {
		this.tfAtClock9 = tfAtClock9;
	}

	public Label getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(Label errorLabel) {
		this.errorLabel = errorLabel;
	}

}
