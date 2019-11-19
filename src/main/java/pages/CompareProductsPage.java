package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase {

	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='clear-list']")
	WebElement clearListBtn;
	@FindBy(tagName = "tr")
	List<WebElement> allRows;
	@FindBy(tagName = "td")
	List<WebElement> allCols;
	@FindBy(css = "table.compare-products-table")
	WebElement table;
	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement asusProduct;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement macProduct;

	public void ClearTable() {
		clickBtn(clearListBtn);
	}

	public void CompareProducts() {
		// Get all rows
		System.out.println("The number of rows is " + allRows.size());
		// Get data from every row
		for(WebElement row : allRows) {
			System.out.println(row.getText() + "\t");
			for (WebElement col : allCols) {
				System.out.println(col.getText() + "\t");
			}
		}
		// Get all columns
		System.out.println("The number of rows is " + allCols.size());
	}

}
