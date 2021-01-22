package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class homepagetop1 {
	public WebDriver driver;

	public homepagetop1(WebDriver driver)
	{
		this.driver=driver;
	}

	private By radio2button=By.cssSelector("input[value='radio2']");

	private By autosuggest=By.id("autocomplete");

	private By getalloptions=By.xpath("//ul[@id='ui-id-1']/li");

	private By dropdown=By.name("dropdown-class-example");

	private By checkbox=By.id("checkBoxOption3");

	public WebElement selectradiobutton()
	{
		return driver.findElement(radio2button);
	}

	public WebElement autosuggestive()
	{
		return driver.findElement(autosuggest);
	}

	public WebElement autosuggestiveoptions()
	{
		List<WebElement>options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));	

		for(WebElement option: options) 
		{
			if(option.getText().equalsIgnoreCase("United Kingdom (UK)")) 
			{
				option.click();
				break;
			}
		}
		return driver.findElement(getalloptions);
	}

	public WebElement selectdropdown()
	{
		Select s=new Select(driver.findElement(dropdown));
		s.selectByVisibleText("Option2");
		return driver.findElement(dropdown);
	}
	

	public WebElement selectcheckbox()
	{
		return driver.findElement(checkbox);
	}


}
