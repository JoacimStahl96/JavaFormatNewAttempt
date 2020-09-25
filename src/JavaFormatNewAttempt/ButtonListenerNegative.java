package JavaFormatNewAttempt;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 *  this class contains the negative image and acts as a listener for the negativeButton.
 */
public class ButtonListenerNegative implements ActionListener{

	private JLabel imageNegativeConverted;
	 BufferedImage negativeImage;
	 
	 /*
	  * method which connects this class into the UserInterface class negativeButton button.
	  */
	public ButtonListenerNegative(JLabel negative) {  
		
		this.imageNegativeConverted = negative;  

	}
	
	/*
	 * when negativeButton button is pressed the code within is activated.
	 */
	@Override
	public void actionPerformed(ActionEvent e) { // 

		negativeImage();  
	}
	
	/*
	 *  method which changes the images colors pixels to it's negative colors value
	 *  converts the image into an ImageIcon and sets the size of it.
	 */

	public void negativeImage() {  
		
		try {
			negativeImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		for (int x = 0; x < negativeImage.getWidth(); x++) {  // 
			for (int y = 0; y < negativeImage.getHeight(); y++) {
				int rgba = negativeImage.getRGB(x, y);
				Color col = new Color(rgba, true);
				col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
				negativeImage.setRGB(x, y, col.getRGB());
			}
		}
		Image nImg = negativeImage.getScaledInstance(1920, 1080,Image.SCALE_SMOOTH); 
		
		imageNegativeConverted.setIcon(new ImageIcon(nImg)); 

	}
	

}
