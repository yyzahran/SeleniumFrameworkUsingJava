package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class JSONReader {
	public String fName, lName, regEmail, password;
	
	public void JsonReader() throws FileNotFoundException, IOException, ParseException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\User Data.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
		
		for (Object jsonObject : jArray) {
			JSONObject person = (JSONObject) jsonObject;
			fName = (String) person.get("firstname");
			System.out.println("The first name is: " + fName);
			lName = (String) person.get("lastname");
			System.out.println("The last name is: " + lName);
			regEmail = (String) person.get("email");
			System.out.println("The registration email is: " + regEmail);
			password = (String) person.get("password");
			System.out.println("The password is: " + fName);
		}
		
	}

}
