/**
 * 
 */
package library;

import java.util.Calendar;

import library.Menu;

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
		System.out.println("Here");
		Calendar cal = Calendar.getInstance();
		cal.set(2011, 1, 9);
		Catalog lib = new Catalog();
		lib.add(new Book("a", "test", cal.getTime(), false, "jb", "aranbay", "first"));
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
}
