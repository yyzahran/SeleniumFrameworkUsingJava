package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	@FindBy(xpath = "//input[@class='button-2 email-a-friend-button']")
	public WebElement emailFriendBtn;
	@FindBy(xpath = "//a[contains(text(),'Add your review')]")
	public WebElement addReviewLink;
	@FindBy(id = "add-to-wishlist-button-5")
	public WebElement addToWishListBtn;
	@FindBy(xpath = "//a[contains(text(),'wishlist')]")
	public WebElement wishListLink;
	@FindBy(xpath = "//div[@class='compare-products']//input[@class='button-2 add-to-compare-list-button']")
	WebElement addToCompareBtn;
	@FindBy(xpath = "//a[contains(text(),'product comparison')]")
	public WebElement addToCompareLink;
	@FindBy(id = "add-to-cart-button-5")
	WebElement addToCartBtn;
	@FindBy(xpath = "//a[contains(text(),'shopping cart')]")
	public WebElement shoppingCartLink;

	
	public void openSendEmail() {
		clickBtn(emailFriendBtn);
	}
	
	public void openReviewPage() {
		clickBtn(addReviewLink);
	}
	
	public void wishListPage() {
		clickBtn(addToWishListBtn);
		clickBtn(wishListLink);
	}
	
	public void AddToCompare() {
		clickBtn(addToCompareBtn);
	}
	
	public void GoToComparePage() {
		clickBtn(addToCompareLink);
	}
	
	public void AddProductToCart() {
		clickBtn(addToCartBtn);
	}
	
	public void GoToShoppingCartPage() {
		clickBtn(shoppingCartLink);
	}
	
}
