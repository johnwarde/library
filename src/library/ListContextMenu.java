/**
 * 
 */
package library;

import java.io.Console;

/**
 * @author johnwarde
 *
 */
public class ListContextMenu {
	private int noOfItems;
	private int listChoice = -1;
	private String[] menuOptions;
	
	
	public ListContextMenu(int noOfItems, String[] contextMenuOptions) {
		this.noOfItems = noOfItems;
		this.menuOptions = contextMenuOptions;
	}
	
	public int getUserOption() {
		String prompt = String.format("\r\nPlease enter an entry number from the list above\r\nOR 0 to return to previous menu.\r\n");
		System.out.print(prompt);

        Console console = System.console();
        assert console != null : "You need to run the program from the command line to get user input!!!";
        String input;
        int choice;
        do {
        	try {
            	input = console.readLine();
            	choice = Integer.parseInt(input);				
			} catch (Exception e) {
				choice = -1;
			}
        } while (!this.isValidListChoice(choice));
        if (0 == choice) {
        	return choice;			
		}
        listChoice = choice;
        
		String menuDetail = "";
		int menuOptionCount = 0;
		for (String menuEntry : menuOptions) {
			menuDetail += String.format("\t%2d.  %s\r\n", menuOptionCount, menuEntry);
			menuOptionCount++;
		}	
		System.out.println(menuDetail);
		prompt = String.format("\r\nPlease enter your choice from the menu above : \r\n");
		System.out.print(prompt);

        do {
        	try {
            	input = console.readLine();
            	choice = Integer.parseInt(input);				
			} catch (Exception e) {
				choice = -1;
			}
        } while (!this.isValidChoice(choice));
		return choice;		
	}
	
	public boolean isValidChoice(int choice) {
		if (choice < 0 || choice > (menuOptions.length - 1)) {
			return false;
		}
		return true;
	}
		
	public boolean isValidListChoice(int choice) {
		if (choice < 0 || choice > noOfItems) {
			return false;
		}
		return true;
	}

	/**
	 * @return the listChoice
	 */
	public int getListChoice() {
		return listChoice;
	}	

}
