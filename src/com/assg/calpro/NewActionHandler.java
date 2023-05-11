package com.assg.calpro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.assg.app.Maths;

public class NewActionHandler implements ActionListener {

	CalculatorFrame cf;

	public NewActionHandler(CalculatorFrame calculatorFrame) {
		this.cf = calculatorFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		cf.getAnsLabel().setBounds(542, 514, 250, 30);
		Maths math = new Maths();
		double res = 0.0;
		try {
			double firtIp = takeInput(cf.getFirstTf().getText());
			double secondIp = takeInput(cf.getSecondTf().getText());

			if (e.getActionCommand().equalsIgnoreCase("add")) {
				res = math.add(firtIp, secondIp);
				cf.getAnsLabel().setText("Answer is =  " + res);
			} else if (e.getActionCommand().equalsIgnoreCase("subtract")) {
				res = math.sub(firtIp, secondIp);
				cf.getAnsLabel().setText("Answer is =  " + res);
			} else if (e.getActionCommand().equalsIgnoreCase("multiply")) {
				res = math.mul(firtIp, secondIp);
				cf.getAnsLabel().setText("Answer is =  " + res);
			} else {
				if (secondIp == 0) {
					cf.getAnsLabel().setText("Infinite.");
				} else {
					res = math.div(firtIp, secondIp);
					cf.getAnsLabel().setText("Answer is =  " + res);
				}
			}
		} catch (NumberFormatException nfe) {
			cf.getAnsLabel().setText("!!--Please enter value OR Please check your entered value--!!" + nfe.getMessage());
		}catch (Exception e2) {
			cf.getAnsLabel().setText("!!--Invalid Input--!!" + e2.getMessage());
		}
	}

	private static double takeInput(String ip) {
		return Double.parseDouble(ip);
	}

}
