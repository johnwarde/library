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


	/* (non-Javadoc)
	 * @see library.LibraryItem#getTypeForDisplay()
	 */
	@Override
	public String getTypeForDisplay() {
		return "Periodical";
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




	/* (non-Javadoc)
	 * @see library.OutputStrategy#toConsoleLine()
	 */
	@Override
	public String toConsoleLine() {
		String out = String.format("%-8s %c   %-10s %-26s %-15s", 
				getCode(),
				isOnLoan() ? 'Y' : 'N',
			    "Periodical",
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
				"Periodical Name:\t%s\r\n", 
				getTypeForDisplay(),
				getCode(), 
				isOnLoan() ? "Yes" : "No",
				getTitle(),
				getPubDate(),
				getAuthor(),
				getPeriodicalName()
				);
		return out;
	}



}
