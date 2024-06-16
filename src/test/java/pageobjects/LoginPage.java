package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id ="email")
	WebElement registeredUserEmailAddress;
	
	@FindBy(id = "passwd")
	WebElement registeredUserPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	public void enterRegisteredEmailAddress(String email) {
		registeredUserEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		registeredUserPassword.sendKeys(password);
	}
	
	public void clickOnSignInBtn() {
		signInBtn.click();
	}
	
}
