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
//	static Catalog itemsByCategory(Catalog items, Class<? extends LibraryItem> category) {
//	static Catalog itemsByCategory(Catalog items, Class<LibraryItem> category) {
//	static Catalog itemsByCategory(Catalog items, Class category) {
	/**
	 * @param items
	 * @param category
	 * @return
	 */
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
	
	/**
	 * @param items
	 * @return
	 */
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

	/**
	 * @param items
	 * @param loanItemIds
	 * @return
	 */
	public static Catalog itemsByList(Catalog items, String[] loanItemIds) {
		Catalog newItems = new Catalog();
		items.first();
		LibraryItem item;
		String itemCode;
		while (items.hasNext()) {
			item = items.getCurrent();
			itemCode = item.getCode();
			for (String code : loanItemIds) {
				if (code.equals(itemCode)) {
					newItems.add(item);
				}				
			}

			items.next();
		}
		return newItems;
	}
	
}
