package pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

	WebDriver ldriver;

	public CreateAnAccountPage(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);
	}

	// identify webelement for title
//	@FindBy(xpath = "//div/div[@class='clearfix']/child::div']")
//	List<WebElement> randomTitle;
	
	@FindBy(id="id_gender1")
	WebElement titleMr;
	
	@FindBy(id = "customer_firstname")
	WebElement firstNameInput;

	@FindBy(id = "customer_lastname")
	WebElement lastNameInput;

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(name = "passwd")
	WebElement passwordInput;
	
	@FindBy(xpath = "//span[text()='Register']")
	WebElement registerBtn;

	public void selectTitle() {
//		Random random = new Random();
//		int randomRadioBtn = random.nextInt(randomTitle.size());
//
//		randomTitle.get(randomRadioBtn).click();
//		System.out.println("The random radio button is: " + randomTitle.get(randomRadioBtn).getAttribute("value"));
		
		titleMr.click();
	}
	
	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)  {
		lastNameInput.sendKeys(lastName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterEmailAddress(String email) {
		emailInput.clear();
		try {
			Thread.sleep(3000);
			emailInput.sendKeys(email);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickOnRegisterBtn() {
		registerBtn.click();
	}
	
}
