package pgeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Searchresults {
	
	public WebDriver driver;
	public Searchresults(WebDriver driver)
	{
		this.driver=driver;
	}

	By Boat160W=By.linkText("boAt Aavante Bar 2000 160 W Bluetooth Soundbar");
	By addtocart=By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
	//to remove added item
	By Remove=By.xpath("//div[text()='Remove']");
	By confrmremove=By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]");
	
	//validate cart is empty
	By cartempty=By.xpath("//div[text()='Your cart is empty!']");
	
	public WebElement boat160wselected() {
		return driver.findElement(Boat160W);
	}
	
	public WebElement addtocart() {
		return driver.findElement(addtocart);
	}
	
	public WebElement removefromcart() {
		return driver.findElement(Remove);
	}
	
	public WebElement confirmremove() {
		return driver.findElement(confrmremove);
	}
	
	public WebElement cartisempty() {
		return driver.findElement(cartempty);
	}
}
