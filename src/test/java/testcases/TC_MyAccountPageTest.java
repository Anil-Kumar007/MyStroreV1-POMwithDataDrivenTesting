package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.AddressPage;
import pageobjects.CreateAnAccountPage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisteredUserLoginAccount;

public class TC_MyAccountPageTest extends BaseClass{
	
	@Test()
	public void verifyRegistrationAndLogin() {
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickOnSignIn();
		logger.info("clicked on sign in link!!");
		
		MyAccountPage accountpage = new MyAccountPage(driver);
		accountpage.enterCreateEmailAddress("xyz131@gmail.com");
		logger.info("enter email address.!!");
		accountpage.createAccountSubmitButton();
		logger.info("click on create an account button!!!");
		
		CreateAnAccountPage createAccPage = new CreateAnAccountPage(driver);
		createAccPage.selectTitle();
		logger.info("Title selected");
		
		createAccPage.enterFirstName("Ravi");
		logger.info("First Name entered!!!.");
		
		createAccPage.enterLastName("Muski");
		logger.info("last Name entered!!!.");
		
		createAccPage.enterEmailAddress("xyz131@gmail.com");
		logger.info("Email address entered!!!.");
		
		createAccPage.enterPassword("Password123");
		logger.info("Password entered!!!.");
		logger.info("entered all user details on account creation page!!!..");
		createAccPage.clickOnRegisterBtn();
		logger.info("Clicked on Registered Button!!!.");
		
		
		RegisteredUserLoginAccount regUserLogin = new RegisteredUserLoginAccount(driver);
		String returnUserName = regUserLogin.getUserName();
		System.out.println("after login user name is: "+returnUserName);
		logger.info("User name is: "+returnUserName);
		
		if(returnUserName.equalsIgnoreCase("Ravi Muski")) {
			logger.info("VerifyRegistration test case passed!!!");
			Assert.assertTrue(true);
		}else {
			logger.info("VerifyRegistration test case failed!!!");
//			captureScreenShot(driver, "verifyRegistrationandLogin");
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled = false)
	public void verifyAddressDetails() {
		
		logger.info("\n***************TestCase verify AddressDetails started*****************"); 
		
		logger.info("Browser launched and landed to website!!!..");
		
		IndexPage indPage = new IndexPage(driver);
		indPage.clickOnSignIn();
		logger.info("clicked on signIn link text!!!..");
		
		LoginPage login = new LoginPage(driver);
		login.enterRegisteredEmailAddress(email);
		logger.info("Entered email address to email address input field!!!.."+email);
		login.enterPassword(password);
		logger.info("Entered password to password input field!!!.."+password);
		login.clickOnSignInBtn();
		logger.info("clicked on signIn Button!!!..");
		
		AddressPage addPg = new AddressPage(driver);
		addPg.clickOnAddress();
		logger.info("clicked on address button!!!..");
		
		addPg.enterAddressDetails("New York");
		logger.info("detail address provided!!!..");
		addPg.enterCity("Alaska");
		logger.info("City name provided!!!..");
		addPg.selectState("Alaska");
		logger.info("State selected provided!!!..");
		addPg.enterZipCode("99501");
		logger.info("Zip Code provided!!!..");
		addPg.selectCountry("United States");
		logger.info("Country selected provided!!!..");
		addPg.enterHomePhone("9876543210");
		logger.info("Home Phone number provided!!!..");
		addPg.enterMobilePhone("9876543210");
		logger.info("Mobile number provided!!!..");
		addPg.enterAddressType("Home");
		logger.info("'Home' address type provided!!!..");
		addPg.clickOnSaveBtn();
		logger.info("clicked on save button!!!..");
		
		System.out.println("User all details entered!!...");
		
		logger.info("\n***************TestCase verify AddressDetails Ended*****************"); 
	}
	
	

}
