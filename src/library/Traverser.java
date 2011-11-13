/**
 * 
 */
package library;

/**
 * @author johnwarde
 *
 */
public interface Traverser {
	public void first();
	public void next();
	public boolean hasNext();
	public Object getCurrent();
}
