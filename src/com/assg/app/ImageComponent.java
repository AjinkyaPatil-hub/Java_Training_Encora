package com.assg.app;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComponent extends Component {

	BufferedImage img;

	public ImageComponent(String path) {
		try {
			img = ImageIO.read(getClass().getResource("Encora.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, 1201, 200, null);
	}
	
	 public Dimension getPreferredSize()  
     {  
        if (img == null)   
        {  
           return new Dimension(1200,200);  
        }   
        else   
        {  
           return new Dimension(img.getWidth(), img.getHeight());  
        }  
     }  
}
