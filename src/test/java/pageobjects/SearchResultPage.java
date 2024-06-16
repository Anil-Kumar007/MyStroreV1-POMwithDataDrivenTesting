package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import io.reactivex.rxjava3.functions.Action;

public class SearchResultPage{
	
	WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="search_query_top")
	WebElement searchProducts;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/h5/a")
	WebElement searchedResultProduct;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")
	WebElement mouseOverOnProduct;
	
//	@FindBy(linkText="More")
//	WebElement more;
	
	public void enterDataInSearchBox(String productName) {
		searchProducts.clear();
		searchProducts.sendKeys(productName);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
	public String checkSearchedProductName() {
		String searchedItem = searchedResultProduct.getText();
		return searchedItem;
	}
	
	public void clickOnProductImage() {
		mouseOverOnProduct.click();
	}
	
//	public void ClickOnMoreBtn(){
//		more.click();
//	}
	
}
