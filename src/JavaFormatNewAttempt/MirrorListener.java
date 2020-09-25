package JavaFormatNewAttempt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MirrorListener implements ActionListener {

	private JLabel imageMirrorConverted;
	 BufferedImage mirrorImage;

	public MirrorListener(JLabel mirror) { // method which connects this class into the userinterface class twistedMirrorButton button.

		this.imageMirrorConverted = mirror;  // connects the image to this method.

	}

	@Override
	public void actionPerformed(ActionEvent e) { // when twistedMirrorButton button is pressed the code within is activated.
		
		MirrorImage();

	}

	public void MirrorImage() {  // method which changes the image

		try {
			mirrorImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));

		} catch (IOException ex) {
			// handle exception...
		}

		for (int j = 0; j < mirrorImage.getHeight(); j++) {  // shifts half of the images pixels into a mirror of itself, a twisted mirror is created
			for (int i = 0, w = mirrorImage.getWidth() - 1; i < mirrorImage.getWidth(); i++, w--) {
				int p = mirrorImage.getRGB(i, j);
				// set mirror image pixel value - both left and right
				mirrorImage.setRGB(w, j, p);
			}
		}
		imageMirrorConverted.setIcon(new ImageIcon(mirrorImage));   // converts the image into a JLabel ImageIcon.

	}

}
