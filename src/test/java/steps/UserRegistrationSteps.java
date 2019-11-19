package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistrationSteps extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;

	@Given("the user on the homepage")
	public void the_user_on_the_homepage() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
	}

	@When("User clicks on registerlink")
	public void user_clicks_on_registerlink() {
		assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("User enters first name, last name, email and password") public void
	 * user_enters_first_name_last_name_email_and_password() throws
	 * InterruptedException { registerObject = new UserRegistrationPage(driver);
	 * registerObject.userRegisteration("Joe", "Mama", "egtsy@email.com",
	 * "123456789"); }
	 */

	@When("User enters {string}, {string}, {string}, {string}")
	public void user_enters(String firstname, String lastname, String email, String password) throws InterruptedException {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
	}

	@Then("the registration page is displayed successfully")
	public void the_registration_page_is_displayed_successfully() {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userLogout();
	}
}
