package JavaFormatNewAttempt;

import javax.swing.SwingUtilities;

/*
 * Main class simply activates the UserInterface class.
 */
public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);

	}

}
