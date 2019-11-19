package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myAccountObject;
	Loginpage loginObject;
	String fName = "Joe";
	String lName = "Jack";
	String email = "test113@email.com";
	String oldPassword = "1254789547";
	String newPassword = "123456789";
	
	@Test(alwaysRun = true, priority = 1)
	public void userRegitsersSuccessfully() throws InterruptedException {
		// This will replace the driver lint in HomePage with the driver from the
		// TestBase class which we need to start the tests
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fName, lName, email, oldPassword);
		assertTrue(registerObject.registerComplete.isDisplayed());
	}
	
	@Test(priority = 2)
	public void userCanChangePassword() {
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openMyAccountTab();
		myAccountObject.openChangePWtab();
		myAccountObject.changePassword(oldPassword, newPassword);
		
		assertTrue(myAccountObject.confirmLbl.isDisplayed());
	}
	
	@Test(priority = 3)
	public void userLogout() throws InterruptedException {
		registerObject.userLogout();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void userLogin() {
		homeObject.openLoginpage();
		loginObject = new Loginpage(driver);
		loginObject.userLogin(email, newPassword);
		assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
