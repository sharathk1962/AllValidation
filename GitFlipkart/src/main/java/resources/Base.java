package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;


public class Base {	 		

	public static WebDriver driver;		
	public WebDriver launchbrowser() throws IOException
	{	
		System.out.println("execution started");
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		String url=prop.getProperty("url");
		// FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		//	prop.store(fo, browsername);

		if (browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse - workplace\\FB-Autoomation\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
		}

		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\Eclipse - workplace\\FB-Autoomation\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(url);
		}

		if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","E:\\Eclipse - workplace\\FB-Autoomation\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.get(url);
		}
		return driver;
	}	

	public String getScreenshotPath(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";	
		FileUtils.copyFile(src,new File(destFile));
		return destFile;
	}


}

