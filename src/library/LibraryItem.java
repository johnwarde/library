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
	
	/**
	 * 
	 */
	public LibraryItem() {
	}

	
	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 */
	public LibraryItem(String code, String title, Date pubDate) {
		super();
		this.code 		= code;
		this.title 		= title;
		this.pubDate 	= pubDate;
	}




	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	
	/**
	 * @param aCode
	 */
	public void setCode(String aCode) {
		this.code = aCode;
	}


	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param aTitle
	 */
	public void setTitle(String aTitle) {
		this.title = aTitle;
	}


	/**
	 * @return
	 */
	public Date getPubDate() {
		return pubDate;
	}


	/**
	 * @param aPubDate
	 */
	public void setPubDate(Date aPubDate) {
		this.pubDate = aPubDate;
	}


	/**
	 * @return
	 */
	public boolean isOnLoan() {
		LibraryRepository lib = LibraryRepository.getInstance();
		Loans loans = lib.getLoans();
		return loans.isItemOnLoan(getCode());
	}

	
	/**
	 * @param libItemForm
	 */
	abstract public void editWithForm(Form libItemForm);

	
	/**
	 * @param libItemForm
	 */
	public void editWithFormPre(Form libItemForm) {
		libItemForm.addField("code", "Library Code", getCode());
		libItemForm.addField("title", "Book Title", getTitle());
		libItemForm.addField("pubdate", "Publish Date", getPubDate());		
	}
	
	/**
	 * @param libItemForm
	 */
	public void editWithFormPost(Form libItemForm) {
		String newCode = (String) libItemForm.getFieldValue("code");
		String newTitle = (String) libItemForm.getFieldValue("title");
		Date newPubDate = (Date) libItemForm.getFieldValue("pubdate");
		setCode(newCode);
		setTitle(newTitle);
		setPubDate(newPubDate);		
	}

}
