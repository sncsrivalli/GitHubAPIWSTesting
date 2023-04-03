package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	private Properties property;
	public void propertiesInitialization(String filePath) {
		property = new Properties();
		try {
			property.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String fetchParameter(String key) {
		return property.getProperty(key);
	}
}
