package JavaFormatNewAttempt;

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
 *  this class contains the original image and acts as a listener for the originalImageButton.
 */
public class OriginalListenerImage implements ActionListener {

	private JLabel originalImageConverted;
	BufferedImage originalImage;

	/*
	 * listener connected to the originalImageButton
	 */
	public OriginalListenerImage(JLabel original) {

		this.originalImageConverted = original;

	}

	/*
	 * when originalImageButton button is pressed the code within is activated.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		originalImage();

	}

	/*
	 * this method doesn't change the image, only shows the original.
	 */

	public void originalImage() { //

		try {
			originalImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		Image nImg = originalImage.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH); // sets the size of the image and
																						// scales it smoothly

		originalImageConverted.setIcon(new ImageIcon(nImg)); // converts the image into a JLabel ImageIcon.

	}

}
