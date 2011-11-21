/**
 * 
 */
package library;

/**
 * @author johnwarde
 *
 */
abstract public class FormField {
	protected String uiId;
	protected String label;
	
	public FormField(String userInterfaceId, String fieldLabel) {
		uiId = userInterfaceId;
		label = fieldLabel;
	}

	/**
	 * @return the uiId
	 */
	public String getUiId() {
		return uiId;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	

	/**
	 * @return
	 */
	abstract public Object getValue();

	/**
	 * @return
	 */
	abstract public void setValue(Object input);

	/**
	 * @return
	 */
	abstract public Object validateValue(String input);
	
}
