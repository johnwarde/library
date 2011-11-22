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
	
	/**
	 * @param entryNo
	 * @return
	 */
	public User getIndex(int entryNo) {
		return users.get(entryNo);
	}
	
	/**
	 * @return
	 */
	public int size() {
		return users.size();
	}	
	
	/**
	 * @param toAdd
	 * @return
	 */
	protected boolean add(User toAdd) {
		users.add(toAdd);
		return true;
	}
	
	/**
	 * @param toDelete
	 * @return
	 */
	protected boolean remove(User toDelete) {
		users.remove(toDelete);	
		return true;
	}
	
	
	/**
	 * @param libraryId
	 * @return
	 */
	protected User find(int libraryId) {
		for (User user : users) {
			if (libraryId == user.getLibraryId()) {
				return user;
			}
		}
		return null;
	}	
	
	/**
	 * @param name
	 * @return
	 */
	public User find(String name) {
		for (User user : users) {
			if (name.equals(user.getName())) {
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
