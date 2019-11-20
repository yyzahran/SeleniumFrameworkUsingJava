package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		// Super means that it is inherited from another class
		super(driver);
	}
	
	@FindBy(id = "gender-male")
	WebElement genderSelect;
	@FindBy(id = "FirstName")
	WebElement fnBox;
	@FindBy(id = "LastName")
	WebElement lnBox;
	@FindBy(id = "Email")
	WebElement emailBox;
	@FindBy(id = "Password")
	WebElement passwordBox;
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordBox;
	@FindBy(id = "register-button")
	WebElement registerBtn;
	@FindBy(xpath = "//div[@class='result']")
	public WebElement registerComplete;
	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;
	
	
	// It is public so I can see it in another classes
	public void userRegisteration(String firstName, String lastName, String email, String password) throws InterruptedException {
		clickBtn(genderSelect);
		Thread.sleep(1000);
		setText(fnBox, firstName);
		Thread.sleep(1000);
		setText(lnBox, lastName);
		setText(emailBox, email);
		Thread.sleep(1000);
		setText(passwordBox, password);
		setText(ConfirmPasswordBox, password);
		Thread.sleep(1000);
		clickBtn(registerBtn);
	}
	
	public void userLogout() {
		clickBtn(logoutLink);
	}

}
