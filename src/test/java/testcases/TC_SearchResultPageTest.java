package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IndexPage;
import pageobjects.LoginPage;
import pageobjects.RegisteredUserLoginAccount;
import pageobjects.SearchResultPage;

public class TC_SearchResultPageTest extends BaseClass{
	@Test()
	public void verifySearchProduct() {
		
		String productNameToBeSearched = "Blouse";
		logger.info("\n***************TestCase Search Product started*****************"); 
		IndexPage indpage = new IndexPage(driver);
		indpage.clickOnSignIn();
		logger.info("Clicked on signIn link!!!..");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterRegisteredEmailAddress(email);
		logger.info("Entered email address in input field!!!.."+email);
		
		lp.enterPassword(password);
		logger.info("Entered password in input field!!!.."+password);
		
		lp.clickOnSignInBtn();
		logger.info("Clicked on SignIn button!!!..");
		
		SearchResultPage srp = new SearchResultPage(driver);
		srp.enterDataInSearchBox(productNameToBeSearched);
		logger.info("Entered product name: " +productNameToBeSearched+" in search input field!!!..");
		
		srp.clickOnSearchBtn();
		logger.info("Clicked on search button!!!..");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String searchedResultProductName = srp.checkSearchedProductName();
		System.out.println("Name of the searched product: "+searchedResultProductName);
		
		if(searchedResultProductName.contains(productNameToBeSearched)) {
			logger.info("Search product Test case - Passed!!!... "+searchedResultProductName);
			Assert.assertTrue(true);
			
			RegisteredUserLoginAccount register = new RegisteredUserLoginAccount(driver);
			register.clickOnSignOut();
			logger.info("Clicked on Sign Out!!!..");
		}else {
			logger.info("verifySearchProduct Test case failed!!...");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
		}
		logger.info("***************TestCase Search Product ends*****************"); 
	}
	
	
}
