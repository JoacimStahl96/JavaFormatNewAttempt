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
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SmallSizeListener extends JFrame implements ActionListener{
	
 //	private JLabel smallSizeConverted;
	BufferedImage image;
	
	ImageClass images = new ImageClass(image);
	
	public SmallSizeListener(BufferedImage myImage) {
	
	//	Object smallsize = images.smallSizeImage();
	
		
		
	//	images.loadImage();
		images.smallSizeImage();
	}

	@Override
	public void actionPerformed(ActionEvent e) { // when smallSizeButton button is pressed the code within is activated.

	//	images.loadImage();
		images.smallSizeImage();
		
	}

}
