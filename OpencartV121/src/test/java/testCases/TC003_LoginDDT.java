package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data Valid--Login Success--Test Pass--Logout
 * 			 --Login failed---Test Failed
 * 
 * Data invalid--Login Success---Test Failed--Logout
 * 				--Login Failed--Test Passed
 */
public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups={"DataDriven"})	//getting dataprovider from different class.
	public void verify_login(String email, String pwd, String type) throws IOException
	{
		logger.info("**** TC003 Login Test Started ******");
		try
		{
		HomePage hp=new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickloginbtn();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean target=myacc.isMyAccountPageExists();
		if(type.equalsIgnoreCase("valid"))
		{
			if(target==true)
				{
				myacc.clickLogOutbtn();
				Assert.assertTrue(true);
				}
			else
				{
					Assert.assertTrue(false);
				}
		}
		if(type.equalsIgnoreCase("invalid"))
		{
			if(target==true)
				{
				myacc.clickLogOutbtn();
				Assert.assertTrue(false);
				}
			else
				{
				Assert.assertTrue(true);
				}
		}	
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println("console fail");
		}
		logger.info("TC 003Login Test Finished");

	}
}