package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='removefromcart']")
	WebElement removeBox;
	@FindBy(xpath = "//input[@name='updatecart']")
	WebElement updateWishListBtn;
	@FindBy(xpath = "//div[@class='no-data']")
	public WebElement updatedWishListMsg;
	
	public void RemoveItem() {
		clickBtn(removeBox);
		clickBtn(updateWishListBtn);
	}

}
