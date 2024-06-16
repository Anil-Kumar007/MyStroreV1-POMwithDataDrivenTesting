package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class ProductPage {
	
	WebDriver ldriver;
	public ProductPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="group_1")
	WebElement sizeDropDown;
	
	@FindBy(name="White")
	WebElement color;
	
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(xpath = "//a[@class='btn btn-default button-minus product_quantity_down']")
	WebElement decreaseQtyBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-default button-plus product_quantity_up']")
	WebElement increaseQtyBtn;
	
	@FindBy(name="Submit")
	WebElement addToCartBtn;
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement proceed;
	
	public void enterQuantityRequiredForProduct(String quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}
	
	public void increaseDecreaseQuantity() {
		
		increaseQtyBtn.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		decreaseQtyBtn.click();
		
	}
	
	public void selectSizeDropDown(String sizeType) {
		Select selectSize = new Select(sizeDropDown);
		selectSize.selectByVisibleText(sizeType);
	}
	
	public void chooseColor() {
		color.click();
	}
	
	public void clickOnAddToCartBtn() {
		addToCartBtn.click();
	}
	
	public void clickOnProceedToCheckOut() {
		proceed.click();
	}
	
}
