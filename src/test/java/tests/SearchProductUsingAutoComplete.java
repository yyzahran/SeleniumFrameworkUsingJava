package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class SearchProductUsingAutoComplete extends TestBase {
	String productName = "Asus N551JK-XO076H Laptop";
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void serSelectsProductByAutocomplete() throws InterruptedException {
		searchObject = new SearchProductPage(driver);
		Thread.sleep(1000);
		searchObject.productSearchByAutoComplete("Asus");
		Thread.sleep(1000);
		detailsObject = new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
}
