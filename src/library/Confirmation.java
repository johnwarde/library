/**
 * 
 */
package library;

import java.io.Console;

/**
 * @author johnwarde
 *
 */
public class Confirmation {
	String askMessage;
	
	public Confirmation(String confirmMessage) {
		askMessage = confirmMessage;
	}
	
	public boolean getUserChoice() {
		System.out.println();
        Console console = System.console();
        assert console != null : "You need to run the program from the command line to get user input!!!";
        String input = "";
        while (true) {
        	try {
            	input = console.readLine(askMessage + ' ');
            	if (input.matches("[yY](es)*")) {
            		return true;
            	}
            	if (input.matches("[nN]o*")) {
            		return false;
            	}            	
			} catch (Exception e) {
				// Just ask for another input
			}	
        }
	}
	
}
