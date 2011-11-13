/**
 * 
 */
package library;

import java.util.Date;

/**
 * @author johnwarde
 *
 */
public class Dvd extends LibraryItem {

	protected String 	artist;
	protected Date 		genre;	
	
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
			String artist, Date genre) {
		super(code, title, pubDate, onLoan);
		this.artist = artist;
		this.genre = genre;
	}



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
	public Date getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Date aGenre) {
		this.genre = aGenre;
	}
	
}
