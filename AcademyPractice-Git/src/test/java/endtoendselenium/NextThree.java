package endtoendselenium;


import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageobjects.HomepageSecond;
import resources.Root;

public class NextThree extends Root{

	public static Logger log=LogManager.getLogger(NextThree.class.getName());
	//	public WebDriver driver;

	@Test
	public void selectnext3() throws InterruptedException
	{
		HomepageSecond hps=new HomepageSecond(driver);
		hps.enternameinalert().sendKeys("Sharath");
		hps.clickonalertbutton().click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		String alerttext=driver.switchTo().alert().getText();
		log.info("The text present in alert button is : " +alerttext);
		driver.switchTo().alert().accept();
		hps.clcikonconfirmbutton().click();
		wait.until(ExpectedConditions.alertIsPresent());
		String confirmtext=driver.switchTo().alert().getText();
		log.info("The text present in confirm button is : " +confirmtext);
		driver.switchTo().alert().accept();
		hps.openseperatewindow().click();
		hps.opennewtab().click();
		String Parent_Window = driver.getWindowHandle();
		Set <String> wndhndles=driver.getWindowHandles();
		for(String windowhandle: wndhndles)
		{
			driver.switchTo().window(windowhandle);
			String windowtitle= driver.getTitle();
			if(windowtitle.equalsIgnoreCase("Rahul Shetty Academy"))
			{
				log.info("Newtab window matched");
				driver.close();
			}
			else if(windowtitle.equalsIgnoreCase("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy"))
			{
				log.info("opened new sepearate window matched");
				driver.close();
			}	
		}
		driver.switchTo().window(Parent_Window);
	
	}
	
	@AfterTest
	public void closebrwoser()
	{
		driver.quit();
	}

}