package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase {
	HomePage homeObject;
	
	@Test
	public void UserSelectsSubMenuByHovering() {
		homeObject = new HomePage(driver);
		homeObject.SelectNotebooksMenu();
		assertTrue(homeObject.notebookHeadLine.isDisplayed());
	}
}
