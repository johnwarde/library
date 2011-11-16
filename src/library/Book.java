package library;

import java.util.Date;

public class Book extends LibraryItem {

	protected String 	author;
	protected String 	publisherName;
	protected int  		edition;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 * @param onLoan
	 * @param author
	 * @param publisherName
	 * @param edition
	 */
	public Book(String code, String title, Date pubDate, boolean onLoan, String author, String publisherName, int edition) {
//	public Book(String code, String title, Date pubDate, String author, String publisherName, int edition) {
		
		super(code, title, pubDate, false);
		this.author = author;
		this.publisherName = publisherName;
		this.edition = edition;
	}



	/* (non-Javadoc)
	 * @see library.LibraryItem#getTypeForDisplay()
	 */
	@Override
	public String getTypeForDisplay() {
		return "Book";
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}

	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String aPublisherName) {
		this.publisherName = aPublisherName;
	}

	/**
	 * @return the edition
	 */
	public int getEdition() {
		return edition;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(int editionNo) {
		this.edition = editionNo;
	}

	
	
	
	/* (non-Javadoc)
	 * @see library.OutputStrategy#toConsoleLine()
	 */
	@Override
	public String toConsoleLine() {
		String out = String.format("%-8s %c   %-10s %-26s %-15s", 
						getCode(),
						isOnLoan() ? 'Y' : 'N',
					    "Book",
						getTitle(),
						getAuthor()
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
				"Item:\t\t%s\r\n" + 
				"Code:\t\t%s\r\n" + 
				"On Loan:\t%s\r\n" +
				"Title:\t\t%s\r\n" +
				"Published:\t%s\r\n" +
				"Author:\t\t%s\r\n" +
				"Publisher:\t%s\r\n" +
				"Edition:\t%d\r\n", 
				getTypeForDisplay(),
				getCode(), 
				isOnLoan() ? "Yes" : "No",
				getTitle(),
				getPubDate(),
				getAuthor(),
				getPublisherName(),
				getEdition()
				);
		return out;		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [author=" + author + ", publisherName=" + publisherName
				+ ", edition=" + edition + ", code=" + code + ", title="
				+ title + ", pubDate=" + pubDate + ", onLoan=" + onLoan + "]";
	}

}
