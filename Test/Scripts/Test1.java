package Scripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.*;

public class Test1 {

	@Test
	public void CheckSearchAndItemSelection() throws MalformedURLException {

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());

		// Strings for checks
		String homeURL = "https://www.dunnesstores.com/";
		String expectedSearchURL="https://www.dunnesstores.com/search?keywords=Paul+Galvin";
		   
		String homePageTitle="Fashion, Homewares, Gifts & More";
		String searchPageTitle="Dunnes Stores | Search";
		String itemPageTitle="Dunnes Stores | Grey Paul Galvin Grey Braces";
		
		driver.get("https://www.dunnesstores.com/");
		
		HomePage homePage = new HomePage(driver);
		homePage.correctPageCheck(homeURL, homePageTitle);
		homePage.acceptCookies();
		homePage.inputSearch("Paul Galvin");
		SearchPage searchPage = homePage.search(expectedSearchURL, searchPageTitle);
		ItemPage itemPage = searchPage.chooseFirstItem(homeURL, itemPageTitle);
		
		driver.quit();
	}
}
