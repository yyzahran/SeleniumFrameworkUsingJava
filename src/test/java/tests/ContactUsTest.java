package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	HomePage homeObject;
	ContactUsPage contactUsObject;
	String fullName = "Joe Jack";
	String email = "test@email.com";
	String enquiry = "I am IRON MAN - Ozzy Osbourne";
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Contact us test case")
	@Link(name = "JIRA ticket", url = "http://google.com")
	@Epic("EP-120")
	@Flaky
	public void userOpensContactUs() throws InterruptedException {
		homeObject = new HomePage(driver);
		contactUsObject = new ContactUsPage(driver);
		homeObject.openContactUsPage();
		Thread.sleep(1000);
		contactUsObject.contactUs(fullName, email, enquiry);
		assertTrue(contactUsObject.successMsg.isDisplayed());
	}
	
	
}
