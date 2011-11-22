/**
 * 
 */
package library;

import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author johnwarde
 *
 */
public class Form extends ConsoleComponent {
	private boolean isNewData;
	private ArrayList<FormField> fieldDefs = new ArrayList<FormField>();
	private String title;
	
	
	
	public Form(String formTitle, boolean isNewData ) {
		this.title = formTitle;
		this.isNewData = isNewData;
	}

	public void addField(String userInterfaceId, String prompt, String defaultValue) {
		fieldDefs.add(new FormFieldString(userInterfaceId, prompt, defaultValue));
		
	}
	
	public void addField(String userInterfaceId, String prompt, int defaultValue) {
		fieldDefs.add(new FormFieldInt(userInterfaceId, prompt, defaultValue));
		
	}
	
	public void addField(String userInterfaceId, String prompt, Date defaultValue) {
		fieldDefs.add(new FormFieldDate(userInterfaceId, prompt, defaultValue));
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
	    DateFormat df = new SimpleDateFormat(LibraryRepository.DATE_FORMAT);
	    Object defaultValue;
        String prompt;
		boolean isValidValue = false;
		for (FormField fieldDef : fieldDefs) {
			System.out.println();
	        String input = "";
	        defaultValue = fieldDef.getValue();
	        if (defaultValue instanceof Date) {
	        	defaultValue = df.format(fieldDef.getValue());
			}
	        while (!isValidValue) {
	        	try {
	        		if (isNewData) {
	        			prompt = String.format("%s : ", fieldDef.getLabel());
					} else {
//		        		System.out.println(String.format("%s : [%s]", fieldDef.getLabel(), fieldDef.getValue()));
		        		System.out.println(String.format("%s : [%s]", fieldDef.getLabel(), defaultValue));
						prompt = "Enter value : ";
					}
	            	input = console.readLine(prompt);
	            	input = input.trim();
	        		//System.out.println(String.format("input = [%s] (length = %d)", input, input.length()));	            	
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
