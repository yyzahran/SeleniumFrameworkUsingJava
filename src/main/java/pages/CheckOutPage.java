package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	private WebElement guestBtn;
	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement fnTxt;
	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lnTxt;
	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;
	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryList;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneTxt;
	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTxt;
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement addressTxt;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement postCodeTxt;
	@FindBy(xpath = "//*[@id=\'billing-buttons-container\']/input")
	private WebElement continueBtn;
	@FindBy(id = "shippingoption_1")
	private WebElement shippingMethodRdo;
	@FindBy(xpath = "//*[@id=\'shipping-method-buttons-container\']/input")
	private WebElement continueShippingBtn;
	@FindBy(xpath = "//*[@id=\'payment-method-buttons-container\']/input")
	private WebElement continuePaymentBtn;
	@FindBy(xpath = "//*[@id=\'payment-info-buttons-container\']/input")
	private WebElement continueInfoBtn;
	@FindBy(css = "a.product-name")
	public WebElement prodcutName;
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	private WebElement confirmBtn;
	@FindBy(css = "h1")
	public WebElement ThankYoulbl;
	@FindBy(css = "div.title")
	private WebElement orderCompleteMsg;
	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;

	public void RegisteredUserChecksoutProduct(String countryName, String address, String postcode, String phone, 
			String city, String productName) throws InterruptedException {
		sel = new Select(countryList);
		sel.selectByVisibleText(countryName);
		setText(cityTxt, city);
		setText(addressTxt, address);
		setText(postCodeTxt, postcode);
		setText(phoneTxt, phone);
		clickBtn(continueBtn);
		clickBtn(shippingMethodRdo);
		clickBtn(continueShippingBtn);
		// Wait for the acordeon panel
		Thread.sleep(1000);
		clickBtn(continuePaymentBtn);
		Thread.sleep(1000);
		clickBtn(continueInfoBtn);
	}

	public void confirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		clickBtn(confirmBtn);
		Thread.sleep(1000);
	}

	public void viewOrderDetails() {
		clickBtn(orderDetailsLink);
	}

	public void CheckoutProduct(String firstName, String lastName, String countryName, String email, String address,
			String postcode, String phone, String city, String productName) throws InterruptedException {
		setText(fnTxt, firstName);
		setText(lnTxt, lastName);
		setText(emailTxt, email);
		sel = new Select(countryList);
		sel.selectByVisibleText(countryName);
		setText(cityTxt, city);
		setText(addressTxt, address);
		setText(postCodeTxt, postcode);
		setText(phoneTxt, phone);
		clickBtn(continueBtn);
		clickBtn(shippingMethodRdo);
		clickBtn(continueShippingBtn);
		Thread.sleep(2000);
		clickBtn(continuePaymentBtn);
		Thread.sleep(2000);
		clickBtn(continueInfoBtn);
	}
}
