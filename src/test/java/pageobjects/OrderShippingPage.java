package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {
	
	WebDriver ldriver;
	public OrderShippingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="cgv")
	WebElement termsOfService;
	
	@FindBy(name="processCarrier")
	WebElement proceedToCheckoutBtn;
	
	public void clickOnTermsOfServiceCheckBox() {
		termsOfService.click();
	}
	
	public void clickOnProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}
}
