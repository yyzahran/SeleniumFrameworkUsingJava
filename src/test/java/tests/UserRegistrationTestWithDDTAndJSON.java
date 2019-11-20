package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JSONReader;
import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		JSONReader jsonReader = new JSONReader();
		jsonReader.JsonReader();
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegisteration(jsonReader.fName, jsonReader.lName, jsonReader.regEmail, jsonReader.password);
		assertTrue(registerObject.registerComplete.isDisplayed());
		Thread.sleep(1000);
		registerObject.userLogout();
		Thread.sleep(1000);
		homeObject.openLoginpage();
		Thread.sleep(1000);
		loginObject = new Loginpage(driver);
		Thread.sleep(1000);
		loginObject.userLogin(jsonReader.regEmail, jsonReader.password);
		assertTrue(registerObject.logoutLink.isDisplayed());
		Thread.sleep(1000);
		registerObject.userLogout();
	}
}