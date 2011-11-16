/**
 * 
 */
package library;

import java.util.Date;

/**
 * @author johnwarde
 *
 */
abstract public class LibraryItem implements OutputStrategy{

	protected String 	code;
	protected String 	title;
	protected Date 		pubDate;
	protected boolean 	onLoan;
	
	/**
	 * 
	 */
	public LibraryItem() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 * @param onLoan
	 */
	public LibraryItem(String code, String title, Date pubDate, boolean onLoan) {
		super();
		this.code 		= code;
		this.title 		= title;
		this.pubDate 	= pubDate;
		this.onLoan 	= onLoan;
	}




	public String getCode() {
		return code;
	}

	public String getTypeForDisplay() {
		return "need to be overridden in child classes";
	}

	public void setCode(String aCode) {
		this.code = aCode;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String aTitle) {
		this.title = aTitle;
	}


	public Date getPubDate() {
		return pubDate;
	}


	public void setPubDate(Date aPubDate) {
		this.pubDate = aPubDate;
	}


	public boolean isOnLoan() {
		return onLoan;
	}


	public void setOnLoan(boolean onLoanVal) {
		this.onLoan = onLoanVal;
	}

}
