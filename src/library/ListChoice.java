package library;

import java.io.Console;

public class ListChoice {
//	private String[] menuOptions;
	private int noOfItems;
	
	public ListChoice(int noOfItems) {
		//ListChoice(noOfChoices, new String[] {"Return to previous menu", "test"});
		this.noOfItems = noOfItems;
		
	}
	/*
	public ListChoice(int noOfChoices, String[] menuOptions) {
		this.noOfChoices = noOfChoices;
	}
	*/
	
	public String getMenuToDisplay() {
		return String.format("\r\nPlease enter an entry number (1-%d) from the list above\r\nOR 0 to return to previous menu.\r\n", noOfItems);
	}
	
	public int getUserOption() {
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
        } while (!this.isValidChoice(choice));
        return choice;
	}
	
	public boolean isValidChoice(int choice) {
		if (choice < 0 || choice > noOfItems) {
			return false;
		}
		return true;
	}	
	
}
