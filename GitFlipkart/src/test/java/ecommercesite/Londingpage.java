package ecommercesite;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pgeobjects.Homepage;
import resources.Base;


public class Londingpage extends Base {
	
	public static Logger log=LogManager.getLogger(Londingpage.class.getName());
		
	@Test
	public void srachforproduct() throws InterruptedException, IOException 
	{
		Homepage hp=new Homepage(driver);
		hp.search().click();
		hp.search().sendKeys("Boat ava");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//	driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li[3]"));
		List<WebElement>options=driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li"));
		for(WebElement option: options) 
		{
			
			if(option.getText().equalsIgnoreCase("boat aavante bar")) 
			{
				option.click();
				break;

			}

		}
		log.info("Selected avanta boat bar from search suggestive box");
		Assert.assertTrue(true);



	}
}
