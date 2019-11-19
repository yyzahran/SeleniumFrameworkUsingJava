package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchProductPage;
import pages.ShoppingCartPage;

public class AddProductToShppoingCartTest extends TestBase{
	ShoppingCartPage cartObject;
	ProductDetailsPage detailsObject;
	SearchProductPage searchObject;
	String productName = "Asus N551JK-XO076H Laptop";
	
	@Test(priority = 1)
	public void UserSearchesProduct() throws Exception {
		searchObject = new SearchProductPage(driver);
		searchObject.productSearch(productName);
		Thread.sleep(1000);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.openProductDetailsPage();
		Thread.sleep(1000);
		assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
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
	public void UserRemovesFromCart() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(1000);
		cartObject.UpdateProductQuantityInCart("2");
		Thread.sleep(1000);
		cartObject.ClearCart();
		Thread.sleep(1000);
		assertTrue(cartObject.clearCartMsg.isDisplayed());
	}
}
