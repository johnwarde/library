package library;


public class LibraryRepository {
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final LibraryRepository instance = new LibraryRepository();
    private Catalog lib;
    private Members users;
    private int lastLibraryId = 0;
	private Loans loans;
 
    /**
     * @return
     */
    public static LibraryRepository getInstance() {
            return instance;
    }        
        
    // Private constructor prevents instantiation from other classes
    /**
     * 
     */
    private LibraryRepository() { 
    	lib = new Catalog();
    	users = new Members();
    	loans = new Loans();
    	loadData();
    }
    
    /**
     * @return
     */
    public Catalog getCatalog() {
    	return lib;
    }
    
    /**
     * @return
     */
    public Members getUsers() {
    	return users;
    }
    
	/**
	 * @return
	 */
	public Loans getLoans() {
		return loans;
	}    
	/**
	 * This new ID needs to be used straight away
	 * @return the lastLibraryId
	 */
	public int getNewLibraryId() {
		return lastLibraryId++;
	}

	/**
	 * Loads test data
	 */
	private void loadData() {
		Object[][] csv = {
				 // Type,  code,    pubDate,      title,        author,       publisherName, edition, 
				 {"Book", "SKU001", "01/04/1999", "Catch 22",  "Joseph Heller", "Simon & Schuster",    1},
				 {"Book", "SKU002", "02/03/2006", "Second Book", "Brian Warde", "O'Reilly",   2},
				 
				 // Type,  code,    pubDate,      title,     artist, genre
				 {"DVD",  "SKU003", "12/11/2001", "Monster", "REM",   "Pop"},
				 {"DVD",  "SKU004", "22/07/1980", "One Tree Hill", "U2",   "Rock"},
				 
				 // Type,         code,     pubDate,     title,       author,  periodicalName
				 {"Periodical",  "SKU005", "12/04/1996", "Business Week", "Simon Shaw",   "McGraw-Hill"}
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
		for (String[] record : csv_users) {
			name = record[0];
			address = record[1];
			userNew = new User(getNewLibraryId(), name, address);
			users.add(userNew);
		}		
	}


}

