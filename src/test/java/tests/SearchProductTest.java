package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class SearchProductTest extends TestBase {
	String productName = "Asus N551JK-XO076H Laptop";
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;

	@Test
	public void userSearchesProduct() throws Exception {
		searchObject = new SearchProductPage(driver);
		searchObject.productSearch(productName);
		Thread.sleep(1000);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.openProductDetailsPage();
		Thread.sleep(1000);
		assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
}
