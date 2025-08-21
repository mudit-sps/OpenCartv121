package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

public static WebDriver driver;
public Logger logger;
public Properties p;

	@BeforeClass (groups = {"Sanity","Regression","Master"})
	@Parameters({"Browser","OS"})
	public void setup(String brw, String os) throws IOException
	{
		//loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		// Loggers
		logger=LogManager.getLogger(this.getClass());
				
		switch(brw.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("Invalid Browser selected"); return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("url"));	//reading url from properties file
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(10);
		return generatedString;
	}
	public String randomNumber()
	{
		String generateNumber=RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	public String randomAlphaNumberic()
	{
		String generateAlphaNumeric=RandomStringUtils.randomAlphanumeric(10);
		return generateAlphaNumeric;
	}

	public String captureScreenshot(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String targetLocPath=System.getProperty("user.dir")+"\\screensshots\\"+tname+timeStamp;
		File trg=new File(targetLocPath);
		src.renameTo(trg);
		return targetLocPath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
