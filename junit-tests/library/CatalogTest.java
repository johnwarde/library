package library;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;

public class CatalogTest extends Catalog {


	@Test
	public void testSize() {
		Date testDate = null;
		try {  
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			testDate = (Date) formatter.parse((String) "01/01/1970");
		} 
		catch (ParseException e) {
			System.out.println("Exception :"+e);
		}  		
		Catalog tc = new Catalog();
		tc.add(new Book("test01", "mytitle", testDate, "me", "publisher", 1));
		assertEquals(1, tc.size());
	}

	@Test
	public void testAdd() {
		Date testDate = null;
		try {  
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			testDate = (Date) formatter.parse((String) "01/01/1970");
		} 
		catch (ParseException e) {
			System.out.println("Exception :"+e);
		}  		
		Catalog tc = new Catalog();
		tc.add(new Book("test01", "mytitle", testDate, "me", "publisher", 1));
		assertEquals(1, tc.size());
	}

	@Test
	public void testRemove() {
		Date testDate = null;
		try {  
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			testDate = (Date) formatter.parse((String) "01/01/1970");
		} 
		catch (ParseException e) {
			System.out.println("Exception :"+e);
		}  		
		Catalog tc = new Catalog();
		Book testBook = new Book("test01", "mytitle", testDate, "me", "publisher", 1);
		tc.add(testBook);
		tc.remove(testBook);
		assertEquals(0, tc.size());
	}

	@Test
	public void testFind() {
		Date testDate = null;
		try {  
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			testDate = (Date) formatter.parse((String) "01/01/1970");
		} 
		catch (ParseException e) {
			System.out.println("Exception :"+e);
		}  		
		Catalog tc = new Catalog();
		String testCode = "test01";
		Book testBook = new Book(testCode, "mytitle", testDate, "me", "publisher", 1);
		tc.add(testBook);
		Book foundBook = (Book) tc.find(testCode);
		assertEquals(foundBook, testBook);
	}

}
