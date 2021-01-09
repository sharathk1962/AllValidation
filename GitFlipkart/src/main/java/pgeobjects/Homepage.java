package pgeobjects;

import org.openqa.selenium.By;	 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {	
	
	public WebDriver driver;


	//page object is written using page factory
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(text(),'Sharath')]")
	WebElement displayname;
	
	@FindBy(css="input[type='text']")
	WebElement searchbar;
	

	
	
	public WebElement loggedinas()
	{
		return displayname;
	}
	
	public WebElement search()
	{
		return searchbar;
	}
	
}
