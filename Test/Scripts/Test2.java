package Scripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.*;

public class Test2 {

	@Test
	public void CreateAccountTest() throws MalformedURLException {

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());
		// Strings for checks
		String homeURL = "https://www.dunnesstores.com/";
		String accountURL = "https://www.dunnesstores.com/customer/login";

		String homePageTitle = "Fashion, Homewares, Gifts & More";
		String accountTitle = "Dunnes Stores | Login / Register";

		driver.get("https://www.dunnesstores.com/");
		
		HomePage homePage = new HomePage(driver);
		homePage.correctPageCheck(homeURL, homePageTitle);
		homePage.acceptCookies();
		LoginPage loginPage = homePage.myAccountClick(accountURL, accountTitle);
		loginPage.filleInfoNoEmail();
		loginPage.createAccountCLick();
		loginPage.testEmailError();
		
		driver.quit();
	}

}
