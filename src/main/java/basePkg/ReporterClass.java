package basePkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReporterClass {
	
	public static   WebDriver driver;
	String url="https://www.saucedemo.com/";
	public static  ExtentSparkReporter reporter;
	public static  ExtentReports extent;
	public static  ExtentTest test;
	
	
	public static ExtentReports sam()
	{
		reporter=new ExtentSparkReporter(".\\Reports\\swaglaqbs.html");
		reporter.config().setDocumentTitle("Automation tool");
		reporter.config().setReportName("Functional Testing");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows11");
		extent.setSystemInfo("Tester", "Anjana");
		extent.setSystemInfo("Browser Name", "Chrome");
		return extent;
	}
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case falied is"+result.getName());
			test.log(Status.FAIL, "test case falied is"+result.getThrowable());
			
			String screenshotpath=screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "test case skipped is"+result.getName());

		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "test case passed is"+result.getName());

		}
	}
	public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {
		// TODO Auto-generated method stub
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination ="./Reports/screenshots/"+screenshotname+".png";
		FileHandler.copy(src,new File(destination));
		return destination;
		
	}

}
