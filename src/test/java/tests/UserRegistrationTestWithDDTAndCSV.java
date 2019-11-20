package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;
	CSVReader reader;

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException, CsvException, IOException {
		String CSVfile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\User Data.csv";
		reader = new CSVReader(new FileReader(CSVfile));

		String[] csvCell;
		// Execute a while loop till the last value in the CSV file
		while ((csvCell = reader.readNext()) != null) {
			String fName = csvCell[0];
			String lName = csvCell[1];
			String regEmail = csvCell[2];
			String password = csvCell[3];

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

}
