package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;


public class UserRegistrationParallelTest extends TestBase2 {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;
	Faker fakeData = new Faker();
	String fName = fakeData.name().firstName();
	String lName = fakeData.name().lastName();
	String regEmail = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException {
		homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(getDriver());
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
		loginObject = new Loginpage(getDriver());
		Thread.sleep(2000);
		loginObject.userLogin(regEmail, password);
		assertTrue(registerObject.logoutLink.isDisplayed());
	}

}
