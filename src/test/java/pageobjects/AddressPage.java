package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	
	WebDriver ldriver;
	
	public AddressPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id='center_column']/div/div/ul/li[1]/a")
	WebElement address;
	
	@FindBy(id="address1")
	WebElement addressInput;
	
	@FindBy(id="city")
	WebElement cityInput;
	
	@FindBy(id="id_state")
	WebElement stateDropDown;
	
	@FindBy(id="postcode")
	WebElement zipCodeInput;
	
	@FindBy(id="id_country")
	WebElement countryDropDown;
	
	@FindBy(name="phone")
	WebElement homePhoneInput;
	
	@FindBy(id="phone_mobile")
	WebElement mobilePhoneInput;
	
	@FindBy(id="alias")
	WebElement addressTypeInput;
	
	@FindBy(name="submitAddress")
	WebElement saveAddressBtn;
	
	public void clickOnAddress() {
		address.click();
	}
	
	public void enterAddressDetails(String address) {
		addressInput.clear();
		addressInput.sendKeys(address);
	}
	
	public void enterCity(String city) {
		cityInput.clear();
		cityInput.sendKeys(city);
	}
	
	public void selectState(String value) {
		Select select = new Select(stateDropDown);
		select.selectByVisibleText(value);;
	}
	
	public void enterZipCode(String zipCode) {
		zipCodeInput.clear();
		zipCodeInput.sendKeys(zipCode);
	}
	
	public void selectCountry(String country) {
		Select select = new Select(countryDropDown);
		select.selectByVisibleText(country);
	}
	
	public void enterHomePhone(String homePhoneNumber) {
		homePhoneInput.clear();
		homePhoneInput.sendKeys(homePhoneNumber);
	}
	
	public void enterMobilePhone(String mobileNumber) {
		mobilePhoneInput.clear();
		mobilePhoneInput.sendKeys(mobileNumber);
	}
	
	public void enterAddressType(String addressType) {
		addressTypeInput.clear();
		addressTypeInput.sendKeys(addressType);
	}
	
	public void clickOnSaveBtn() {
		saveAddressBtn.click();
	}
}
