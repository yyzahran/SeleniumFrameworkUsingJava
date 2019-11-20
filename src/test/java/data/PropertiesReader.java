package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	// Reads and loads the "userdatsa.properties" file
	public static Properties userData = loadProperties("C:\\Users\\youss\\eclipse-workspace\\taf\\src\\main\\java\\properties\\userdata.properties");

	// Loading Sauce Labs data
	public static Properties sauceLabsData = loadProperties("C:\\Users\\youss\\eclipse-workspace\\taf\\"
			+ "src\\main\\java\\properties\\SauceLabsUser.properties");
	
	public static Properties loadProperties(String path) {
		Properties pro = new Properties();
		// Stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
		return pro;
	}
}
