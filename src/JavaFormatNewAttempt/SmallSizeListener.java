package JavaFormatNewAttempt;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 *  this class changes the size of the image and acts as a listener for the smallSizeButton.
 */

public class SmallSizeListener extends JFrame implements ActionListener{
	
 	private JLabel smallSizeConverted;
	BufferedImage smallSizeImage;
	
	ImageClass images = new ImageClass(smallSizeImage);
	
	/*
	 *  listener connected to the smallSizeButton
	 */
	public SmallSizeListener(JLabel smallImage) {
	
		this.smallSizeConverted = smallImage;
	}
	
	/*
	 * when smallSizeButton is pressed this method is activated
	 */
	@Override
	public void actionPerformed(ActionEvent e) { 

		smallSizeImage();
		
	}
	/*
	 *  method which changes the image size and then converts the image into a JLabel ImageIcon.
	 */
	public void smallSizeImage() {
		
		try {
			smallSizeImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Image image = smallSizeImage.getScaledInstance(400, 200,Image.SCALE_SMOOTH);
	
		 
		 smallSizeConverted.setIcon(new ImageIcon(image));
	}

}
