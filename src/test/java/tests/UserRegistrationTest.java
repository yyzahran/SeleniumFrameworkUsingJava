package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException {
		// This will replace the driver lint in HomePage with the driver from the TestBase class which we need to start the tests
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration("Joe", "Jack", "test65@email.com", "1254789547");
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
		loginObject.userLogin("test4@email.com", "1254789547");
		assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
