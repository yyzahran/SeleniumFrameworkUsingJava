package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.EmailPage;
import pages.HomePage;
import pages.Loginpage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchProductPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class E2ETestSteps extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	Loginpage loginObject;
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	ProductReviewPage reviewObject;
	ShoppingCartPage cartObject;
	CheckOutPage outObject;
	OrderDetailsPage orderObject;
	String productName = "Asus N551JK-XO076H Laptop";
	
	
	
	@Given("user is on Home Page")
	public void user_is_on_Home_Page() {
	   assertTrue(driver.getTitle().contains("demo"));
	}

	@When("he search for {string}")
	public void he_search_for(String string) throws InterruptedException {
	    searchObject = new SearchProductPage(driver);
	    searchObject.productSearchByAutoComplete(productName);
	    detailsObject = new ProductDetailsPage(driver);
	    assertTrue(detailsObject.productNameBreadCrumb.getText().contains(productName));
	}

	@When("choose to buy Two items")
	public void choose_to_buy_Two_items() {
	    detailsObject = new ProductDetailsPage(driver);
	    detailsObject.AddProductToCart();
	    detailsObject.GoToShoppingCartPage();
	    
	}

	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
	    cartObject = new ShoppingCartPage(driver);
	    cartObject.GoToCheckOut();
	    cartObject.GuestGoToCheckOut();
	    outObject = new CheckOutPage(driver);
	    outObject.CheckoutProduct("Joe", "Jack", "Egypt", "tt@ee.caa", "address", "12215", "4545", "Wakanada", productName);
	}

	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		  orderObject = new OrderDetailsPage(driver);
		  outObject = new CheckOutPage(driver);
		  outObject.confirmOrder();
		  outObject.viewOrderDetails();
		  orderObject.PrindOrderDetails();
		  orderObject.DownloadPDFInvoice();
	}
	

}
