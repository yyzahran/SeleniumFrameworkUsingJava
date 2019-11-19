package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) throws Exception {
		String chromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
		System.out.println(System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromePath );
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.utest.com/");
		Thread.sleep(3000);
		driver.quit();

	}

}
