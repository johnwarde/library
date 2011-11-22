/**
 * 
 */
package library;

/**
 * @author johnwarde
 *
 */
public interface OutputStrategy {
	/**
	 * For display in a list
	 * @return
	 */
	public String toConsoleLine();
	/**
	 * For displaying all details
	 * @return
	 */
	public String toConsoleFull();
}
