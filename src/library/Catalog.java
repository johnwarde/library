/**
 * 
 */


package library;

import java.util.ArrayList; 

/**
 * @author johnwarde
 *
 */
//public class Catalog {
public class Catalog implements Traverser {
	private ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();
	private int currentIndex = 0;
	
	public Catalog() {
		super();
	}

	public LibraryItem getIndex(int entryNo) {
		return items.get(entryNo);
	}
	
	public int size() {
		return items.size();
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
		currentIndex = 0;
	}

	/* (non-Javadoc)
	 * @see library.Traverser#next()
	 */
	@Override
	public void next() {
		// TODO Auto-generated method stub
		currentIndex++;
	}

	/* (non-Javadoc)
	 * @see library.Traverser#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (currentIndex < items.size()) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see library.Traverser#getCurrent()
	 */
	@Override
	public LibraryItem getCurrent() {
		return (LibraryItem) items.get(currentIndex);
	}


}
