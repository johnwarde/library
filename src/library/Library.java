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
		System.out.println("Library System starting up ... ");
		System.out.println();
		
		LibraryManagerConsole mgr = new LibraryManagerConsole();
		mgr.init();

		System.out.println();		
		System.out.println("Library System shutting down ... ");
		
	}

}
