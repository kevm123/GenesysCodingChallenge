package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	RemoteWebDriver driver;
	WebDriverWait wait;
	WebElement registerForm;
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public void filleInfoNoEmail(){
		//Fill Out Form
		   registerForm = driver.findElement(By.id("register"));	    
		   Select dropdown = new Select(registerForm.findElement(By.id("title")));
		   dropdown.selectByIndex(1);	   
		   registerForm.findElement(By.id("firstName")).sendKeys("Kevin");
		   registerForm.findElement(By.id("lastName")).sendKeys("Moynihan");
		   registerForm.findElement(By.id("mobile")).sendKeys("0123456789");
		   registerForm.findElement(By.id("newPassword")).sendKeys("Password1");
		   registerForm.findElement(By.id("confirmPassword")).sendKeys("Password1");
		   
		   //Scroll Down
		   WebElement element = registerForm.findElement(By.name("registryTandCs"));
		   Actions builder = new Actions(driver);
		   builder.moveToElement(element);
		   builder.click();
		   builder.build().perform();
	}
	
	//Click Create Account Button
	public void createAccountCLick(){
		registerForm.findElement(By.tagName("button")).click();
	}
	
	//Ensure Email Error Appears
	public void testEmailError(){
		try{
			   Assert.assertEquals(true, driver.findElement(By.id("parsley-id-21")).isDisplayed());
			   System.out.println("Submit details works");
			   System.out.println("Email error shown succesfully");
			   System.out.println("TEST 2 PASS");
			 }
			 catch(Throwable pageNavigationError){
			   System.out.println("Didn't show email error");
			 }
	}
}
