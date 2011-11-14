/**
 * 
 */
package library;

import java.io.Console;



/**
 * @author johnwarde
 *
 */
public class Menu {
	private String menuTitle = "";
	private String[] menuOptions;

	/**
	 * 
	 */
	public Menu(String aMenuTitle, String[] listOfMenuOptions) {
		menuTitle = aMenuTitle;
		menuOptions = listOfMenuOptions;
	}

	private String getUnderline(int times, String aFormat) {
	   StringBuilder underline = new StringBuilder();
	   for(int i = 0;i < times;i++) {
		   underline.append("=");		
	   }
	   return underline.toString();
	}
	
	public String getMenuToDisplay() {
		// TODO: clear screen - not working
		try {
			Runtime rt = Runtime.getRuntime();
	        rt.exec("cls");			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String header = String.format("\r\n\r\n\t%s\r\n\t%s\r\n\r\n", menuTitle, this.getUnderline(menuTitle.length(), "="));
		String menuDetail = "";
		int menuOptionCount = 1;
		for (String menuEntry : menuOptions) {
			menuDetail += String.format("\t%2d.  %s\r\n", menuOptionCount, menuEntry);
			menuOptionCount++;
		}
		return header + menuDetail + String.format("\r\n\tPlease choose an option: ");
	}
	
	public boolean isValidChoice(int choice) {
		if (choice < 1 || choice > menuOptions.length) {
			return false;
		}
		return true;
	}
	
	public int getUserSelection() {
        Console console = System.console();
        assert console != null : "You need to run the program from the command line to get user input!!!";
        String input;
        int choice;
        do {
        	try {
            	input = console.readLine();
            	//System.out.println(String.format("input = [%s]", input));
            	choice = Integer.parseInt(input);				
			} catch (Exception e) {
				// TODO: print error message?
				choice = 0;
			}
        } while (!this.isValidChoice(choice));
		return choice;
	}
	
	public String getSelectedText(int choice) {
		return menuOptions[choice - 1];
	}
}
