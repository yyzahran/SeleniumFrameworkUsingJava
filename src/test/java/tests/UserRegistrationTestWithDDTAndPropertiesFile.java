package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import data.PropertiesReader;
import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndPropertiesFile extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;
	String fName = PropertiesReader.userData.getProperty("firstname");
	String lName = PropertiesReader.userData.getProperty("lastname");
	String regEmail = PropertiesReader.userData.getProperty("email");
	String password = PropertiesReader.userData.getProperty("password");

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fName, lName, regEmail, password);
		assertTrue(registerObject.registerComplete.isDisplayed());
	}
	
	@Test(dependsOnMethods = "userRegitsersSuccessfully")
	public void userLogout() throws InterruptedException {
		Thread.sleep(2000);
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = "userLogout")
	public void userLogin() throws InterruptedException {
		Thread.sleep(2000);
		homeObject.openLoginpage();
		loginObject = new Loginpage(driver);
		Thread.sleep(2000);
		loginObject.userLogin(regEmail, password);
		assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
