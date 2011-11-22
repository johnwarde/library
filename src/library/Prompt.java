/**
 * 
 */
package library;

import java.io.Console;

/**
 * @author johnwarde
 *
 */
public class Prompt extends ConsoleComponent {
	String message;
	
	public Prompt(String promptMessage) {
		message = promptMessage;
	}
	
	public String getUserChoice() {
		System.out.println();
        Console console = System.console();
        assert console != null : "You need to run the program from the command line to get user input!!!";
        String input = "";
        while (true) {
        	try {
            	input = console.readLine(message + ": ");
            	return input;
			} catch (Exception e) {
				// Just ask for another input
			}	
        }
	}
	
}
