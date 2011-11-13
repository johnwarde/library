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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [author=" + author + ", publisherName=" + publisherName
				+ ", edition=" + edition + ", code=" + code + ", title="
				+ title + ", pubDate=" + pubDate + ", onLoan=" + onLoan + "]";
	}

}