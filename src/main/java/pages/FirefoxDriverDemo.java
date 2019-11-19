package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverDemo {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\youss\\eclipse-workspace\\taf\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com/");
		

	}

}
