package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	WebDriver ldriver;
	public OrderConfirmationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement orderConfirmationBtn;
	
	@FindBy(xpath="//div[@id='center_column']/p[@class='alert alert-success']")
	WebElement orderConfirmationSuccessAlert;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement signOut;
	
	public void clickOnConfirmationBtn() {
		orderConfirmationBtn.click();
	}
	
	public String getOrderSuccessMessage() {
		String successAlert = orderConfirmationSuccessAlert.getText();
		return successAlert;
	}
	
	public void clickOnSignOut() {
		signOut.click();
	}
}
