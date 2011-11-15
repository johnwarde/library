/**
 * 
 */
package library;

import java.util.*;
import java.text.*;


import library.LibraryItem;

/**
 * @author johnwarde
 * 
 * This creates concrete sub-classes of the abstract class LibraryItem,
 * used the Factory pattern
 */
public class LibraryItemFactory {
	// TODO: Use/Remove?
	final int ITEM_BOOK 		= 0;
	final int ITEM_DVD 			= 1;
	final int ITEM_PERIODICAL 	= 2;
	
	
	
	public static LibraryItem makeLibraryItem(Object[] params) {
		String  code 	= (String) params[1];
		boolean onLoan 	= (Boolean) params[2];
		Date pubDate = null; 
		try {  
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			pubDate = (Date) formatter.parse((String) params[3]);
//			System.out.println("pubDate: " + pubDate );
		} 
		catch (ParseException e) {
			System.out.println("Exception :"+e);
		}  
		String title = (String) params[4]; 				
		if (params[0].equals("Book")) {
			String author = (String) params[5];
			String publisherName = (String) params[6];
			int edition = (Integer) params[7];
			return new Book(code, title, pubDate, onLoan, author, publisherName, edition);
		}
		if (params[0].equals("Dvd")) {
			String artist = (String) params[5];
			String genre  = (String) params[6];
			return new Dvd(code, title, pubDate, onLoan, artist, genre);
		}
		if (params[0].equals("Periodical")) {
			String author = (String) params[5];
			String periodicalName  = (String) params[6];
			return new Periodical(code, title, pubDate, onLoan, author, periodicalName);
		}
		assert false : "Invalid Library Item Type";
		return null;
	}
	
}
