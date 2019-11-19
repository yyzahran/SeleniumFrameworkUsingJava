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

public class GuestCheckOutTest extends TestBase {

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



	@Test(priority = 1)
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

	@Test(priority = 2)
	public void UserAddsToCart() {
		cartObject = new ShoppingCartPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToCart();
		detailsObject.GoToShoppingCartPage();
	}

	@Test(priority = 3)
	public void UserCanCheckoutProduct() throws InterruptedException {
		outObject = new CheckOutPage(driver);
		cartObject = new ShoppingCartPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		orderObject = new OrderDetailsPage(driver);
		cartObject.GoToCheckOut();
		Thread.sleep(1000);
		cartObject.GuestGoToCheckOut();
		outObject.CheckoutProduct("Joe", "Jack", "Egypt", "7ooda@email.com", "le2bal", "12345", "5487459655", "Edmonton", productName);
		assertTrue(outObject.prodcutName.isDisplayed());
		Assert.assertTrue(outObject.prodcutName.getText().contains(productName));

	}
	
	@Test(priority = 4)
	public void UserViewsOrderDetails() throws InterruptedException {
		orderObject = new OrderDetailsPage(driver);
		outObject.confirmOrder();
		Assert.assertTrue(outObject.ThankYoulbl.isDisplayed());
		outObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		// Print invoice as PDF or  print page
		orderObject.DownloadPDFInvoice();
		orderObject.PrindOrderDetails();
	}
}
