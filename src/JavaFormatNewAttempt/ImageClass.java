package JavaFormatNewAttempt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/*
 * This class gives the startup background image, was supposed to have all the image changing functions
 * but couldn't succeed at this.
 */

public class ImageClass extends JComponent{
	
	private BufferedImage image = null;
	
	/*
	 * constructor for the class.
	 */

 	public ImageClass(BufferedImage lImage) {
		
		this.image = lImage;
	}
	
	/*
	 *  draws the BufferedImage image so height and width of the image is suited for the JFrame at all times.
	 */
 	
	public void paint(Graphics g) {	 
		  
		   super.paintComponent(g); 
		   
		   int width = this.getSize().width;
	       int height = this.getSize().height;
		   g.drawImage(image, 0, 0, width, height, null);
	   }
	
	/*
	 * grabs the image from the directory.
	 */
	
	public BufferedImage loadImage() {
		
		try {
			image = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return image;
	}
	
	/*
	 * failed attempt thus far to get the image changing into this class and calling them into 
	 * their specific ActionListeners. The program doesn't crash with code ' return image; ' and 
	 * comment away the other return line. However, nothing happens at all with this code at the moment.
	 */
	public BufferedImage smallSizeImage() {
		
		return image;
		
	//	 return new BufferedImage(400, 200, image.getType() );
		
	}
	
	

}