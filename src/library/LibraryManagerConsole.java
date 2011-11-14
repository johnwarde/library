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
				new String[] {"Library Catalog", "Library Users", "Check-in/Check-out", "Exit"});
		int choice = 0;
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
		} while (choice != 4);
	}

	private void showCatalogMenu() {
		Menu libMenu = new Menu("Library Catalog", 
				new String[] {"List all items", "List by category", "List available items", "Add new library item"});
		int choice = 0;
		do {
			System.out.print(libMenu.getMenuToDisplay());
			choice = libMenu.getUserSelection();
			switch (choice) {
				case 1:
					listAllItems();
					break;
				case 2:
					placeHolderHelper(libMenu.getSelectedText(choice));
					break;
				case 3:
					placeHolderHelper(libMenu.getSelectedText(choice));
					break;
				default:
					break;
			}
		} while (choice != 4);		
	}
	
	
	private void placeHolderHelper(String optionSelected) {
		System.out.println(
				String.format("%s has not yet been implemented, returning you to the previous menu", optionSelected));
	}

	private void listAllItems() {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Catalog items = lib.getCatalog();
		LibraryItem item;
		items.first();
		while (items.hasNext()) {
			item = items.getCurrent();
			System.out.println(item.toString());
			items.next();
		}
	}

	private void showUsersMenu() {
		Menu usersMenu = new Menu("Library Users", 
				new String[] {"List users", "Add user"});
		System.out.print(usersMenu.getMenuToDisplay());
		System.out.println("Not implemented, returning you to Main Menu ...");
		
	}

	private void showCheckMenu() {
		Menu checkMenu = new Menu("Check-in / Check-out", 
				new String[] {"Check-in item", "Check-out item"});
		System.out.print(checkMenu.getMenuToDisplay());
		System.out.println("Not implemented, returning you to Main Menu ...");		
	}

}
