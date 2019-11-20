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

public class TestBase2 {
	public static String baseUrl = "https://demo.nopcommerce.com/";
	// Threading offers multiple variables
	protected ThreadLocal<RemoteWebDriver> driver = null;
	
	
	@BeforeClass
	@Parameters(value = {"browser"})
	public void startDriver(@Optional("chrome") String browser) throws IOException {
		driver = new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), caps));
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
