package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends PageBase {

	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchBox;
	@FindBy(xpath = "//input[@class='button-1 search-box-button']")
	WebElement searchBtn;
	@FindBy(id = "ui-id-1")
	List <WebElement> productListAutocomplete;
	@FindBy(xpath = " //div[@class='picture']//a//img")
	WebElement productTitle;
	
	public void productSearch(String productName) throws Exception {
		setText(searchBox, productName);
		Thread.sleep(1000);
		clickBtn(searchBtn);
	}
	
	public void openProductDetailsPage() {
		clickBtn(productTitle);
	}
	
	public void productSearchByAutoComplete(String searchText) throws InterruptedException {
		setText(searchBox, searchText);
		Thread.sleep(1000);
		productListAutocomplete.get(0).click();
	}
}
