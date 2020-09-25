package JavaFormatNewAttempt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonListenerNegative implements ActionListener{

	private JLabel imageNegativeConverted;
	 BufferedImage negativeImage;

	public ButtonListenerNegative(JLabel negative) { // method which connects this class into the userinterface class negativeButton button.
		
		this.imageNegativeConverted = negative;  // connects the image to this method.

	}

	@Override
	public void actionPerformed(ActionEvent e) { // when negativeButton button is pressed the code within is activated.

		negativeImage();  // grabs the method which changes the picture
	}

	public void negativeImage() {  // method which changes the image
		
		try {
			negativeImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		for (int x = 0; x < negativeImage.getWidth(); x++) {  // changes the images colors pixel wise to it's negative colors
			for (int y = 0; y < negativeImage.getHeight(); y++) {
				int rgba = negativeImage.getRGB(x, y);
				Color col = new Color(rgba, true);
				col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
				negativeImage.setRGB(x, y, col.getRGB());
			}
		}
		Image nImg = negativeImage.getScaledInstance(1920, 1080,Image.SCALE_SMOOTH); // attempt to re-size the image
		
		imageNegativeConverted.setIcon(new ImageIcon(nImg)); // converts the image into a JLabel ImageIcon.

	}
	

}
