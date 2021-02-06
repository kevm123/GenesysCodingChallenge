package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	RemoteWebDriver driver;
	WebDriverWait wait;

	public SearchPage(RemoteWebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 100);
	}

	//Select first element from list and Test Next Page Is Correct
	public ItemPage chooseFirstItem(String expectedFirstItemURL, String itemPageTitle) {
		WebElement parentDiv = driver.findElement(By.id("category-search-wrapper"));
		WebElement ol = parentDiv.findElement(By.tagName("ol"));
		List<WebElement> list = ol.findElements(By.tagName("li"));
		expectedFirstItemURL = (expectedFirstItemURL.substring(0, expectedFirstItemURL.length() - 1)).concat(list.get(0).getAttribute("data-product-url"));
		list.get(0).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("purchase-form-button")));
		correctPageCheck(expectedFirstItemURL, itemPageTitle);
		return new ItemPage(driver);
	}

	//PAGE IS LOADED CHECK
	private void correctPageCheck(String expectedURL, String pageTitle) {
		try {
			Assert.assertEquals(expectedURL, driver.getCurrentUrl());
			Assert.assertEquals(pageTitle, driver.getTitle());
			System.out.println("Navigated to correct webpage:\t" + expectedURL);
			System.out.println("TEST 1 PASS");

		} catch (Throwable pageNavigationError) {
			System.out.println(
					"Didn't navigate to correct webpage, on " + driver.getCurrentUrl() + " expected " + expectedURL);
		}
	}

}
