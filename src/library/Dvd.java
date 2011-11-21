/**
 * 
 */
package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author johnwarde
 *
 */
public class Dvd extends LibraryItem {

	protected String 	artist;
	protected String 	genre;	
	
	/**
	 * 
	 */
	public Dvd() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param title
	 * @param pubDate
	 * @param onLoan
	 * @param artist
	 * @param genre
	 */
	public Dvd(String code, String title, Date pubDate, boolean onLoan,
			String artist, String genre) {
		super(code, title, pubDate, onLoan);
		this.artist = artist;
		this.genre = genre;
	}

/*
	public static String getTypeForDisplay() {
		return "DVD";
	}
*/
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String anArtist) {
		this.artist = anArtist;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String aGenre) {
		this.genre = aGenre;
	}



	/* (non-Javadoc)
	 * @see library.OutputStrategy#toConsoleLine()
	 */
	@Override
	public String toConsoleLine() {
		String out = String.format("%-8s %c   %-10s %-26s %-15s", 
				getCode(),
				isOnLoan() ? 'Y' : 'N',
			    "DVD",
				getTitle(),
				getArtist()
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
				"Artist:\t\t\t%s\r\n" +
				"Genre:\t\t\t%s\r\n", 
				"DVD",
				getCode(), 
				isOnLoan() ? "Yes" : "No",
				getTitle(),
				df.format(getPubDate()),
				getArtist(),
				getGenre()
				);
		return out;	
	}
	
	public void editWithForm(Form libItemForm) {
		super.editWithFormPre(libItemForm);
		libItemForm.addField("artist", "Artist", getArtist());
		libItemForm.addField("genre", "Genre", getGenre());
		
		libItemForm.userFill();
		
		super.editWithFormPost(libItemForm);
		String newArtist = (String) libItemForm.getFieldValue("artist");	
		String newGenre = (String) libItemForm.getFieldValue("genre");	
		setArtist(newArtist);
		setGenre(newGenre);
	}	
	
}
