package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.Loginpage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckOutTest extends TestBase {

	// Register user --> Search for product --> Add to cart --> Checkout --> Logout
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	CheckOutPage outObject;
	ShoppingCartPage cartObject;
	Loginpage loginObject;
	UserRegistrationPage registerObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1, alwaysRun = true)
	public void userRegitsersSuccessfully() throws InterruptedException {
		// This will replace the driver lint in HomePage with the driver from the
		// TestBase class which we need to start the tests
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration("Joe", "Jack", "ehhs7h@email.com", "1254789547");
		assertTrue(registerObject.registerComplete.isDisplayed());
	}

	@Test(priority = 2)
	public void userSearchesProduct() throws Exception {
		searchObject = new SearchProductPage(driver);
		Thread.sleep(1000);
		searchObject.productSearch(productName);
		Thread.sleep(1000);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.openProductDetailsPage();
		Thread.sleep(1000);
		//assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}

	@Test(priority = 3)
	public void UserAddsToCart() {
		cartObject = new ShoppingCartPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToCart();
		detailsObject.GoToShoppingCartPage();
	}

	@Test(priority = 4)
	public void UserCanCheckoutProduct() throws InterruptedException {
		outObject = new CheckOutPage(driver);
		cartObject = new ShoppingCartPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		orderObject = new OrderDetailsPage(driver);
		cartObject.GoToCheckOut();
		outObject.RegisteredUserChecksoutProduct("Egypt", "test address", "123456", "32445566677", "Cairo",
				productName);
		assertTrue(outObject.prodcutName.isDisplayed());
		Assert.assertTrue(outObject.prodcutName.getText().contains(productName));

		outObject.confirmOrder();
		Assert.assertTrue(outObject.ThankYoulbl.isDisplayed());
		outObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		// Print invoice as PDF or  print page
		orderObject.DownloadPDFInvoice();
		orderObject.PrindOrderDetails();
	}

	@Test(priority = 5)
	public void userLogout() {
		registerObject.userLogout();
	}

}
