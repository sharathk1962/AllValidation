package ecommercesite;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pgeobjects.Searchresults;
import resources.Base;

public class SelectandAddtoCart extends Base {

	public static Logger log=LogManager.getLogger(SelectandAddtoCart.class.getName());
	
	@Test
	public void searchandadd() throws InterruptedException
	{
		Searchresults sr; sr=new Searchresults(driver);
		Thread.sleep(4000);
		WebElement boat160=driver.findElement(By.linkText("boAt Aavante Bar 2000 160 W Bluetooth Soundbar"));
		Actions a=new Actions(driver);
		a.moveToElement(boat160).click().build().perform();
		log.debug("clciked on bluetooth soundbar");
		Set <String> windowsl=driver.getWindowHandles();
		Iterator<String> it=windowsl.iterator();
		it.next();
		driver.switchTo().window(it.next());
		String title = driver.getTitle();
		//print the window handle id of each browser window
		System.out.println("Title of the page -->"+ title );
		sr.addtocart().click();
		log.debug("item added to cart succesfuly");
		Thread.sleep(4000);
		sr.removefromcart().click();
		Thread.sleep(4000);
		sr.confirmremove().click();
		Thread.sleep(4000);
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Your cart is empty!']")));
	//	String noitems=sr.cartisempty().getText();
		Assert.assertEquals(sr.cartisempty().getText(), "Your cart is empty!");

		}
	}


