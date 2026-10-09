package testPkg;

import java.io.IOException;

import org.testng.annotations.Test;

import basePkg.BaseClass;
import basePkg.ReporterClass;
import pagePkg.AboutUsPage;

public class AboutUsTest extends BaseClass {
	
	AboutUsPage ap;
	
	@Test
	public void verifyAboutOpen() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("About Us Popup Verification :-");
     	ap=new AboutUsPage(driver);
		Thread.sleep(5000);
		ap.openAboutus();

		if (ap.isAboutPopupDisplayed())
		    {
		        test.pass("About Us Popup Verified");
		    }
		    else
		    {
		        test.fail("About Us Popup is not displayed");

		        String screenshotName = "About Us Popup Verification";
		        ReporterClass.screenshotMethod(driver, screenshotName);

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );
		    }
		
		
	}
	
	@Test
	public void verifyCloseicon() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("About Us Popup close icon Verification :-");
     	ap=new AboutUsPage(driver);
		Thread.sleep(5000);

		ap.openAboutus();
		ap.closeAbout();
		if (!ap.isAboutPopupDisplayed())
		    {
		        test.pass("About Us Popup close icon Verified");
		    }
		    else
		    {
		        test.fail("About Us Popup is not closed");

		        String screenshotName = "About Us close icon Verification";
		        ReporterClass.screenshotMethod(driver, screenshotName);

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );
		    }
		
		
	}
	
	@Test
	public void verifyClosebutton() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("About Us Popup close button Verification :-");
     	ap=new AboutUsPage(driver);
		Thread.sleep(5000);

		ap.openAboutus();
		ap.closebtn().click();
		if (!ap.isAboutPopupDisplayed())
		    {
		        test.pass("About Us Popup close button Verified");
		    }
		    else
		    {
		        test.fail("About Us Popup is not closed");

		        String screenshotName = "About Us close button Verification";
		        ReporterClass.screenshotMethod(driver, screenshotName);

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );
		    }
		
		
	}
	
	@Test
	public void verifyPlaybutton() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("AboutUs Playbutton Verification :-");
     	ap=new AboutUsPage(driver);
		ap.openAboutus();
		boolean result=	ap.clickplaybutton();
		Thread.sleep(5000);

		if(result)
		{
			  test.pass("AboutUs Playbutton Verified");
		}
		
		else
		{
			  test.fail("AboutUs Playbutton is not displayed");

		        String screenshotName = "AboutUs Playbutton Verification";
		        ReporterClass.screenshotMethod(driver, screenshotName);

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );
		}

		
		      
		    
		    
		
		
	}

}
