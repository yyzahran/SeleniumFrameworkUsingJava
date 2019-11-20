package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;
	
	@DataProvider(name = "Test Data")
	public static Object[][] UserData() {
		return new Object [] [] { {"Youssef", "Zahran", "tests135xxx@email.com", "1234567"}, 
			{"Thom", "Yorke", "tesstt134xxx@email.com", "1234568"} };
	}

	@Test(dataProvider = "Test Data")
	public void userRegitsersSuccessfully(String fName, String lName, String regEmail, String password) throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegisteration(fName, lName, regEmail, password);
		assertTrue(registerObject.registerComplete.isDisplayed());
		registerObject.userLogout();
		Thread.sleep(1000);
		homeObject.openLoginpage();
		Thread.sleep(1000);
		loginObject = new Loginpage(driver);
		loginObject.userLogin(regEmail, password);
		assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.userLogout();
	}
}
