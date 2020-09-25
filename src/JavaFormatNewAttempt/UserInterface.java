package JavaFormatNewAttempt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private JFrame frame;
   
	

	@Override
	public void run() {
		frame = new JFrame("JavaFormat picture changer"); // title of the JFrame / GUI
		frame.setPreferredSize(new Dimension(800, 600));  // the size of the JFrame

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // shutdowns when the window is closed
		

		createComponents(frame.getContentPane());  //adds all the components which were created in createComponents, menu, buttons, image etc.

		frame.pack();  // sets the size of the JFrame to it's preferred size
		frame.setVisible(true);  // shows the JFrame GUI as long as it's set to ' true '
	}

	private void createComponents(Container container) {  // menus, buttons and the starting background image is forged here for the JFrame

		BorderLayout layout = new BorderLayout(); // the layout is created
		container.setLayout(layout);  // adds the borderlayout to the container which is called into the JFrame later on.

		BufferedImage backgroundImage = null;
	/*	try {
			backgroundImage = ImageIO.read(new File("blueberry.jpg"));   // grabs the image
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
		
		
		ImageClass images = new ImageClass(backgroundImage);
		images.loadImage();
		BufferedImage myImage = images.loadImage();
		
	//	images.smallSizeImage();
	//	Object smallsize = images.smallSizeImage();
		
		
		JLabel convertedBackgroundImage = new JLabel(new ImageIcon(myImage)); // converts the image into a JLabel ImageIcon.

		JToolBar toolBar = new JToolBar();   // toolbar menu is created
		toolBar.addSeparator(new Dimension(50, 0)); // spacing between the border and the first button
		toolBar.setBackground(Color.DARK_GRAY);  // colors the toolbar menu background.

		JButton twistedMirrorButton = new JButton("Twisted Mirror"); // Button for Twisted Mirror function is created
		MirrorListener mirror = new MirrorListener(convertedBackgroundImage); 
		twistedMirrorButton.addActionListener(mirror);  // links the button to ActionListener which has the function we want to use.
		twistedMirrorButton.setBackground(Color.LIGHT_GRAY); // colors the button
		twistedMirrorButton.setForeground(Color.WHITE); // text color for the button
		toolBar.add(twistedMirrorButton);  // adds the button to the menu
		toolBar.addSeparator(new Dimension(50, 0));  // spacing between the buttons

		JButton negativeButton = new JButton("Negative colors"); // button is created
		ButtonListenerNegative negative = new ButtonListenerNegative(convertedBackgroundImage); // object created to link to the ActionListener in ButtonListenerNegative class
		negativeButton.addActionListener(negative);  // links the button to ActionListener which has the function we want to use.
		negativeButton.setBackground(Color.LIGHT_GRAY);  // colors the button
		negativeButton.setForeground(Color.WHITE);  // text color for the button
		toolBar.add(negativeButton);  // adds the button to the menu
		toolBar.addSeparator(new Dimension(50, 0));   // spacing between the buttons

		JButton smallSizeButton = new JButton("Smaller image "); // button is created
	//	SmallSizeListener smallSize = new SmallSizeListener(myImage);
	//	smallSizeButton.addActionListener(smallSize);   // links the button to ActionListener which has the function we want to use.
		smallSizeButton.setBackground(Color.LIGHT_GRAY);   // colors the button 
		smallSizeButton.setForeground(Color.WHITE);    // text color for the button
		toolBar.add(smallSizeButton);     // adds the button to the menu
		toolBar.addSeparator(new Dimension(50, 0));     // spacing between the buttons

		JButton originalImageButton = new JButton("Original Image");  // button is created
		OriginalListenerImage original = new OriginalListenerImage(convertedBackgroundImage);
		originalImageButton.addActionListener(original);  // links the button to ActionListener which has the function we want to use.
		originalImageButton.setBackground(Color.LIGHT_GRAY);  // colors the button
		originalImageButton.setForeground(Color.WHITE);  // text color for the button
		toolBar.add(originalImageButton);  // adds the button to the menu

		
	
		container.add(convertedBackgroundImage);
	//	container.add(convertedBackgroundImage); // adds the first image to the JFrame as a background and makes the buttons different pictures appear as well.
		container.add(toolBar, BorderLayout.NORTH); // adds the toolBar and buttons to the JFrame.
		
		

	}

	public JFrame getFrame() {
		return frame;
	}

}
