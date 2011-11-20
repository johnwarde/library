/**
 * 
 */
package library;

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

}
