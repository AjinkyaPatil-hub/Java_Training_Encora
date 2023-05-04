package com.assg.app;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComponent extends Component {

	BufferedImage img;

	public ImageComponent(String path) {
		try {
			img = ImageIO.read(new File("/Encora.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
