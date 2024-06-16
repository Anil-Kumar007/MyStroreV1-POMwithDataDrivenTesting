package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
	
	WebDriver ldriver;
	
	public OrderPaymentPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	public void clickOnPayByBankWire() {
		payByBankWire.click();
	}
	
	public void clickOnPayByCheck() {
		payByCheck.click();
	}
}
