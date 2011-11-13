package library;

import java.util.Date;

public class Periodical extends LibraryItem {

	protected String 		author;
	protected String 		periodicalName;	
// TODO: create PagesRage class?
//	protected PagesRange 	pagesRange;	
	
	public Periodical() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 * @param onLoan
	 * @param author
	 * @param periodicalName
	 */
	public Periodical(String code, String title, Date pubDate, boolean onLoan,
			String author, String periodicalName) {
		super(code, title, pubDate, onLoan);
		this.author = author;
		this.periodicalName = periodicalName;
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
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the periodicalName
	 */
	public String getPeriodicalName() {
		return periodicalName;
	}

	/**
	 * @param periodicalName the periodicalName to set
	 */
	public void setPeriodicalName(String periodicalName) {
		this.periodicalName = periodicalName;
	}



}