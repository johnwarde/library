/**
 * 
 */
package library;

/**
 * @author johnwarde
 *
 */
public class User implements OutputStrategy{
	protected int libraryId;
	protected String name;
	protected String address;
	protected String[] itemsOnLoan;

	/**
	 * @param libraryId
	 * @param name
	 * @param address
	 */
	public User(int libraryId, String name, String address) {
		super();
		this.libraryId = libraryId;
		this.name = name;
		this.address = address;
	}
		
	/**
	 * @return the libraryId
	 */
	public int getLibraryId() {
		return libraryId;
	}
	/**
	 * @param libraryId the libraryId to set
	 */
	public void setLibraryId(int aLibraryId) {
		this.libraryId = aLibraryId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String aName) {
		this.name = aName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String anAddress) {
		this.address = anAddress;
	}

	/* (non-Javadoc)
	 * @see library.OutputStrategy#toConsoleLine()
	 */
	@Override
	public String toConsoleLine() {
		String out = String.format("%7d %-20s %-25s", 
				getLibraryId(),
				getName(),
				getAddress()
				);
		return out;
	}

	/* (non-Javadoc)
	 * @see library.OutputStrategy#toConsoleFull()
	 */
	@Override
	public String toConsoleFull() {
		String out = String.format(
				"\r\n\r\n" + 
				"Library ID:\t%d\r\n" + 
				"Name:\t\t%s\r\n" +
				"Address:\t%s\r\n",
				getLibraryId(), 
				getName(),
				getAddress()
				);
		return out;	
	}

}
