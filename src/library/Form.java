/**
 * 
 */
package library;

import java.io.Console;
import java.util.ArrayList;

/**
 * @author johnwarde
 *
 */
public class Form {
	private ArrayList<FormField> fieldDefs = new ArrayList<FormField>();
//	private int fieldId = 0;
	private String title;
//	private Object[][] formDef;
	
	
	public Form(String formTitle) {
		title = formTitle;
		//formDef = formDefinition;
	}

	public void addField(String userInterfaceId, String prompt, String defaultValue) {
		fieldDefs.add(new FormFieldString(userInterfaceId, prompt, defaultValue));
		
	}
	
	public void addField(String userInterfaceId, String prompt, int defaultValue) {
		fieldDefs.add(new FormFieldInt(userInterfaceId, prompt, defaultValue));
		
	}

	public Object getFieldValue(String userInterfaceId) {
		for (FormField fieldDef : fieldDefs) {
			if (fieldDef.getUiId().equals(userInterfaceId)) {
				return fieldDef.getValue();
			}
		}
		return null;
	}			
	
	public boolean userFill() {
        Console console = System.console();
        assert console != null : "You need to run the program from the command line to get user input!!!";
        String header = String.format("\r\n\r\n\t%s\r\n\t%s\r\n\r\n" +
        		"Form Instructions: to keep current displayed value of a field, \r\n" +
        		"just press return, otherwise enter a new value\r\n",
        		title,
        		getUnderline(title.length())
        		);
        System.out.println(header);
		boolean isValidValue = false;
		for (FormField fieldDef : fieldDefs) {
			System.out.println();
	        String input = "";
	        
	        while (!isValidValue) {
	        	try {
	        		System.out.println(String.format("%s : [%s]", fieldDef.getLabel(), fieldDef.getValue()));
	            	input = console.readLine("Enter value: ");
	            	input = input.trim();
	        		System.out.println(String.format("input = [%s] (length = %d)", input, input.length()));	            	
	            	if (0 == input.length()) {
						break;
					}
	            	Object newValue = fieldDef.validateValue(input);
	            	if (null != newValue) {
						fieldDef.setValue(newValue);
						break;
					}	            	
				} catch (Exception e) {
					// Just ask for another input
				}	
	        }
		}			
		return true;
	}

	
	private String getUnderline(int times) {
		   StringBuilder underline = new StringBuilder();
		   for(int i = 0;i < times;i++) {
			   underline.append("-");		
		   }
		   return underline.toString();
	}



	
}
