package JavaFormatNewAttempt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 *  this class contains the twisted mirror image and acts as a listener for the twistedMirrorButton.
 */
public class MirrorListener implements ActionListener {

	private JLabel imageMirrorConverted;
	 BufferedImage mirrorImage;
	 
	 /*
	  * method which connects this class into the UserInterface class twistedMirrorButton button.
	  */

	public MirrorListener(JLabel mirror) { 

		this.imageMirrorConverted = mirror;

	}

	/*
	 * when twistedMirrorButton button is pressed the code within is activated.
	 */
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		MirrorImage();

	}
	
	/*
	 * method which changes the image and then converts the image into a JLabel ImageIcon.
	 * the for-loop shifts half of the images pixels into a mirror of the other half, a twisted mirror is created
	 */
	public void MirrorImage() {   

		try {
			mirrorImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));

		} catch (IOException ex) {
			
		}

		for (int j = 0; j < mirrorImage.getHeight(); j++) {   
			for (int i = 0, w = mirrorImage.getWidth() - 1; i < mirrorImage.getWidth(); i++, w--) {
				int p = mirrorImage.getRGB(i, j);
				
				mirrorImage.setRGB(w, j, p);
			}
		}
		imageMirrorConverted.setIcon(new ImageIcon(mirrorImage));   

	}

}
