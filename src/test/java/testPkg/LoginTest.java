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

public class LoginTest extends BaseClass {

	LoginPage lp;
	
	@DataProvider(name="loginData")
	public Object[][] getLoginData() throws Exception
	{
		String path="C:\\Users\\sanja\\OneDrive\\Desktop\\Selenium Automation\\Demoblaze.xlsx";
		return utilities.ExcelUtility.getTestData(path, "Login");
		
	}
	

@Test(dataProvider = "loginData")
public void VerifyLogin(String uname, String password)
        throws InterruptedException, IOException {

    driver.get("https://www.demoblaze.com/");

    test = extent.createTest("Login :- " + uname);

    lp = new LoginPage(driver);

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(3));

    lp.openLogin();
    lp.Login(uname, password);
    lp.submitLoginForm();

    // Step 1: Check whether a login alert appears
    Alert alert = null;

    try {
        alert = wait.until(
                ExpectedConditions.alertIsPresent());
    } catch (TimeoutException e) {
        // No alert appeared; verify login below
    }

    if (alert != null) {

        String message = alert.getText();

        System.out.println("Login Alert: " + message);

        alert.accept();

        test.fail("Login Failed for user: " + uname
                + " | Alert: " + message);

        String screenshotName = "Login_Failed_For_" + uname;

        ReporterClass.screenshotMethod(driver, screenshotName);

        test.addScreenCaptureFromPath(
                "screenshot\\" + screenshotName + ".png");

        Assert.fail("Login Failed for " + uname
                + " | " + message);
    }

    // Step 2: Verify successful login
    boolean loginSuccess = false;

    try {
        loginSuccess = lp.verifyLoggedInUsername(uname);
    } catch (TimeoutException e) {
        loginSuccess = false;
    }

    if (loginSuccess) {

        test.pass("Login Successful for user: " + uname);

        // Step 3: Verify logout separately
        test  =
                extent.createTest("Logout Verification :- " + uname);

        boolean logout = lp.logout();

        if (logout) {

            test.pass("User Logout Successful: " + uname);

        } else {

            test.fail("Logout Validation Failed for user: " + uname);

            String screenshotName = "Logout_Validation_Failed_" + uname;

           ReporterClass.screenshotMethod(driver, screenshotName);

            test.addScreenCaptureFromPath(
                    "screenshot\\" + screenshotName + ".png");

            Assert.fail("Logout Validation Failed for " + uname);
        }

    } else {

        test.fail("Login Validation Failed for user: " + uname);

        String screenshotName = "Login_Validation_Failed_" + uname;

        ReporterClass.screenshotMethod(driver, screenshotName);

        test.addScreenCaptureFromPath(
                "screenshot\\" + screenshotName + ".png");

        Assert.fail("Login Validation Failed for " + uname);
    }
}

	
	@Test
	public void clickLogin() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Login Popup Verification :-");

		lp=new LoginPage(driver);
		Thread.sleep(5000);
		lp.openLogin();
		
		if (lp.isLoginPopupDisplayed())
	    {
	        test.pass("Login Popup Verified");
	    }
	    else
	    {
	        test.fail("Login Popup is not displayed");

	        String screenshotName = "Login Popup Verification";
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
		test= extent.createTest("Login Popup close icon Verification :-");
		lp=new LoginPage(driver);
		lp.openLogin();

		lp.closeLogin();
		Thread.sleep(2000);
		if (!lp.isLoginPopupDisplayed())
	    {
	        test.pass("Login Popup close icon Verified");
	    }
	    else
	    {
	        test.fail("Login Popup  is not closed");

	        String screenshotName = "Login close icon Verification";
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
		test= extent.createTest("Login Popup close button Verification :-");
     	lp=new LoginPage(driver);
		lp.openLogin();
		lp.closebtn().click();
		Thread.sleep(2000);
		if (!lp.isLoginPopupDisplayed())
		    {
		        test.pass("Login Popup close button Verified");
		    }
		    else
		    {
		        test.fail("Login Popup is not closed");

		        String screenshotName = "Login close button Verification";
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
		test= extent.createTest("Login Popup buttons Verification :-");
		lp=new LoginPage(driver);
		lp.openLogin();
		
		WebElement loginbtn=lp.loginbtn();
	    WebElement closebtn=lp.closebtn();

		if(loginbtn.isDisplayed() && loginbtn.isEnabled())
		    {
				test.pass("Login button  is displayed and enabled");

		    	if(loginbtn.getText().equals("Log in"))
		    	{
					test.pass("Login  button label  is  correct");

		    	}
		    	else
		    	{
		    		test.fail("Login button label : Button label  is not  correct");
					 
	 	            String screenshotName = "Login button Verification" ;
	 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Login button Verification ");
		    	}
		    }
		    else
		    {
		    	test.fail("Login button  : Button   is not   displayed and enabled");
				 
 	            String screenshotName = "Login button Verification :" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Login button Verification ");
	    	
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

		 lp=new LoginPage(driver);	
		lp.openLogin();
		WebElement userlabel= lp.UsernameLabel();
		WebElement usertxtbox=lp.UsernameTextbox();
		WebElement passlabel=lp.PasswordLabel();
		WebElement passtxtbox=lp.PasswordTextbox();
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

	lp=new LoginPage(driver);	
	lp.openLogin();
	WebElement usertxtbox=lp.UsernameTextbox();
	WebElement passtxtbox=lp.PasswordTextbox();
	Thread.sleep(5000);
	if(usertxtbox.isDisplayed())
	{
		test.pass("Username textbox is displayed ");

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
