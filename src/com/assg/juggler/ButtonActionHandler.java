package com.assg.juggler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionHandler implements ActionListener {

	JugglerBoard jb;
	String b;

	public ButtonActionHandler(JugglerBoard board, String button) {

		this.jb = board;
		this.b = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jb.getErrorLabel().setBounds(665, 274, 250, 30);
		try {
			jb.getErrorLabel().setText("");
			jb.getErrorLabel().setVisible(false);
			String text3 = jb.getTfAtClock3().getText();
			String text6 = jb.getTfAtClock6().getText();
			String text9 = jb.getTfAtClock9().getText();

			if (b.equalsIgnoreCase("cloclWiseButton")) {
				int clcok3 = Integer.parseInt(text3) + 1;
				jb.getTfAtClock6().setText("");
				jb.getTfAtClock6().setText(clcok3 + "");

				int clcok6 = Integer.parseInt(text6) + 1;
				jb.getTfAtClock9().setText("");
				jb.getTfAtClock9().setText(clcok6 + "");

				int clcok9 = Integer.parseInt(text9) + 1;
				jb.getTfAtClock3().setText("");
				jb.getTfAtClock3().setText(clcok9 + "");
			} else {
				int clcok3 = Integer.parseInt(text3) - 1;
				jb.getTfAtClock9().setText("");
				jb.getTfAtClock9().setText(clcok3 + "");

				int clcok6 = Integer.parseInt(text6) - 1;
				jb.getTfAtClock3().setText("");
				jb.getTfAtClock3().setText(clcok6 + "");

				int clcok9 = Integer.parseInt(text9) - 1;
				jb.getTfAtClock6().setText("");
				jb.getTfAtClock6().setText(clcok9 + "");
			}
		} catch (Exception e2) {
			jb.getErrorLabel().setVisible(true);
			jb.getErrorLabel().setText("!!--Please enter all 3 values--!!" + e2.getMessage());
		}

	}

}
