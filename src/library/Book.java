package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends LibraryItem {
	protected String 	author;
	protected String 	publisherName;
	protected int  		edition;
	
	public Book() {
	}

	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 * @param author
	 * @param publisherName
	 * @param edition
	 */
	public Book(String code, String title, Date pubDate, String author, String publisherName, int edition) {
		
		super(code, title, pubDate);
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
	    DateFormat df = new SimpleDateFormat(LibraryRepository.DATE_FORMAT);
		String out = String.format(
				"\r\n\r\n" + 
				"Item:\t\t\t%s\r\n" + 
				"Code:\t\t\t%s\r\n" + 
				"On Loan:\t\t%s\r\n" +
				"Title:\t\t\t%s\r\n" +
				"Published:\t\t%s\r\n" +
				"Author:\t\t\t%s\r\n" +
				"Publisher:\t\t%s\r\n" +
				"Edition:\t\t%d\r\n", 
				"Book",
				getCode(), 
				isOnLoan() ? "Yes" : "No",
				getTitle(),
				df.format(getPubDate()),
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
				+ title + ", pubDate=" + pubDate + ", onLoan=" + "]";
	}

	/* (non-Javadoc)
	 * @see library.LibraryItem#editWithForm(library.Form)
	 */
	@Override
	public void editWithForm(Form libItemForm) {
		super.editWithFormPre(libItemForm);
		libItemForm.addField("author", "Author", getAuthor());
		libItemForm.addField("edition", "Book Edition", getEdition());
		libItemForm.addField("publisherName", "Publisher", getPublisherName());
		
		libItemForm.userFill();
		
		super.editWithFormPost(libItemForm);
		String newAuthor = (String) libItemForm.getFieldValue("author");	
		int newEditionNo = (int) libItemForm.getFieldValue("edition");	
		String newPublisher = (String) libItemForm.getFieldValue("publisherName");	
		setAuthor(newAuthor);
		setEdition(newEditionNo);
		setPublisherName(newPublisher);		
	}

}
