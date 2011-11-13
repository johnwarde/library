/**
 * 
 */
package library;

import java.util.Calendar;

import library.Menu;
import library.User;

/**
 * @author johnwarde
 *
 */
public class Library {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Clean this up
		loadData();
		System.out.println("Here");
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
		
		String[] mainMenuOptions = {"One", "Two", "Three"};
		Menu mainMenu = new Menu("Main Menu", mainMenuOptions);
		System.out.print(mainMenu.getMenuToDisplay());
		int choice = mainMenu.getUserSelection();
		System.out.print(choice);
	}
	

	/**
	 * Helper function to load some items into the library
	 * @return
	 */
	static private boolean loadData() {
		final int ITEM_BOOK 		= 0;
		final int ITEM_DVD 			= 1;
		final int ITEM_PERIODICAL 	= 2;
		Object[][] csv = {
				// Type,     code,     onLoan, pubDate,      title,        author,      publisherName, edition, 
				 {ITEM_BOOK, "SKU001", false, "01/01/2011", "First Book", "John Warde", "O'Reilly", 1},
				 {ITEM_BOOK, "SKU002", false, "01/01/2011", "Second Book", "Brian Warde", "O'Reilly", 2},
				 
				// Type,     code,     onLoan, pubDate,      title,     artist, genre
				 {ITEM_DVD,  "SKU003", false, "12/11/2001", "Monster", "REM",   "O'Reilly"},
				 {ITEM_DVD,  "SKU004", false, "12/11/2001", "U2", "One Tree Hill",   "Guinness"},
				 
				// Type,            code,     onLoan, pubDate,     title,       author,  periodicalName
				 {ITEM_PERIODICAL,  "SKU005", false, "12/04/1996", "Quick one", "Steorn",   "Steorn Monthly"}
		};
		int fieldCount = 0;
		for (Object[] fields : csv) {
			fieldCount = 0;
			// TODO: Apply Factory pattern for object creation
			for (Object entry : fields) {
				System.out.print(String.format("%d:%s, ", fieldCount, entry));
				fieldCount++;
			}
			System.out.println();
		}
		// TODO: Do I need to create and class to retain all users?
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(1, "Johnny Fenton", "Cork"));
		users.add(new User(2, "Elvis Presley", "Graceland"));
		users.add(new User(3, "Sombody",       "Somewhere"));
		
		return true;
	}
	
	
}
