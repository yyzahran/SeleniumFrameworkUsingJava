package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement nameBox;
	@FindBy(id = "Email")
	WebElement emailBox;
	@FindBy(id = "Enquiry")
	WebElement enquiryBox;
	@FindBy(xpath = "//input[@name='send-email']")
	WebElement SubmitBtn;
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void contactUs(String fullName, String email, String enquiry) throws InterruptedException {
		setText(nameBox, fullName);
		Thread.sleep(1000);
		setText(emailBox, email);
		Thread.sleep(1000);
		setText(enquiryBox, enquiry);
		Thread.sleep(1000);
		clickBtn(SubmitBtn);
	}
}
