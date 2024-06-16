package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserLoginAccount {
	
	WebDriver ldriver;
	
	public RegisteredUserLoginAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement verifyUserName;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement signOut;
	
	public String getUserName() {
		return verifyUserName.getText();
	}
	
	public void clickOnSignOut() {
		signOut.click();
	}
}
