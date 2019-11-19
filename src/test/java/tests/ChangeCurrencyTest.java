package tests;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import pages.HomePage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeObject;
	
	@Test
	public void UserChangesCurrency () throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
		Thread.sleep(3000);
		assertFalse(homeObject.productPriceLbl.isDisplayed());
	}

}
