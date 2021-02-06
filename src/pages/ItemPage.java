package pages;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {

	RemoteWebDriver driver;
	WebDriverWait wait;
	
	public ItemPage(RemoteWebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 100);
	}


}
