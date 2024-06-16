package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	//1. Create an object of WebDriver
	WebDriver ldriver;
	
	//2. create Constructor
	public IndexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	//3. Identify WebElements
	@FindBy(linkText = "Sign in")
	WebElement signIn; 
	//or
    //@FindBy(linkText = "Sign in") WebElement signin;
	
	//4. Identify action on WebElement
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public String getPageTitle() {
		return (ldriver.getTitle());
	}
	
}
