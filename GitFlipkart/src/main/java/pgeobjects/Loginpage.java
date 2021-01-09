package pgeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	
public class Loginpage {

	public  WebDriver driver;
	public Loginpage(WebDriver driver) {
		
		this.driver=driver;	
		
	} 
	
	 By newtoFlipkart=By.linkText("New to Flipkart? Create an account");
	 By existinguser=By.xpath("//a[@href='/account/login?ret=/']/span");
	 By username=By.xpath("//div[@class='IiD88i _351hSN']//input[@type='text']");
	 By password=By.xpath("//div[@class='IiD88i _351hSN']//input[@type='password']");
	 By Loginbutton= By.xpath("//button/span[contains(text(),'Login')]");
	 
	 public WebElement clicknewtoflipkart()
	 {
		 return driver.findElement(newtoFlipkart);
	 }
	 
	 public WebElement existing()
	 {
		 return driver.findElement(existinguser);
	 }
	 
	 public WebElement enterusername()
	 {
		 return driver.findElement(username);
	 }
	 
	 public WebElement enterpassword()
	 {
		 return driver.findElement(password);
	 }
	
	 public WebElement clickonlogin()
	 {
		return driver.findElement(Loginbutton);
	 }
}
