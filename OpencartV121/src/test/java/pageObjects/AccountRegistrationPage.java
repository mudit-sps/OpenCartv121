package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.core.JavaScriptCFormat;

public class AccountRegistrationPage extends BasePage{

	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	@FindBy(xpath = "//input[@id='input-firstname']") 
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelePhone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement rdbtnYes;
	
	@FindBy(xpath = "//input[@value='0']")
	WebElement rdbtnNo;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkBoxPrivacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action methods
	public void setFirstName(String FName)
	{
		txtFirstName.sendKeys(FName);
	}
	public void setLastName(String LName)
	{
		txtLastName.sendKeys(LName);
	}
	
	public void setTelephoneNo(String tel)
	{
		txtTelePhone.sendKeys(tel);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwdConfirm)
	{
		txtConfirmPassword.sendKeys(pwdConfirm);
	}
	
	public void clickYesNewsletter()
	{
		rdbtnYes.click();
	}

	public void clickNoNewsletter()
	{
		
		rdbtnNo.click();
	}
	
	public void clickPrivacyPolicy()
	{
		chkBoxPrivacyPolicy.click();
	}
	
	
	public void clickContinuebtn()
	{
		//Sol 1
		btnContinue.click();
	
		//Sol 2
		//btnContinue.submit();
	
		//Sol 3
		//Actions act=new Actions(driver);
		//act.click(btnContinue).perform();
		
		//Sol 4
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol 6
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue));

	}
	
	public String getConfirmationMsg()
	{
		try	
		{
			return msgConfirmation.getText();
		}
		catch (Exception e) {
			return (e.getMessage());
		}
	
	}
	
	
	
	
}
