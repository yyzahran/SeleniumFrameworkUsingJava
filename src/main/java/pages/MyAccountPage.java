package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[@class='ico-account']")
	public WebElement myAccountLink;
	@FindBy(xpath = "//a[contains(text(),'Change password')]")
	WebElement changePW;
	@FindBy(id = "OldPassword")
	WebElement oldPWBox;
	@FindBy(id = "NewPassword")
	WebElement newPWBox;
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPWBox;
	@FindBy(xpath = "//input[@class='button-1 change-password-button']")
	WebElement changePWBtn;
	@FindBy(css = "div.result")
	public WebElement confirmLbl;
	
	public void openMyAccountTab() {
		clickBtn(myAccountLink);
	}
	
	public void openChangePWtab() {
		clickBtn(changePW);
	}
	
	public void changePassword (String OldPassword, String NewPassword) {
		setText(oldPWBox, OldPassword);
		setText(newPWBox, NewPassword);
		setText(confirmNewPWBox, NewPassword);
		clickBtn(changePWBtn);
		
	}
	
}
