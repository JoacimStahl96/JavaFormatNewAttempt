package JavaFormatNewAttempt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

/*
 * This class contains both the JFrame interface but also the toolBar menu and it's buttons
 */
public class UserInterface implements Runnable {

	private JFrame frame;
   
	/*
	 * the graphical interface is created as a JFrame. title, size
	 */
	@Override
	public void run() {
		frame = new JFrame("JavaFormat picture changer"); // title of the JFrame / GUI
		frame.setPreferredSize(new Dimension(800, 600));  // the size of the JFrame

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		

		createComponents(frame.getContentPane());  //adds all the components which were created in createComponents, menu, buttons, image etc.

		frame.pack();  // sets the size of the JFrame to it's preferred size
		frame.setVisible(true);  // shows the JFrame GUI as long as it's set to ' true '
	}

	/* 
	 * menus, buttons, and BorderLayout  is forged here for the JFrame, the buttons ActionListeners are also connected here
	 * the image is also called from ImageClass.
	 */
	private void createComponents(Container container) {  

		BorderLayout layout = new BorderLayout(); 
		container.setLayout(layout);  // add the layout to the frame.

		BufferedImage backgroundImage = null;		
		
		ImageClass images = new ImageClass(backgroundImage);
		images.loadImage();
		backgroundImage = images.loadImage();
		
		
		JLabel convertedBackgroundImage = new JLabel(new ImageIcon(backgroundImage)); // converts the image into a JLabel ImageIcon.
		/*
		 * ToolBar menu is created, colored and spacing from the border to the first layout is added.
		 */

		JToolBar toolBar = new JToolBar();   
		toolBar.addSeparator(new Dimension(50, 0)); 
		toolBar.setBackground(Color.DARK_GRAY);  
		/*
		 *  Adding the buttons, coloring them, add spaces and the ActionListeners are connected to the buttons.
		 */

		JButton twistedMirrorButton = new JButton("Twisted Mirror"); // Button for Twisted Mirror function is created
		MirrorListener mirror = new MirrorListener(convertedBackgroundImage); 
		twistedMirrorButton.addActionListener(mirror);  // links the button to ActionListener which has the function we want to use.
		twistedMirrorButton.setBackground(Color.LIGHT_GRAY); // colors the button
		twistedMirrorButton.setForeground(Color.WHITE); // text color for the button
		toolBar.add(twistedMirrorButton);  // adds the button to the toolBar menu
		toolBar.addSeparator(new Dimension(50, 0));  // spacing between the buttons
		/*
		 *   the rest of the buttons will not be commented since it's the same except for different names of variables and listeners.
		 */

		JButton negativeButton = new JButton("Negative colors"); 
		ButtonListenerNegative negative = new ButtonListenerNegative(convertedBackgroundImage);
		negativeButton.addActionListener(negative);  
		negativeButton.setBackground(Color.LIGHT_GRAY);  
		negativeButton.setForeground(Color.WHITE);  
		toolBar.add(negativeButton); 
		toolBar.addSeparator(new Dimension(50, 0));   

		JButton smallSizeButton = new JButton("Smaller image "); 
		SmallSizeListener smallSize = new SmallSizeListener(convertedBackgroundImage);
		smallSizeButton.addActionListener(smallSize);   
		smallSizeButton.setBackground(Color.LIGHT_GRAY);   
		smallSizeButton.setForeground(Color.WHITE);    
		toolBar.add(smallSizeButton);     
		toolBar.addSeparator(new Dimension(50, 0));     

		JButton originalImageButton = new JButton("Original Image");  
		OriginalListenerImage original = new OriginalListenerImage(convertedBackgroundImage);
		originalImageButton.addActionListener(original);  
		originalImageButton.setBackground(Color.LIGHT_GRAY);  
		originalImageButton.setForeground(Color.WHITE);  
		toolBar.add(originalImageButton); 

		container.add(convertedBackgroundImage); // adds the image to the frame and makes the buttons different pictures appear as well.
		container.add(toolBar, BorderLayout.NORTH); // adds the toolBar and buttons to the frame.
		
		

	}

	public JFrame getFrame() {
		return frame;
	}

}
