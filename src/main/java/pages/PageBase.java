package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	public JavascriptExecutor js;
	public Select sel;
	public Actions action;
	// Create a parameterized constructor
	public PageBase(WebDriver driver) {
		// Pass two arguments to the page factory --> driver and class (which is this)
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickBtn(WebElement btn) {
		btn.click();
	}
	
	protected static void setText(WebElement textElement, String textValue) {
		textElement.sendKeys(textValue);
	}
	
	public void scrollToBtn() {
		js.executeScript("scrollBy(0, 2500)");
	}
	
	public void ClearText(WebElement element) {
		element.clear();
	} 
	
}