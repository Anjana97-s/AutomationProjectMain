package testPkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import basePkg.ReporterClass;
import pagePkg.LoginPage;
import pagePkg.SignupPage;

public class SignupTest extends BaseClass {

	SignupPage sp;
	@DataProvider(name="signupData")
	public Object[][] getSignupData() throws Exception
	{
		String path="C:\\Users\\sanja\\OneDrive\\Desktop\\Selenium Automation\\Demoblaze.xlsx";
		return utilities.ExcelUtility.getTestData(path, "Signup");
		
	}
	
	@Test(dataProvider = "signupData")
	public void VerifySignUp(String uname,String password) throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
        test= extent.createTest("Sign up :-"+uname);
		sp=new SignupPage(driver);
		sp.openSign();
		sp.Signup(uname, password);
		 WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(10));

		    try {

		        // Wait for Sign Up alert
		        Alert alert =
		                wait.until(ExpectedConditions.alertIsPresent());

		        String message = alert.getText();

		        System.out.println("Sign Up Alert: " + message);

		        alert.accept();

		        // Validate alert message
		        if (message.equals("Sign up successful.")) {

		            test.pass(
		                    "Sign Up Successful for user: " + uname
		            );

		        } else {

		            String screenshotName =
		                    "Sign_Up_Failed_For_" + uname;

		            ReporterClass.screenshotMethod(
		                    driver,
		                    screenshotName
		            );

		            test.addScreenCaptureFromPath(
		                    "screenshot\\" + screenshotName + ".png"
		            );

		            test.fail(
		                    "Sign Up Validation Failed | Alert: "
		                    + message
		            );

		            Assert.fail(
		                    "Sign Up Validation Failed for "
		                    + uname + " | " + message
		            );
		        }

		    } catch (TimeoutException e) {

		        // Alert did not appear
		        String screenshotName =
		                "Sign_Up_Alert_Not_Displayed_" + uname;

		        ReporterClass.screenshotMethod(
		                driver,
		                screenshotName
		        );

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );

		        test.fail(
		                "Sign Up Alert was not displayed"
		        );

		        Assert.fail(
		                "Sign Up Alert was not displayed for "
		                + uname
		        );
		    }
		
		


        


	}
	
	@Test
	public void clickSignUp() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("SignUp Popup Verification :-");

		sp=new SignupPage(driver);
		Thread.sleep(5000);
		sp.openSign();
		if (sp.isSignupPopupDisplayed())
	    {
	        test.pass("SignUp Popup Verified");
	    }
	    else
	    {
	        test.fail("SignUp Popup is not displayed");

	        String screenshotName = "SignUp Popup Verification";
	        ReporterClass.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(
	                "screenshot\\" + screenshotName + ".png"
	        );
	    }
		
	}
	
	@Test
	public void VerifyCloseicon() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("SignUp Popup close icon Verification :-");

		sp=new SignupPage(driver);
		Thread.sleep(5000);
		sp.openSign();

		sp.closeSign();
		if (!sp.isSignupPopupDisplayed())
	    {
	        test.pass("SignUp Popup close icon Verified");
	    }
	    else
	    {
	        test.fail("SignUp Popup  is not closed");

	        String screenshotName = "SignUp close icon Verification";
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
		test= extent.createTest("SignUp Popup close button Verification :-");
		sp=new SignupPage(driver);
		sp.openSign();
		sp.closebtn().click();
		Thread.sleep(2000);
		if (!sp.isSignupPopupDisplayed())
	    {
	        test.pass("SignUp Popup close button Verified");
	    }
	    else
	    {
	        test.fail("SignUp Popup  is not closed");

	        String screenshotName = "SignUp close button Verification";
	        ReporterClass.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(
	                "screenshot\\" + screenshotName + ".png"
	        );
	    }	
		
		
	}
	
	@Test
	public void VerifyButtons() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Sign up Popup buttons Verification :-");
		sp=new SignupPage(driver);
		sp.openSign();
		WebElement signupbtn=sp.signupbtn();
	    WebElement closebtn=sp.closebtn();

		if(signupbtn.isDisplayed() && signupbtn.isEnabled())
		    {
				test.pass("Sign up button  is displayed and enabled");

		    	if(signupbtn.getText().equals("Sign up"))
		    	{
					test.pass("Sign up  button label  is  correct");

		    	}
		    	else
		    	{
		    		test.fail("Sign up button label : Button label  is not  correct");
					 
	 	            String screenshotName = "Sign up button Verification" ;
	 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Sign up button Verification ");
		    	}
		    }
		    else
		    {
		    	test.fail("Sign up button  : Button   is not   displayed and enabled");
				 
 	            String screenshotName = "Sign up button Verification :" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Sign up button Verification ");
	    	
		    }
	
		if(closebtn.isDisplayed() && closebtn.isEnabled())
		    {
				test.pass("Close button  is displayed and enabled");

		    	if(closebtn.getText().equals("Close"))
		    	{
					test.pass("Close button label  is  correct");

		    	}
		    	else
		    	{
		    		test.fail("Close button label : Button label  is not  correct");
					 
	 	            String screenshotName = "Close button Verification :" ;
	 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Close button Verification ");
		    	}
		    }
		    else
		    {
		    	test.fail("Close button  : Button is not  displayed and enabled");
				 
 	            String screenshotName = "Close button Verification :" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Close button Verification ");
	    	
		    }

	}

