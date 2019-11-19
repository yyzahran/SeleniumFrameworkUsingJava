package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "removefromcart")
	WebElement removeCheckBox;
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	@FindBy(xpath = "//div[@class='no-data']")
	public WebElement clearCartMsg;
	@FindBy(css = "input.qty-input")
	WebElement quantityBox;
	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;
	@FindBy(id = "checkout")
	WebElement checkOutLink;
	@FindBy(xpath = "//input[@class='button-1 checkout-as-guest-button']")
	WebElement guestCheckoutLink;

	public void UpdateProductQuantityInCart(String quan) {
		ClearText(quantityBox);
		setText(quantityBox, quan);
		clickBtn(updateCartBtn);
	}
	
	public void ClearCart() {
		clickBtn(removeCheckBox);
		clickBtn(updateCartBtn);
	}
	
	public void GoToCheckOut() {
		clickBtn(agreeCheckBox);
		clickBtn(checkOutLink);
	}
	
	public void GuestGoToCheckOut() {
		clickBtn(guestCheckoutLink);
	}
}
