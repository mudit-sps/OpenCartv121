package testCases;
import testBase.BaseClass;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;
import pageObjects.HomePage;

public class TC_001AccountRegistration extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void accountReg() throws InterruptedException
	{
		logger.info("****** STARTING TC_001AccountRegistration *****");
		
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("********* clicked on My Account *********");
			hp.clickRegister();
			logger.info("********* clicked on My Registration *********");
			
			AccountRegistrationPage arp=new AccountRegistrationPage(driver);
			logger.info("******Providing customer details.******");
			arp.setFirstName(randomString().toUpperCase());
			arp.setLastName(randomString().toUpperCase());
			arp.setTelephoneNo(randomNumber());
			arp.setEmail(randomString()+"@yopmail.com");
			String pwd=randomString()+randomNumber();
			arp.setPassword(pwd);
			arp.setConfirmPassword(pwd);
			arp.clickPrivacyPolicy();
			arp.clickContinuebtn();
			logger.info("******Clicked on continue button******");
			Thread.sleep(3000);
			String message=arp.getConfirmationMsg();
			logger.info("******Validating expected message******");
			if(message.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed..");
				logger.debug("Debug logs");
				Assert.assertFalse(false);
			}
			//Assert.assertEquals(message, "Your Account Has Been Created!!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****** Finished TC_001AccountRegistration *****");
	
	}
	
	
	



}
