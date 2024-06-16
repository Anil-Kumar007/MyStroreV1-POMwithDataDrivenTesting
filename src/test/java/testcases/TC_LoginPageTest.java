package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.AddressPage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

import pageobjects.RegisteredUserLoginAccount;
import utilities.ReadExcelFile;

public class TC_LoginPageTest extends BaseClass{	
	@Test(dataProvider = "loginDataProvider", priority = 2)
	public void verifyLogin(String userEmail, String userPassword, String expectedUserName) {
		
		logger.info("\n***************TestCase verify login started*****************"); 
		
		logger.info("Browser launched and landed to website!!!..");
		
		IndexPage indPage = new IndexPage(driver);
		indPage.clickOnSignIn();
		logger.info("clicked on signIn link text!!!..");
		
		LoginPage login = new LoginPage(driver);
		login.enterRegisteredEmailAddress(userEmail);
		logger.info("Entered email address to email address input field!!!.."+userEmail);
		login.enterPassword(userPassword);
		logger.info("Entered password to password input field!!!.."+userPassword);
		login.clickOnSignInBtn();
		logger.info("clicked on signIn Button!!!..");
		
		RegisteredUserLoginAccount regUserLoginAcc = new RegisteredUserLoginAccount(driver);
		String returnUserName = regUserLoginAcc.getUserName();
		System.out.println("After logIn user name is: "+returnUserName);	
		logger.info("User name is: "+returnUserName);
		

		if(returnUserName.equalsIgnoreCase(expectedUserName)) {
			logger.info("User verified - verifyLogin() Test case pass!!!..."+expectedUserName);
			Assert.assertTrue(true);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			regUserLoginAcc.clickOnSignOut();
			logger.info(expectedUserName+"User log out!!!...");			
			
		}else {
			logger.info("User not verified - verifyLogin() Test Case failed!!!...");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
		
		logger.info("\n***************TestCase verify login Ended*****************"); 
		
	}
	
	@DataProvider(name="loginDataProvider")
	public String[][] loginDataProvider(){
		String fileName = System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
		
		int totalRowCount = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int totalColumnsCount = ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][] = new String[totalRowCount-1][totalColumnsCount];
		
		for(int i=1;i<totalRowCount;i++) {
			for(int j=0;j<totalColumnsCount;j++) {
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
	}
	
	@Test(priority = 1)
	public void verifySignOut() {
		
		logger.info("\n***************TestCase verify signout started*****************"); 
		
		IndexPage indPage = new IndexPage(driver);
		indPage.clickOnSignIn();
		logger.info("clicked on signIn link!!!..");
		
		LoginPage login = new LoginPage(driver);
		login.enterRegisteredEmailAddress(email);
		logger.info("enter Email address!!!..");
		login.enterPassword(password);
		logger.info("enter password!!!..");
		login.clickOnSignInBtn();
		logger.info("clicked on signIn Button!!!..");
		
		RegisteredUserLoginAccount regUserLogin = new RegisteredUserLoginAccount(driver);
		regUserLogin.clickOnSignOut();
		logger.info("clicked on signOut link!!!..");
		
		String indexPageTitle = indPage.getPageTitle();
		System.out.println("title of index page is:"+indexPageTitle);
		if(indexPageTitle.equals("Login - My Shop")) {
			logger.info("Verify signout Test case: Passed "+indexPageTitle);
			Assert.assertTrue(true);
		}else {
			logger.info("Verify signout Test case: failed "+indexPageTitle);
			captureScreenShot(driver, "verifySignOut");
			Assert.assertTrue(false);
		}
		
		
		logger.info("\n***************TestCase verify signout ended*****************"); 
		
	}
	
	
}
