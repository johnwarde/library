/**
 * 
 */
package library;

import java.util.ArrayList;

/**
 * @author johnwarde
 *
 */
public class Members implements Traverser {
	private ArrayList<User> users = new ArrayList<User>();
	private int currentIndex = 0;

	public Members() {
		super();
	}
	
	public User getIndex(int entryNo) {
		return users.get(entryNo);
	}
	
	public int size() {
		return users.size();
	}	
	
	protected boolean add(User toAdd) {
		// TODO: validate: does it already exist
		users.add(toAdd);
		return true;
	}
	
	protected boolean remove(User toDelete) {
		users.remove(toDelete);	
		return true;
	}
	
	
	protected User find(int libraryId) {
		for (User user : users) {
			if (libraryId == user.getLibraryId()) {
				return user;
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
		if (currentIndex < users.size()) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see library.Traverser#getCurrent()
	 */
	@Override
	public User getCurrent() {
		return users.get(currentIndex);
	}

}
