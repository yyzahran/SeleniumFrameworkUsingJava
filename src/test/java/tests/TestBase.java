package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String url = "https://demo.nopcommerce.com/";
	public static String downloadPath = "C:\\Users\\youss\\eclipse-workspace\\taf\\Downloads";

	public static ChromeOptions chromeoption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		chromePreferences.put("profile.default.content_settings.popups", 0);
		chromePreferences.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePreferences);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}

	// broswerName gets the value from the browser with the value preset in the
	// testng.xml file
	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(chromeoption());
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxOption());
		// Headless driver addition
		} else if (browserName.equalsIgnoreCase("headless")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir") + "\\resources\\phantomjs.exe");
			String[] phantomjsArgs = { "--web-security=no", "--ignore-ssl-errors=yes", "--webdriver-loglevel=NONE" };
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomjsArgs);
			driver = new PhantomJSDriver(caps);
		} else if (browserName.equalsIgnoreCase("chrome-headless")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
			ChromeOptions options =  new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// Take a screenshot upon failure after method and add it in the Screenshots
	// folder
	/*
	 * @AfterMethod public void screenshotOnFailure(ITestResult result) throws
	 * IOException { if (result.getStatus() == ITestResult.FAILURE) {
	 * System.out.println("Failed!... Taking screenshot");
	 * Helper.takeScreenshot(driver, result.getName()); } }
	 */

	@AfterSuite
	public void stopDriver() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
