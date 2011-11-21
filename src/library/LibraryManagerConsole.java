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
				"Return to previous menu", 
				"List all items", 
				"List by category", 
				"List available items by category", 
				"Add new library item"
				});
		int choice = -1;
		while (choice != 0) {
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
				case 4:
					// List available items by category
					newLibraryItem();
					break;						
				case 0:
					// Return to main menu
					break;
				default:
					placeHolderHelper(libMenu.getSelectedText(choice));
					break;					
			}
		}		
	}
	


	private void catalogListByCategory() {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Catalog items = lib.getCatalog();		
		Menu menu = new Menu("List by Category Menu", new String[] {
				"Return to previous menu", 
				"List all Books", 
				"List all DVDs", 
				"List all Periodicals"
				});
		Catalog itemsInCategory = null;
		int choice = -1;
		while (choice != 0) {
			System.out.print(menu.getMenuToDisplay());
			choice = menu.getUserSelection();
			switch (choice) {
				case 0:
					// Return to previous menu
					break;
				case 1:
					// TODO: fix so that can pass class type, using workaround
//					itemsAvailableInCategory = CatalogViewer.getItemsByCategory(items, Book.class);
					itemsInCategory = CatalogViewer.itemsByCategory(items, new Book());
					break;
				case 2:
					itemsInCategory = CatalogViewer.itemsByCategory(items, new Dvd());
					break;
				case 3:
					itemsInCategory = CatalogViewer.itemsByCategory(items, new Periodical());
					break;				
			}
			catalogListItems(itemsInCategory);					
		}
	}

	private void catalogListAvailableByCategory() {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Catalog items = lib.getCatalog();		
		Menu menu = new Menu("List Available by Category Menu", new String[] {
				"Return to previous menu", 
				"List all available Books", 
				"List all available DVDs", 
				"List all available Periodicals"
				});
		Catalog itemsAvailableInCategory = null;
		int choice = -1;
		while (choice != 0) {
			System.out.print(menu.getMenuToDisplay());
			choice = menu.getUserSelection();
			switch (choice) {
				case 0:
					// Return to previous menu
					break;
				case 1:
					// TODO: fix so that can pass class type, using workaround
//					itemsAvailableInCategory = CatalogViewer.getItemsByCategory(items, Book.class);
					itemsAvailableInCategory = CatalogViewer.itemsByCategory(items, new Book());
					itemsAvailableInCategory = CatalogViewer.itemsAvailable(itemsAvailableInCategory);
					break;
				case 2:
					//itemsAvailableInCategory = CatalogViewer.itemsByCategory(items, new Dvd());
					itemsAvailableInCategory = CatalogViewer.itemsByCategory(items, new Dvd());
					itemsAvailableInCategory = CatalogViewer.itemsAvailable(itemsAvailableInCategory);
					break;
				case 3:					
					//itemsAvailableInCategory = CatalogViewer.itemsByCategory(items, new Periodical());
					itemsAvailableInCategory = CatalogViewer.itemsByCategory(items, new Periodical());
					itemsAvailableInCategory = CatalogViewer.itemsAvailable(itemsAvailableInCategory);
					break;				
			}
			catalogListItems(itemsAvailableInCategory);					
		}
	}	
	
	
	private void placeHolderHelper(String optionSelected) {
		System.out.println(
				String.format("\r\n\r\n\t %s has not yet been implemented, returning you to the previous menu", optionSelected));
	}

	private void catalogListItems(Catalog items) {

		int itemChoosen = -1;
		int menuChoice  = -1;
		while (itemChoosen != 0) {
			if (0 == items.size()) {
				System.out.println();
				System.out.println("There are no items to list, returning you to the previous menu.");
				return;
			}			
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
							// TODO: Check-in
							itemCheckIn(selected);
						} else {
							itemCheckOut(selected);
						}
						break;
					case 2:
						editLibraryItem(selected);
						// TODO: maybe just need to go back to list of items
						break;					
					case 3:
						deleteLibraryItem(selected, items);
						break;	
					default:
						placeHolderHelper(menu.getSelectedText(menuChoice));
						break;					
				}
			}
		}
	}


	/**
	 * Checks out an item to a specific user
	 * @param selected
	 */
	private void itemCheckOut(LibraryItem selected) {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Members users = lib.getUsers();		
		User loanUser;
		Prompt promptForUser = new Prompt("Enter name or user id");		
		String user;
		boolean isValidInt = true;
		int validInt = -1;
		while (true) {
			user = promptForUser.getUserChoice();
			isValidInt = true;
			validInt = -1;
			try {
				validInt = Integer.parseInt((String) user);
			} catch (Exception e) {
				isValidInt = false;
			}
			if (0 == user.length()) {
				// user abort
				return;
			}
			if (isValidInt) {
				loanUser = users.find(validInt);
			} else {
				loanUser = users.find(user);				
			}
			if (null == loanUser) {
				System.out.print(String.format("\r\nCannot find user for '%s', " +
						"please try again or \r\n" +
						"press return to previous menu.\r\n", user));
			} else {
				// Found a valid user
				System.out.println(loanUser.toConsoleFull());
				Confirmation confirmCheckout = new Confirmation("Check-out item to above user?");
				if (confirmCheckout.getUserChoice()) {
					Loans loans = lib.getLoans();
					loans.add(selected.getCode(), loanUser.getLibraryId());
					break;
				}
			}
		}
	}
	
	private void itemCheckIn(LibraryItem selected) {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Loans loans = lib.getLoans();
		Members users = lib.getUsers();		
		User loanUser;
		String libCode = selected.getCode();
		int userId = loans.getUserIdForLoanItem(libCode);
		loanUser = users.find(userId);
		Confirmation confirmCheckout = new Confirmation(String.format("Is %s returning this item?", loanUser.getName()));
		if (confirmCheckout.getUserChoice()) {
			loans.removeItem(libCode);
		}		
	}	

	private void editLibraryItem(LibraryItem selected) {
		if (selected.onLoan) {
			System.out.println();			
			System.out.println("You cannot edit an item that is out on loan, ");
			System.out.println("returning you to the previous menu");
			System.out.println();			
			return;
		}
		Form libItemForm = new Form("Edit Library Item", false);
		selected.editWithForm(libItemForm);
	}

	private void newLibraryItem() {
		LibraryRepository lib =  LibraryRepository.getInstance();
		Catalog items = lib.getCatalog();		
		Menu menu = new Menu("New Library Item Menu", new String[] {
				"Return to previous menu", 
				"New Book", 
				"New DVD", 
				"New Periodical"
				});
		Form libItemForm = new Form("New Library Item", true);
		LibraryItem newItem = null;
		int choice = -1;
		while (choice != 0) {
			System.out.print(menu.getMenuToDisplay());
			choice = menu.getUserSelection();
			switch (choice) {
				case 0:
					// Return to previous menu
					return;
				case 1:
					newItem = new Book();
					break;
				case 2:
					newItem = new Dvd();					
					break;
				case 3:
					newItem = new Periodical();
					break;				
			}
			newItem.editWithForm(libItemForm);
			items.add(newItem);		
		}		
	}	
	
	private void deleteLibraryItem(LibraryItem selected, Catalog subset) {
		Confirmation ui = new Confirmation("Are you sure you want to delete this library item? (y/n)");
		if (ui.getUserChoice()) {
			subset.remove(selected);
			LibraryRepository lib =  LibraryRepository.getInstance();
			Catalog items = lib.getCatalog();
			if (subset != items) {
				items.remove(selected);				
			}
		}
	}

	private void showUsersMenu() {
		Menu usersMenu = new Menu("Library Users", 
				new String[] {"Return to previous menu", 
							  "List all users", 
							  "List users with loans", 
							  "Add user"});
		int choice = -1;
		while (choice != 0) {
			System.out.print(usersMenu.getMenuToDisplay());
			choice = usersMenu.getUserSelection();
			switch (choice) {
				case 1:
					// List all users	
					LibraryRepository lib = LibraryRepository.getInstance();
					Members members = lib.getUsers();						
					usersList(members);
					break;
//				case 2:
//					// List users with loans
//					Members usersWithLoans = MembersViewer.usersWithLoans();
//					usersList(members);
//					break;
				case 3:
					// Add user
					userAdd();
					break;					
				case 0:
					// Return to main menu
					break;
				default:
					placeHolderHelper(usersMenu.getSelectedText(choice));
					break;					
			}
		}		
	}


	private void usersList(Members users) {
		int itemChoosen = -1;
		int menuChoice  = -1;
		while (itemChoosen != 0) {
			if (0 == users.size()) {
				System.out.println();
				System.out.println("There are no users to list, returning to the previous menu.");
				return;
			}			
			System.out.print(String.format("\r\n\r\n" + 
				"Choice Library\r\n" + 
				"  No.    ID    Name                Address\r\n" + 
				"------ ------- ------------------- -------------------------\r\n"));
			User user;
			users.first();
			int count = 1;
			while (users.hasNext()) {
				user = users.getCurrent();
				System.out.println(String.format("%6d %s", count, user.toConsoleLine()));
				users.next();
				count++;
			}
			ListChoice lc = new ListChoice(count - 1);
			System.out.println(lc.getMenuToDisplay());
			itemChoosen = lc.getUserOption();
			if (0 == itemChoosen) {
				break;
			}
			// Show the selected item
			User selected = users.getIndex(itemChoosen - 1);
			System.out.println(selected.toConsoleFull());
			
			Menu menu = new Menu("Select User Menu", new String[] {
					"Return to previous menu", 
					"List all library items on loan",
					"Edit User", 
					"Delete User"});
			menuChoice = -1;
			while (menuChoice < 0 || menuChoice > 3) {
				System.out.print(menu.getMenuToDisplay());
				menuChoice = menu.getUserSelection();
				switch (menuChoice) {				
					case 0:
						// Return to previous menu
						break;				
					case 1:
						// List all library items on loan
						break;
					case 2:
						editUser(selected);
						break;					
					case 3:
						deleteUser(selected, users);
						break;	
					default:
						placeHolderHelper(menu.getSelectedText(menuChoice));
						break;					
				}
			}
		}
		
	}


	private void userAdd() {
		Form userDetailsForm = new Form("New User", true);
		//                        UI id, prompt, default value 
		userDetailsForm.addField("name", "Name", "");
		userDetailsForm.addField("addr", "Address", "");
		userDetailsForm.userFill();
		String newName = (String) userDetailsForm.getFieldValue("name");
		String newAddr = (String) userDetailsForm.getFieldValue("addr");
		LibraryRepository lib =  LibraryRepository.getInstance();
		Members users = lib.getUsers();		
		User toAdd = new User(lib.getNewLibraryId(), newName, newAddr);
		toAdd.setName(newName);
		toAdd.setAddress(newAddr);		
		users.add(toAdd);
	}	
	

	private void editUser(User selected) {
		Form userDetailsForm = new Form("Edit User", false);
		//                        UI id, prompt, default value 
		userDetailsForm.addField("name", "Name", selected.getName());
		userDetailsForm.addField("addr", "Address", selected.getAddress());
		userDetailsForm.userFill();
		String newName = (String) userDetailsForm.getFieldValue("name");
		String newAddr = (String) userDetailsForm.getFieldValue("addr");	
		selected.setName(newName);
		selected.setAddress(newAddr);
	}
	
	
	private void deleteUser(User selected, Members subset) {
		Confirmation ui = new Confirmation("Are you sure you want to delete this user? (y/n)");
		if (ui.getUserChoice()) {
			subset.remove(selected);
			LibraryRepository lib =  LibraryRepository.getInstance();
			Members users = lib.getUsers();
			if (subset != users) {
				users.remove(selected);				
			}
		}
	}
	
}
