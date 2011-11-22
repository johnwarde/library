package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Periodical extends LibraryItem {

	protected String 		author;
	protected String 		periodicalName;	
// TODO: PagesRage
	
	public Periodical() {

	}

	
	
	
	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 * @param onLoan
	 * @param author
	 * @param periodicalName
	 */
	public Periodical(String code, String title, Date pubDate, String author, String periodicalName) {
		super(code, title, pubDate);
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
	    DateFormat df = new SimpleDateFormat(LibraryRepository.DATE_FORMAT);
		String out = String.format(
				"\r\n\r\n" + 
				"Item:\t\t\t%s\r\n" + 
				"Code:\t\t\t%s\r\n" + 
				"On Loan:\t\t%s\r\n" +
				"Title:\t\t\t%s\r\n" +
				"Published:\t\t%s\r\n" +
				"Author:\t\t\t%s\r\n" +
				"Periodical Name:\t%s\r\n", 
				"Periodical",
				getCode(), 
				isOnLoan() ? "Yes" : "No",
				getTitle(),
				df.format(getPubDate()),
				getAuthor(),
				getPeriodicalName()
				);
		return out;
	}

	
	/* (non-Javadoc)
	 * @see library.LibraryItem#editWithForm(library.Form)
	 */
	@Override
	public void editWithForm(Form libItemForm) {
		super.editWithFormPre(libItemForm);
		libItemForm.addField("author", "Author", getAuthor());
		libItemForm.addField("periodicalName", "Publisher", getPeriodicalName());
		
		libItemForm.userFill();
		
		super.editWithFormPost(libItemForm);
		String newAuthor = (String) libItemForm.getFieldValue("author");	
		String newPeriodicalName = (String) libItemForm.getFieldValue("periodicalName");	
		setAuthor(newAuthor);
		setPeriodicalName(newPeriodicalName);		
	}
		
}
