package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExcel extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;

	@DataProvider(name = "Excel data")
	public Object[][] userExcelData() throws IOException {
		// Get data from the excel reader class
		ExcelReader er = new ExcelReader();
			return er.getExcelData();
		
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "Excel data")
	public void userRegitsersSuccessfully(String fName, String lName, String regEmail, String password) throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegisteration(fName, lName, regEmail, password);
		assertTrue(registerObject.registerComplete.isDisplayed());
		Thread.sleep(1000);
		registerObject.userLogout();
		Thread.sleep(1000);
		homeObject.openLoginpage();
		Thread.sleep(1000);
		loginObject = new Loginpage(driver);
		Thread.sleep(1000);
		loginObject.userLogin(regEmail, password);
		assertTrue(registerObject.logoutLink.isDisplayed());
		Thread.sleep(1000);
		registerObject.userLogout();
	}
}
