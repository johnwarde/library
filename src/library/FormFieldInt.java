package library;

public class FormFieldInt extends FormField {
	protected int value;
	
	public FormFieldInt(String userInterfaceId, String prompt, int defaultValue) {
		super(userInterfaceId, prompt);
		value = defaultValue;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = (int) value;
	}

	/* (non-Javadoc)
	 * @see library.FormField#isValidValue(java.lang.Object)
	 */
	@Override
	public Object validateValue(Object input) {
		boolean isValidValue = true;
		int newValue = 0;
		try {
			newValue = Integer.parseInt((String) input);
		} catch (Exception e) {
			isValidValue = false;
		}
		if (!isValidValue) {
			return null;
		}
		return newValue;
	}
	
}