@Test
	
	public void VerifyLabels() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("Label Verification :-");

		sp=new SignupPage(driver);	
		sp.openSign();
		WebElement userlabel= sp.UsernameLabel();
		WebElement usertxtbox=sp.UsernameTextbox();
		WebElement passlabel=sp.PasswordLabel();
		WebElement passtxtbox=sp.PasswordTextbox();
		System.out.println("userlabel"+userlabel.getText());
		Thread.sleep(5000);
		
		if(userlabel.getText().equals("Username:") && userlabel.isDisplayed())
		{
			System.out.println("inside if");
			test.pass("Username textbox label verified");
		}
		else
		{
			 test.fail("Username Label Verification Failed:Label is not correct ");
			 
			 	            String screenshotName = "Username Label Verification:" ;
			 
			 	            ReporterClass.screenshotMethod(driver, screenshotName);
			 
			 	            test.addScreenCaptureFromPath(
			 	                    "screenshot\\" + screenshotName + ".png"
			 	            );
			 
			 	            Assert.fail("Username Label Validation Failed  ");
		}
		if(passlabel.getText().equals("Password:") && passlabel.isDisplayed())
		{
			System.out.println("inside if");
			test.pass("Password textbox label verified");
		}
		else
		{
			 test.fail("Password Label Verification Failed: Label is not correct");
			 
			 	            String screenshotName = "Password Label Verification:" ;
			 
			 	            ReporterClass.screenshotMethod(driver, screenshotName);
			 
			 	            test.addScreenCaptureFromPath(
			 	                    "screenshot\\" + screenshotName + ".png"
			 	            );
			 
			 	            Assert.fail("Password Label Validation Failed  ");
		}
		
		
	}

@Test
public void VerifyTextbox() throws InterruptedException, IOException
{
	driver.get("https://www.demoblaze.com/");
	 test= extent.createTest("TextField Verification :-");

	sp=new SignupPage(driver);	
	sp.openSign();
	WebElement usertxtbox=sp.UsernameTextbox();
	WebElement passtxtbox=sp.PasswordTextbox();
	Thread.sleep(5000);
	if(usertxtbox.isDisplayed())
	{
		test.pass("Username textbox is displayed");

	}
	else
	{
		 test.fail("Username textbox Verification Failed: Textbox is not displayed");
		 
		 	            String screenshotName = "Username textbox Verification :" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Username textbox Verification ");
	}
	if(passtxtbox.isDisplayed())
	{
		test.pass("Password textbox is displayed");

	}
	else
	{
		 test.fail("Password textbox Verification Failed: Textbox is not displayed");
		 
		 	            String screenshotName = "Password textbox Verification :" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Password textbox Verification ");
	}


}
}
