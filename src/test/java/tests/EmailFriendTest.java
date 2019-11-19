package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.Loginpage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	String productName = "Asus N551JK-XO076H Laptop";
	// User Registration --> Search for product --> email a friend

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException {
		// This will replace the driver lint in HomePage with the driver from the
		// TestBase class which we need to start the tests
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration("Joe", "Jack", "t7@email.com", "1254789547");
		assertTrue(registerObject.registerComplete.isDisplayed());
	}

	@Test(priority = 2)
	public void userSelectsProductByAutocomplete() throws InterruptedException {
		searchObject = new SearchProductPage(driver);
		Thread.sleep(1000);
		searchObject.productSearchByAutoComplete("Asus");
		Thread.sleep(1000);
		detailsObject = new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}

	@Test(priority = 3)
	public void RegisteredUserSendsProductToFriend() {
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("ass@email.com", "Saba7o0o0o0o");
		Assert.assertEquals(emailObject.successMsg.getText(), "Your message has been sent.");
	}
	
	@Test(priority = 4)
	public void userLogout() {
		registerObject.userLogout();
	}
}
