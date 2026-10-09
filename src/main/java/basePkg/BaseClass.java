package basePkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {
	
	public static  ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;

	
	public String url="https://www.demoblaze.com/";
	@BeforeSuite
	public void urlLoading()
	{
		    extent = ReporterClass.sam();
			driver= new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();

	}
	@AfterSuite
	public void close()
	{
		driver.quit();
		extent.flush();
	}

}
