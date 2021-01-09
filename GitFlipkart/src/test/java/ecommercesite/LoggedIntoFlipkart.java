package ecommercesite;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pgeobjects.Homepage;
import pgeobjects.Loginpage;
import resources.Base;
		
public class LoggedIntoFlipkart extends Base{
 
	public WebDriver driver;	

	public static Logger log=LogManager.getLogger(LoggedIntoFlipkart.class.getName());	
	@BeforeTest
	public void initalisebrowser() throws IOException, InterruptedException
	{
		driver=launchbrowser();	
		driver.manage().window().maximize();
	}

	@Test
	public void signntoflipkart() throws IOException, InterruptedException
	{

		Loginpage lp=new Loginpage(driver);
		lp.clicknewtoflipkart().click();
		lp.existing().click();
		lp.enterusername().sendKeys("9739221652");
		lp.enterpassword().sendKeys("qwerty123");
		lp.clickonlogin().click();
		Homepage hp=new Homepage(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver,15);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sharath')]")));
		String personanme=hp.loggedinas().getText();
		//		Assert.assertTrue(true);
		Assert.assertEquals(personanme, "Sharath");
		if(personanme.equalsIgnoreCase("Sharath")){
			log.info("logged into flipkart succesfully as " +personanme);
		}
		else
			log.error("logged into flipkart as " +personanme+ "failed");		

	}


	@AfterTest
		public void closebrowser()
		{
			driver.quit();
		}
		


}