/**
 * 
 */
package library;

/**
 * @author johnwarde
 *
 */
public class User {

	protected int libraryId;
	protected String name;
	protected String address;
	// TO DO: object for storing LibraryItems
	// private obj? onLoan
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
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

}
