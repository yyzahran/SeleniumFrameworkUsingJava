package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	public WebElement fEmailBox;
	@FindBy(id = "YourEmailAddress")
	public WebElement myEmailBox;
	@FindBy(id = "PersonalMessage")
	public WebElement myMsgBox;
	@FindBy(xpath = "//input[@name='send-email']")
	WebElement sendEmailBtn;
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	
	public void sendEmailToFriend(String fEmail, String myMsg) {
		setText(fEmailBox, fEmail);
		setText(myMsgBox, myMsg);
		clickBtn(sendEmailBtn);
		
	}
}
