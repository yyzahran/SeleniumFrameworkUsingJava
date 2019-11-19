package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class AddToCompareTest extends TestBase{
	// Search for first product --> Search for second product --> Add to compare --> clear list
	String productName1 = "asus";
	String productName2 = "mac";
	ProductDetailsPage detailsObject;
	CompareProductsPage compareObject;
	HomePage homeObject;
	SearchProductPage searchObject;
	
	@Test(priority = 1)
	public void UserComapresProducts() throws Exception {
		compareObject = new CompareProductsPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject = new SearchProductPage(driver);
		
		searchObject.productSearch(productName1);
		Thread.sleep(1000);
		searchObject.openProductDetailsPage();
		Thread.sleep(1000);
		detailsObject.AddToCompare();
		Thread.sleep(1000);
		
		driver.navigate().back();
		driver.navigate().back();
		
		searchObject.productSearch(productName2);
		Thread.sleep(2000);
		searchObject.openProductDetailsPage();
		Thread.sleep(1000);
		detailsObject.AddToCompare();
		Thread.sleep(2000);
		detailsObject.GoToComparePage();
		Thread.sleep(2000);
		assertTrue(compareObject.asusProduct.isDisplayed());
		assertTrue(compareObject.macProduct.isDisplayed());
	
		compareObject.CompareProducts();
	}
	
	@Test(priority = 2)
	public void UserClearsTable() {
		compareObject.ClearTable();
		assertTrue(compareObject.noDataLbl.isDisplayed());
	}
}
