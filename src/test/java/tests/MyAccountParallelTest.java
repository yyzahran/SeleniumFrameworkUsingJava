package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountParallelTest extends TestBase2 {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myAccountObject;
	Loginpage loginObject;
	String fName = "Joe";
	String lName = "Jack";
	String email = "test331113@email.com";
	String oldPassword = "1254789547";
	String newPassword = "123456789";
	
	@Test(alwaysRun = true, priority = 1)
	public void userRegitsersSuccessfully() throws InterruptedException {
		homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(getDriver());
		registerObject.userRegisteration(fName, lName, email, oldPassword);
		assertTrue(registerObject.registerComplete.isDisplayed());
	}
	
	@Test(priority = 2)
	public void userCanChangePassword() {
		myAccountObject = new MyAccountPage(getDriver());
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
		loginObject = new Loginpage(getDriver());
		loginObject.userLogin(email, newPassword);
		assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
