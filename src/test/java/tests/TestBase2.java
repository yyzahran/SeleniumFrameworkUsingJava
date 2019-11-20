package tests;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.PropertiesReader;

public class TestBase2 {
	public static String baseUrl = "https://demo.nopcommerce.com/";
	// Threading offers multiple variables
	protected ThreadLocal<RemoteWebDriver> driver = null;
	//Sauce Labs configuration
	public static final String USERNAME = PropertiesReader.sauceLabsData.getProperty("username");
	public static final String ACCESS_KEY = PropertiesReader.sauceLabsData.getProperty("accesskey");
	public static final String url = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	
	@BeforeClass
	@Parameters(value = {"browser"})
	public void startDriver(@Optional("chrome") String browser) throws IOException {
		driver = new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		//caps.setCapability("username", USERNAME);
        //caps.setCapability("accessKey", ACCESS_KEY);
		// Selenium grid local host
		//driver.set(new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), caps));
		// Sauce labs cloud testing
		driver.set(new RemoteWebDriver(new URL (url), caps));
		
		getDriver().get(baseUrl);
	}
	
	public WebDriver getDriver() {
		
		return driver.get();
	}
	
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		// Removing threads
		driver.remove();
	}
	
}
