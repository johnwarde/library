package library;

public class FormFieldString extends FormField {
	protected String value;
	
	public FormFieldString(String userInterfaceId, String prompt, String defaultValue) {
		super(userInterfaceId, prompt);
		value = defaultValue;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = (String) value;
	}

	/* (non-Javadoc)
	 * @see library.FormField#isValidValue(java.lang.Object)
	 */
	@Override
	public Object validateValue(Object input) {
		// String are always valid unless we start to 
		// put a limit on the length of fields
		return input;
	}

}
