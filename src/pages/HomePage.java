package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	RemoteWebDriver driver;
	WebDriverWait wait;


	public HomePage(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	//Click Accept Cookies
	public void acceptCookies(){
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))); 
		driver.findElementById("onetrust-accept-btn-handler").click();
	}
	
	//Type String Into Searchbox
	public void inputSearch(String in){
		driver.findElement(By.id("keywords")).sendKeys(in);  
	}
	
	//Click Searcg and Test Next Page Is Correct
	public SearchPage search(String expectedSearchURL, String searchPageTitle){
		driver.findElement(By.id("search-btn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("category-search-wrapper")));
		correctPageCheck(expectedSearchURL, searchPageTitle);
		return new SearchPage(driver); 
	}
	
	//Press My Account and Test Next Page Is Correct
	public LoginPage myAccountClick(String accountURL,String accountTitle){
		driver.findElement(By.id("f-loginlinks")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("register")));
		correctPageCheck(accountURL, accountTitle);
		return new LoginPage(driver);
	}
	
	//PAGE IS LOADED CHECK
	public void correctPageCheck(String expectedURL, String pageTitle){
		   try{
			   Assert.assertEquals(expectedURL, driver.getCurrentUrl());
			   Assert.assertEquals(pageTitle, driver.getTitle());
			   System.out.println("Navigated to correct webpage:\t"+expectedURL);
			   
			 }
			 catch(Throwable pageNavigationError){
			   System.out.println("Didn't navigate to correct webpage, on "+driver.getCurrentUrl()+" expected "+expectedURL);
			 }
	   }
}
