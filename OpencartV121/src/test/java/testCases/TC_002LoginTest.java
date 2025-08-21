package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.ExcellUtility;

public class TC_002LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() throws IOException
	{
		logger.info("**** Login Test Started ******");
		try
		{
		HomePage hp=new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickloginbtn();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		Assert.assertEquals(true, myacc.isMyAccountPageExists());
		}
		catch(Exception e)
		{
			logger.info("Catch Block executed");
			Assert.fail();
		}
		
		logger.info("Login Test Finished");
		
		
		
	}

}
