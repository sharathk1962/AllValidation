package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGeneartion {

 static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automating Flipakart");
		reporter.config().setDocumentTitle("Automation practice");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Sharath Kumar");
		return extent;



	}

}
