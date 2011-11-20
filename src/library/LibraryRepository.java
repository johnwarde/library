package library;

public class LibraryRepository {
    private static final LibraryRepository instance = new LibraryRepository();
    private Catalog lib;
    private Members users;
 
    public static LibraryRepository getInstance() {
            return instance;
    }        
        
    // Private constructor prevents instantiation from other classes
    private LibraryRepository() { 
    	lib = new Catalog();
    	users = new Members();
    	loadData();
    }
    
    public Catalog getCatalog() {
    	return lib;
    }
    
    public Members getUsers() {
    	return users;
    }
    
	private void loadData() {
		Object[][] csv = {
				 // Type,  code,    onLoan, pubDate,      title,        author,       publisherName, edition, 
				 {"Book", "SKU001", false, "01/01/2011", "First Book",  "John Warde", "O'Reilly",    1},
				 {"Book", "SKU002", false, "01/01/2011", "Second Book", "Brian Warde", "O'Reilly",   2},
				 
				 // Type,  code,    onLoan, pubDate,      title,     artist, genre
				 {"DVD",  "SKU003", false, "12/11/2001", "Monster", "REM",   "Rock"},
				 {"DVD",  "SKU004", false, "12/11/2001", "One Tree Hill", "U2",   "Rock"},
				 
				 // Type,            code,     onLoan, pubDate,     title,       author,  periodicalName
				 {"Periodical",  "SKU005", false, "12/04/1996", "Quick one", "Steorn",   "Steorn Monthly"}
		};
		LibraryItem item;
		for (Object[] record : csv) {
			item = LibraryItemFactory.makeLibraryItem(record);
			lib.add(item);
		}
		
		String[][] csv_users = {
				{"Johnny Fenton", "Cork"},
				{"Elvis Presley", "Graceland"},
				{"JB", "Ballinasloe"}
		};
		String name;
		String address;
		User userNew;
		int libraryId = 0;
		for (String[] record : csv_users) {
			name = record[0];
			address = record[1];
			userNew = new User(libraryId, name, address);
			users.add(userNew);
			libraryId++;
		}		
	}
}

