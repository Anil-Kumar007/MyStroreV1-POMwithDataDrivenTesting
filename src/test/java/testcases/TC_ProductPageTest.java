package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IndexPage;
import pageobjects.LoginPage;
import pageobjects.OrderAddressPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.OrderPaymentPage;
import pageobjects.OrderShippingPage;
import pageobjects.OrderSummaryPage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;

public class TC_ProductPageTest extends BaseClass{
	
	@Test
	public void verifyBuyProduct() {
		
		logger.info("\n***************TestCase Buy Product started*****************"); 
		
		IndexPage indPage = new IndexPage(driver);
		indPage.clickOnSignIn();
		logger.info("Clicked on sign In link!!!...");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterRegisteredEmailAddress(email);
		logger.info("Entered email address for login!!!...");
		loginPage.enterPassword(password);
		logger.info("Entered email address for login!!!...");
		loginPage.clickOnSignInBtn();
		logger.info("Clicked on sign In button!!!...");
		
		SearchResultPage search = new SearchResultPage(driver);
		search.enterDataInSearchBox("Blouse");
		logger.info("Entered product name to search field!!!...");
		search.clickOnSearchBtn();
		logger.info("Clicked on Search button to find the product name that is written search field!!!...");
		
		search.clickOnProductImage();
		logger.info("Clicked on product image on Product Page!!!...");		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		search.ClickOnMoreBtn();
//		logger.info("Click on more button on product name that is appeared after search!!!...");
		
		ProductPage productPg = new ProductPage(driver);
		productPg.selectSizeDropDown("M");
		logger.info("Size 'M' selected from drop down list!!!...");
		
		productPg.enterQuantityRequiredForProduct("2");
		logger.info("Quantity 2 entered!!!...");
		productPg.increaseDecreaseQuantity();
		logger.info("increase and decrease the product Quantity!!!...");
		
		productPg.chooseColor();
		logger.info("Select the color!!!...");
		
		productPg.clickOnAddToCartBtn();
		logger.info("Clicked on Add to Cart button!!!...");
		productPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to check out button on Product Page!!!...");
		
		OrderSummaryPage osp = new OrderSummaryPage(driver);
		
		String pageTitle = getPageTitle();
		System.out.println("Current Page name is: "+pageTitle);
		logger.info("Current Page name is: "+pageTitle);
		
//		if(pageTitle.equals("Order - My Shop")) {
//			logger.info("page title is: "+pageTitle);
//			Assert.assertEquals(pageTitle, "Order - My Shop");
//		}else {
//			
//		}
		
		osp.clickOnProceedToCheckout();
		logger.info("Clicked on proceed to check out button on Product Summary Page!!!...");
		
		OrderAddressPage oap = new OrderAddressPage(driver);
		oap.clickOnProceedToCheckOutBtn();
		logger.info("Clicked on proceed to check out button on Order Address Page!!!...");
		
		OrderShippingPage orderShippingPage = new OrderShippingPage(driver);
		orderShippingPage.clickOnTermsOfServiceCheckBox();
		logger.info("Clicked on terms of service button on Order Shipping Page!!!...");
		orderShippingPage.clickOnProceedToCheckoutBtn();
		logger.info("Clicked on proceed to checkOut button on Order Shipping Page!!!...");
		
		OrderPaymentPage orderPayment = new OrderPaymentPage(driver);
		orderPayment.clickOnPayByCheck();
		logger.info("CLicked on Payment made by 'PayByCheck'");
		
		OrderConfirmationPage orderConfirmation = new OrderConfirmationPage(driver);
		orderConfirmation.clickOnConfirmationBtn();
		logger.info("CLicked on 'I Confirm my Order'!!!..");
		
		String orderSuccessMessage = orderConfirmation.getOrderSuccessMessage();
		
		if(orderSuccessMessage.equals("Your order on My Shop is complete.")) {
			logger.info("Your order confirmed - Test case Passed!!!.."+ orderSuccessMessage);
			Assert.assertTrue(true);
			orderConfirmation.clickOnSignOut();
			logger.info("user sign out!!!..");
		}else {
			logger.info("Order not confirmed - Test case failed!!!...");
			captureScreenShot(driver, "verifyBuyProduct");
			Assert.assertTrue(false);
		}
		logger.info("***************TestCase BuyProduct ends*****************");
	}
	
}
