package qa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public String readProperties(String value) {
		
		Properties prop = new Properties();
		try {
			
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		prop.load(fis);
		}
		
		catch (IOException e) {
			String message = e.getMessage();
			
			System.out.println(message);
		}
		
		String valuefromprop = prop.getProperty(value);
		
		return valuefromprop;
	}
}
