package com.assg.app;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

	private TextField firstTf;
	private TextField secondTf;
	private Label ansLabel;

	public ActionHandler(TextField firstTf, TextField secondTf, Label ansLabel) {
		this.firstTf = firstTf;
		this.secondTf = secondTf;
		this.ansLabel = ansLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ansLabel.setBounds(542, 514, 250, 30);
		Maths math = new Maths();
		double res = 0.0;
		try {
			double firtIp = takeInput(this.firstTf.getText());
			double secondIp = takeInput(this.secondTf.getText());
			
			if (e.getActionCommand().equalsIgnoreCase("add")) {
				res = math.add(firtIp, secondIp);
				this.ansLabel.setText("Answer is =  " + res);
			} else if (e.getActionCommand().equalsIgnoreCase("subtract")) {
				res = math.sub(firtIp, secondIp);
				this.ansLabel.setText("Answer is =  " + res);
			} else if (e.getActionCommand().equalsIgnoreCase("multiply")) {
				res = math.mul(firtIp, secondIp);
				this.ansLabel.setText("Answer is =  " + res);
			} else {
				if (secondIp == 0) {
					this.ansLabel.setText("Infinite.");
				} else {
					res = math.div(firtIp, secondIp);
					this.ansLabel.setText("Answer is =  " + res);
				}
			}
		} catch (Exception e2) {
			this.ansLabel.setText("!!--Invalid Input--!!" +e2.getMessage());
		}

	}

	private static double takeInput(String ip) {
		return Double.parseDouble(ip);
	}

}
