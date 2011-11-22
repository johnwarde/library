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
	private ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();
	private int currentIndex = 0;
	
	public Catalog() {
		super();
	}


	/**
	 * @param entryNo
	 * @return
	 */
	public LibraryItem getIndex(int entryNo) {
		return items.get(entryNo);
	}
	
	/**
	 * @return
	 */
	public int size() {
		return items.size();
	}	
	
	/**
	 * @param toAdd
	 * @return
	 */
	public boolean add(LibraryItem toAdd) {
		if (null != find(toAdd.getCode())) {
			// We found an existing library code, error
			return false;
		}
		items.add(toAdd);
		return true;
	}
	
	/**
	 * @param toDelete
	 * @return
	 */
	public boolean remove(LibraryItem toDelete) {
		items.remove(toDelete);	
		return true;
	}
	
	/**
	 * @param aCode
	 * @return
	 */
	public LibraryItem find(String aCode) {
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
