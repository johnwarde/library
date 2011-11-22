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

	/**
	 * @param params
	 * @return
	 */
	public static LibraryItem makeLibraryItem(Object[] params) {
		String  type    = (String)  params[0];
		String  code 	= (String)  params[1];
		Date pubDate = null; 
		try {  
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			pubDate = (Date) formatter.parse((String) params[2]);
		} 
		catch (ParseException e) {
			System.out.println("Exception :"+e);
		}  
		String title = (String) params[3]; 				
		if (type.equals("Book")) {
			String author = (String) params[4];
			String publisherName = (String) params[5];
			int edition = (Integer) params[6];
			return new Book(code, title, pubDate, author, publisherName, edition);
		}
		if (type.equals("DVD")) {
			String artist = (String) params[4];
			String genre  = (String) params[5];
			return new Dvd(code, title, pubDate, artist, genre);
		}
		if (type.equals("Periodical")) {
			String author = (String) params[4];
			String periodicalName  = (String) params[5];
			return new Periodical(code, title, pubDate, author, periodicalName);
		}
		assert false : "Invalid Library Item Type";
		return null;
	}
	
}
