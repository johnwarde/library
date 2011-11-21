/**
 * 
 */
package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author johnwarde
 *
 */
public class FormFieldDate extends FormField {
	protected Date value;

	public FormFieldDate(String userInterfaceId, String fieldLabel, Date defaultValue) {
		super(userInterfaceId, fieldLabel);
		value = defaultValue;
	}

	/* (non-Javadoc)
	 * @see library.FormField#getValue()
	 */
	@Override
	public Date getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see library.FormField#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object input) {
		this.value = (Date) value;
	}

	/* (non-Javadoc)
	 * @see library.FormField#validateValue(java.lang.Object)
	 */
	@Override
	public Object validateValue(String input) {
		boolean isValidValue = true;
		Date newValue = null;
	    DateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
		try {
			//newValue = DateFormat.getDateInstance(DateFormat.DEFAULT).parse(input);
		    newValue = df.parse(input);			
		} catch (Exception e) {
			isValidValue = false;
			//e.printStackTrace();
		}
		if (!isValidValue) {
			return null;
		}
		return newValue;
	}

}
