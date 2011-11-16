/**
 * 
 */
package library;

import library.LibraryRepository;

/**
 * @author johnwarde
 * 
 * Manages the Library System, displays menu, handle interaction
 *
 */
public class LibraryManagerConsole {
	/**
	 * 
	 */
	public LibraryManagerConsole() {
		// TODO initialization?
		
		
	}
	
	public void init() {
		// Main loop
		Menu mainMenu = new Menu("Main Menu", 
				new String[] {"Exit", "Library Catalog", "Library Users", "Check-in/Check-out"});
		int choice = -1;
		do {
			System.out.print(mainMenu.getMenuToDisplay());
			choice = mainMenu.getUserSelection();
			switch (choice) {
				case 1:
					showCatalogMenu();
					break;
				case 2:
					showUsersMenu();
					break;
				case 3:
					showCheckMenu();
					break;
				default:
					break;
			}
		} while (choice != 0);
	}

	private void showCatalogMenu() {
		Menu libMenu = new Menu("Library Catalog", new String[] {
				"Return to main menu", 
				"List all items", 
				"List by category", 
				"List available items", 
				"Add new library item"
				});
		int choice = -1;
		do {
			System.out.print(libMenu.getMenuToDisplay());
			choice = libMenu.getUserSelection();
			switch (choice) {
				case 1:
					catalogListAllItems();
					break;
				case 0:
					// Return to main menu
					break;
				default:
					placeHolderHelper(libMenu.getSelectedText(choice));
					break;					
			}
		} while (choice != 0);		
	}
	
	
	private void placeHolderHelper(String optionSelected) {
		System.out.println(
				String.format("\r\n\r\n\t %s has not yet been implemented, returning you to the previous menu", optionSelected));
	}

	private void catalogListAllItems() {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Catalog items = lib.getCatalog();
		System.out.print(String.format("\r\n\r\n" + 
			"Choice Library  On                                        Author/\r\n" + 
			"  No.   Code   Loan Type       Title                      Artist\r\n" + 
			"------ ------- ---- ---------- -------------------------- --------------\r\n"));
		LibraryItem item;
		items.first();
		int count = 1;
		while (items.hasNext()) {
			item = items.getCurrent();
			System.out.println(String.format("%6d %s", count, item.toConsoleLine()));
			items.next();
			count++;
		}
		ListChoice lc = new ListChoice(count - 1);
		System.out.println(lc.getMenuToDisplay());
		int choice = lc.getUserOption();
		if (0 == choice) {
			return;
		}
		// Show the selected item
		LibraryItem selected = items.getIndex(choice - 1);
		System.out.println(selected.toConsoleFull());

		Menu menu = new Menu("Library Item Menu", new String[] {
				"Return to main menu", 
				"Check-out", 
				"Check-in", 
				"Edit item", 
				"Delete item"});
		choice = -1;
		do {
			System.out.print(menu.getMenuToDisplay());
			choice = menu.getUserSelection();
			switch (choice) {
				case 3:
					//EditItem(selected);
					break;
				case 0:
					// Return to previous menu
					break;
				default:
					placeHolderHelper(menu.getSelectedText(choice));
					break;					
			}
		} while (choice != 0);	
		
		
/*		
		ListContextMenu menu = new ListContextMenu(5, new String[] {
				"Return to main menu", 
				"Check-out", 
				"Check-in", 
				"Edit item", 
				"Delete item"});
		int contextChoice = menu.getUserOption();
		int listChoice = menu.getListChoice();
		System.out.print(String.format("Context Choice = %d, listChoice = %d\r\n", contextChoice, listChoice));
*/
	}

	private void showUsersMenu() {
		Menu usersMenu = new Menu("Library Users", 
				new String[] {"Return to main menu", "List users", "Add user"});
		System.out.print(usersMenu.getMenuToDisplay());
		System.out.println(String.format("\r\n\tNot implemented, returning you to Main Menu ..."));
	}

	private void showCheckMenu() {
		Menu checkMenu = new Menu("Check-in / Check-out", 
				new String[] {"Return to main menu", "Check-in item", "Check-out item"});
		System.out.print(checkMenu.getMenuToDisplay());
		System.out.println(String.format("\r\n\tNot implemented, returning you to Main Menu ..."));
	}

}
