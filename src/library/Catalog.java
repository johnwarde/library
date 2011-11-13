/**
 * 
 */


package library;

import java.util.ArrayList; 

/**
 * @author johnwarde
 *
 */
public class Catalog implements Traverser {
	private ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();;
	
	public Catalog() {
		super();
	}

	
	
	protected boolean add(LibraryItem toAdd) {
		// TODO: validate: does it already exist
		items.add(toAdd);
		return true;
	}
	
	protected boolean remove(String aCode) {
		return true;
	}
	
	protected LibraryItem find(String aCode) {
		for (LibraryItem item : items) {
			if (aCode.equalsIgnoreCase(item.getCode())) {
				return item;
			}
		}
		return null;
	}
	
	// Iterator methods

	/* (non-Javadoc)
	 * @see library.Traverser#first()
	 */
	@Override
	public void first() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see library.Traverser#next()
	 */
	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see library.Traverser#hasNext()
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see library.Traverser#getCurrent()
	 */
	@Override
	public Object getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

}
