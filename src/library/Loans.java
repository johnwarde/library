/**
 * 
 */
package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author johnwarde
 *
 */
public class Loans {
	private HashMap<String, Integer> entries = new HashMap<String, Integer>();
	
	
	/**
	 * @param libCode
	 * @param userId
	 * @return
	 */
	public boolean add(String libCode, int userId) {
		if (entries.containsKey(libCode)) {
			return false;
		}
		entries.put(libCode, new Integer(userId));
		return true;
	}
	
	/**
	 * @param libCode
	 * @return
	 */
	public boolean isItemOnLoan(String libCode) {
		return entries.containsKey(libCode);
	}
	
	/**
	 * @param libCode
	 * @return
	 */
	public boolean removeItem(String libCode) {
		if (entries.containsKey(libCode)) {
			entries.remove(libCode);
			return true;
		}
		return false;
	}
	
	/**
	 * @param userId
	 * @return
	 */
	public String[] getLoanItemsForUser(int userId) {
        Iterator<String> iterator = entries.keySet().iterator();
        ArrayList<String> results = new ArrayList<String>();
        int searchId;
        String searchCode;
        while(iterator.hasNext()){        
            searchCode = iterator.next();
            searchId = entries.get(searchCode);
            if (userId == searchId) {
				results.add(searchCode);
			}
        }
        return results.toArray(new String[results.size()]) ;
	}

	/**
	 * @param libCode
	 * @return
	 */
	public int getUserIdForLoanItem(String libCode) {
		return entries.get(libCode);
	}
}
