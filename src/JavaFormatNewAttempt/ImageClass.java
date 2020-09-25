package JavaFormatNewAttempt;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class ImageClass extends JComponent{
	
	private BufferedImage image = null;

 	public ImageClass(BufferedImage lImage) {
		
		this.image = lImage;
	}
	
	public BufferedImage getImage() {
		return image;
			
	}
	
	public void paint(Graphics g) {	 
		  
		   super.paintComponent(g); //clears the background/refreshes.
		   
		   int width = this.getSize().width;
	       int height = this.getSize().height;
		   g.drawImage(image, 0, 0, width, height, null);
	   }
	
	public BufferedImage loadImage() {
		
		try {
			image = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return image;
	}
	
	public BufferedImage smallSizeImage() {
		
		
		 return new BufferedImage(400, 200, image.getType() );
		
	}
	
	

}