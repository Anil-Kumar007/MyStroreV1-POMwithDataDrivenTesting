package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	//1. Create WebDriver object
	WebDriver ldriver;
	
	//2. Create constructor
	public MyAccountPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//3.Identify Elements
	@FindBy(id="email_create")
	WebElement enterCreateEmailId;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement createAnAccountButton;
	
	//4. identify action on webElement
	public void enterCreateEmailAddress(String emailInput) {
		enterCreateEmailId.sendKeys(emailInput);
	}
	
	public void createAccountSubmitButton() {
		createAnAccountButton.click();
	}
	
}
