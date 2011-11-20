/**
 * 
 */
package library;

import library.LibraryItem;

/**
 * @author johnwarde
 *
 */
public abstract class CatalogViewer {
//	static Catalog itemsByCategory(Catalog items, Class<LibraryItem> category) {
	static Catalog itemsByCategory(Catalog items, LibraryItem category) {
		Catalog newItems = new Catalog();
		items.first();
		LibraryItem item;
		while (items.hasNext()) {
			item = items.getCurrent();
//			if (item.getClass() == category) {
			if (item.getClass() == category.getClass()) {
				newItems.add(item);
			}
			items.next();
		}
		return newItems;
	}
	
	static Catalog itemsAvailable(Catalog items) {
		Catalog newItems = new Catalog();
		items.first();
		LibraryItem item;
		while (items.hasNext()) {
			item = items.getCurrent();
			if (!item.isOnLoan()) {
				newItems.add(item);
			}
			items.next();
		}
		return newItems;
	}
	
}
