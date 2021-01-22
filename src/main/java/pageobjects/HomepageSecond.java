package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageSecond {

	public WebDriver driver;
	
	public HomepageSecond(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By openedseperatewindow=By.id("openwindow");
	By opentab=By.id("opentab");
	By entername=By.name("enter-name");
	By alertbutton=By.id("alertbtn");
	By confirmbutton=By.id("confirmbtn");
	
	public WebElement openseperatewindow()
	{
		return driver.findElement(openedseperatewindow);
	}
	
	public WebElement opennewtab()
	{
		return driver.findElement(opentab);
	}
	
	public WebElement enternameinalert()
	{
		return driver.findElement(entername);
	}
	
	public WebElement clickonalertbutton()
	{
		return driver.findElement(alertbutton);
	}
	
	public WebElement clcikonconfirmbutton()
	{
		return driver.findElement(confirmbutton);
	}
	
}
