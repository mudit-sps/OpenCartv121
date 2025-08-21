package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator
	@FindBy(xpath = "//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//input[@type='password']/following-sibling::a[contains(.,'Forgotten Password')]")
	WebElement forgetpwd;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement noMatchWaring;
	
	//Action method
	
	public void setEmail(String email)
	{
		username.sendKeys(email);
	}
	
	public void setPassword(String passwd)
	{
		pwd.sendKeys(passwd);
	}
	
	public void clickloginbtn()
	{
		loginbtn.click();
	}
	
	public void clearEmail()
	{
		username.clear();
	}
	public void clearPassword()
	{
		pwd.clear();
	}
	
	public void clickForgetPwdLink()
	{
		forgetpwd.click();
	}
	
	public String getWarnMessage()
	{
		return noMatchWaring.getText();
	}

}
