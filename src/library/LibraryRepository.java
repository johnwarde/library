package library;

public class LibraryRepository {
    private static final LibraryRepository instance = new LibraryRepository();
    private Catalog lib;
 
    public static LibraryRepository getInstance() {
            return instance;
    }        
        
    // Private constructor prevents instantiation from other classes
    private LibraryRepository() { 
    	lib = new Catalog();
    	loadData();
    }
    
    public Catalog getCatalog() {
    	return lib;
    }
    
	private void loadData() {
		Object[][] csv = {
				 // Type,  code,    onLoan, pubDate,      title,        author,       publisherName, edition, 
				 {"Book", "SKU001", false, "01/01/2011", "First Book",  "John Warde", "O'Reilly",    1},
				 {"Book", "SKU002", false, "01/01/2011", "Second Book", "Brian Warde", "O'Reilly",   2},
				 
				 // Type,  code,    onLoan, pubDate,      title,     artist, genre
				 {"Dvd",  "SKU003", false, "12/11/2001", "Monster", "REM",   "Rock"},
				 {"Dvd",  "SKU004", false, "12/11/2001", "One Tree Hill", "U2",   "Rock"},
				 
				 // Type,            code,     onLoan, pubDate,     title,       author,  periodicalName
				 {"Periodical",  "SKU005", false, "12/04/1996", "Quick one", "Steorn",   "Steorn Monthly"}
		};
		LibraryItem item;
		for (Object[] record : csv) {
			item = LibraryItemFactory.makeLibraryItem(record);
			lib.add(item);
		}
		String debug = lib.toString();		
		System.out.println(debug);
	}
}

