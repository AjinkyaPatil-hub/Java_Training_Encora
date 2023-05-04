package com.assg.app;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtImage extends Frame {
	Image img;

	public static void main(String[] args) {
		AwtImage ai = new AwtImage();
	}

	public AwtImage() {
		super("Image Frame");

		MediaTracker mt = new MediaTracker(this);
		img = Toolkit.getDefaultToolkit().getImage("C:/Users/ajinkyap/Downloads/cartoon.gif");
		mt.addImage(img, 0);
		setSize(400, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 1270, 100, this);
		else
			g.clearRect(0, 0, getSize().width, getSize().height);
	}
}
