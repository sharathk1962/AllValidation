package endtoendselenium;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.homepagetop1;
import resources.Root;

public class Firstffour extends Root{

	public static Logger log=LogManager.getLogger(Firstffour.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver= launchbrowser();

	}
	@BeforeTest
	public void inithialise() throws IOException {

		driver= launchbrowser();

	}
	
	@Test
	public void performfirstsetopertaions() throws InterruptedException
	{
		homepagetop1 hptop1=new homepagetop1(driver);
		hptop1.selectradiobutton().click();
		if(hptop1.selectradiobutton().isSelected())
		{
			log.debug("radio button is selected");
		}
		hptop1.autosuggestive().click();
		hptop1.autosuggestive().sendKeys("uni");
		Thread.sleep(3000);
		hptop1.autosuggestiveoptions();	
		Thread.sleep(3000);
		String selectedcountry = hptop1.autosuggestive().getAttribute("value");
		Assert.assertEquals(selectedcountry, "United Kingdom (UK)");
		log.info("Succesfully selected United Kingdom");
		hptop1.selectdropdown();
		String dropdowntext=hptop1.selectdropdown().getAttribute("value");
		Assert.assertEquals(dropdowntext, "option2", "Values selected not matched for dropdown");
		//		if(dropdowntext.equals("option2")) {
		//			log.info("selected value is option2 and it is expected");
		//		}
		//		else {
		//			log.error("wrong value selected");
		//		}
		hptop1.selectcheckbox().click();
		if(hptop1.selectcheckbox().isSelected())
		{
			log.debug("checkbox is selected");
		}
	}
}
