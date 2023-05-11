package com.assg.juggler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionHandler implements ActionListener {

	JugglerBoard jb;

	public ButtonActionHandler(JugglerBoard board) {

		this.jb = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jb.getErrorLabel().setBounds(665, 274, 450, 30);
		try {
			jb.getErrorLabel().setText("");
			jb.getErrorLabel().setVisible(false);
			int text3 = Integer.parseInt(jb.getTfAtClock3().getText());
			int text6 = Integer.parseInt(jb.getTfAtClock6().getText());
			int text9 = Integer.parseInt(jb.getTfAtClock9().getText());

			if (e.getActionCommand().equalsIgnoreCase("Clock Wise")) {
				System.out.println("Clock-wise clocked");
				jb.getTfAtClock6().setText("" + (text3 + 1));

				jb.getTfAtClock9().setText("" + (text6 + 1));

				jb.getTfAtClock3().setText("" + (text9 + 1));
			} else {
				System.out.println("Anti-Clock-wise clocked");
				jb.getTfAtClock9().setText("" + (text3 - 1));

				jb.getTfAtClock3().setText("" + (text6 - 1));

				jb.getTfAtClock6().setText("" + (text9 - 1));
			}
		}catch (NumberFormatException nfe) {
			jb.getErrorLabel().setVisible(true);
			jb.getErrorLabel().setText("!!--Please enter number OR Please enter numberic value--!!" + nfe.getMessage());
		} 
		catch (Exception e2) {
			jb.getErrorLabel().setVisible(true);
			jb.getErrorLabel().setText("!!--Please enter all 3 values--!!" + e2.getMessage());
		}

	}

}
