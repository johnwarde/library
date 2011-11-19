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
				new String[] {"Exit", "Library Catalog", "Library Users"});
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
					// List all items	
					LibraryRepository lib =  LibraryRepository.getInstance();
					Catalog items = lib.getCatalog();						
					catalogListItems(items);
					break;
				case 2:
					// List by category
					catalogListByCategory();
					break;
				case 3:
					// List available items by category
					catalogListAvailableByCategory();
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
	


	private void catalogListByCategory() {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Catalog items = lib.getCatalog();		
		Menu menu = new Menu("List by Category Menu", new String[] {
				"Return to main menu", 
				"List all Books", 
				"List all DVDs", 
				"List all Periodicals"
				});
		Catalog itemsAvailableInCategory = null;
		int choice = -1;
		do {
			System.out.print(menu.getMenuToDisplay());
			choice = menu.getUserSelection();
			switch (choice) {
				case 0:
					// Return to previous menu
					break;
				case 1:
					//itemsAvailableInCategory = CatalogViewer.getItemsByCategory(items, Book.class);
					break;
				case 2:
					//itemsAvailableInCategory = CatalogViewer.getItemsByCategory(items, Dvd.class);
					break;
				case 3:
					//itemsAvailableInCategory = CatalogViewer.getItemsByCategory(items, Periodical.class);
					break;
				default:
					placeHolderHelper(menu.getSelectedText(choice));
					break;					
			}
		} while (choice != 0);
		catalogListItems(itemsAvailableInCategory);		
	}

	private void catalogListAvailableByCategory() {
		// TODO Auto-generated method stub
		System.out.println("To be implemented");
		return;
	}	
	
	
	private void placeHolderHelper(String optionSelected) {
		System.out.println(
				String.format("\r\n\r\n\t %s has not yet been implemented, returning you to the previous menu", optionSelected));
	}

	private void catalogListItems(Catalog items) {
		if (0 == items.size()) {
			System.out.println("There are no items in the library catalog, returning you to the previous menu.");
			return;
		}
		int itemChoosen = -1;
		int menuChoice  = -1;
		while (itemChoosen != 0) {
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
			itemChoosen = lc.getUserOption();
			if (0 == itemChoosen) {
				break;
			}
			// Show the selected item
			LibraryItem selected = items.getIndex(itemChoosen - 1);
			System.out.println(selected.toConsoleFull());
			
			String [] menuOptions;
			if (selected.isOnLoan()) {
				menuOptions = new String[] {
						"Return to previous menu",
						"Check-in", 
						"Edit item", 
						"Delete item"};
			} else {
				menuOptions = new String[] {
						"Return to previous menu", 
						"Check-out",
						"Edit item", 
						"Delete item"};
			}

			Menu menu = new Menu("Library Item Menu", menuOptions);
			menuChoice = -1;
			while (menuChoice < 0 || menuChoice > 3) {
				System.out.print(menu.getMenuToDisplay());
				menuChoice = menu.getUserSelection();
				switch (menuChoice) {				
					case 0:
						// Return to previous menu
						break;				
					case 1:
						if (selected.isOnLoan()) {
							// Check-in
						} else {
							// Check-out
						}
						break;
//					case 2:
//						editLibraryItem(selected);
//						// TODO: maybe just need to go back to list of items
//						break;					
					case 3:
						deleteLibraryItem(selected);
						// TODO: maybe just need to go back to list of items
						break;	
					default:
						placeHolderHelper(menu.getSelectedText(menuChoice));
						break;					
				}
			}
		}
	}

	private void deleteLibraryItem(LibraryItem selected) {
		Confirmation ui = new Confirmation("Are you sure you want to delete this library item? (y/n)");
		if (ui.getUserChoice()) {
			LibraryRepository lib =  LibraryRepository.getInstance();
			Catalog items = lib.getCatalog();
			items.remove(selected);
		}
	}

	private void showUsersMenu() {
		Menu usersMenu = new Menu("Library Users", 
				new String[] {"Return to main menu", 
							  "List all users", 
							  "List users with loans", 
							  "Add user"});
		System.out.print(usersMenu.getMenuToDisplay());
		System.out.println(String.format("\r\n\tNot implemented, returning you to Main Menu ..."));
	}


}
