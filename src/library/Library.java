/**
 * 
 */
package library;

import library.User;

/**
 * @author johnwarde
 *
 */
public class Library {
	//static Catalog lib;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Clean this up
		System.out.println("Library System starting up ... ");
		System.out.println();
		
		// TODO: remove, left here for testing, make sure data is right
		LibraryRepository lib = LibraryRepository.getInstance(); lib.toString();
		
		LibraryManagerConsole mgr = new LibraryManagerConsole();
		mgr.init();

		System.out.println();		
		System.out.println("Library System shutting down ... ");
		

		
		loadData();
		
		/*
		Calendar cal = Calendar.getInstance();
		cal.set(2011, 1, 9);
		Catalog lib = new Catalog();
		lib.add(new Book("a", "test", cal.getTime(), false, "jb", "aranbay", 1));
		
/*		
		Book aBook = new Book();
		aBook.setAuthor("John");
		aBook.setCode("a1");
		aBook.setOnLoan(false);
		aBook.setEdition("First");
		aBook.setPublisherName("JB");
		aBook.setTitle("My FirstBook");
		// TODO: publish date
		aBook.setPubDate(cal.getTime());
		System.out.println(aBook.toString());
*/
		
	}
	

	/**
	 * Helper function to load some items into the library
	 * @return
	 */
	static private boolean loadData() {
/*
		Object[][] csv = {
				// Type,     code,     onLoan, pubDate,      title,        author,      publisherName, edition, 
				 {"Book", "SKU001", false, "01/01/2011", "First Book", "John Warde", "O'Reilly", 1},
				 {"Book", "SKU002", false, "01/01/2011", "Second Book", "Brian Warde", "O'Reilly", 2},
				 
				// Type,     code,     onLoan, pubDate,      title,     artist, genre
				 {"Dvd",  "SKU003", false, "12/11/2001", "Monster", "REM",   "O'Reilly"},
				 {"Dvd",  "SKU004", false, "12/11/2001", "U2", "One Tree Hill",   "Guinness"},
				 
				// Type,            code,     onLoan, pubDate,     title,       author,  periodicalName
				 {"Periodical",  "SKU005", false, "12/04/1996", "Quick one", "Steorn",   "Steorn Monthly"}
		};
		LibraryItem item;
		for (Object[] record : csv) {
			item = LibraryItemFactory.makeLibraryItem(record);
			lib.add(item);
		}
*/
		
		// TODO: Do I need to create and class to retain all users?
		
		User[] users = {
				new User(1, "Johnny Fenton", "Cork"),
				new User(2, "Elvis Presley", "Graceland"),
				new User(2, "Elvis Presley", "Graceland"),
		};
		System.out.println(users);

		return true;
	}
	
	
}
