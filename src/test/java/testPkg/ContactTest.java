package testPkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import basePkg.ReporterClass;
import pagePkg.ContactPage;

public class ContactTest extends BaseClass {

	ContactPage cp;
	
	@Test
	public void verifyContactOpen() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Contact Popup Verification :-");
     	cp=new ContactPage(driver);
		Thread.sleep(5000);
		cp.openContact();
		if (cp.isContactPopupDisplayed())
		    {
		        test.pass("Contact Popup Verified");
		    }
		    else
		    {
		        test.fail("Contactr Popup is not displayed");

		        String screenshotName = "Contact Popup Verification";
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
		test= extent.createTest("Contact Popup close icon Verification :-");
     	cp=new ContactPage(driver);
		cp.openContact();
		cp.closeContact();
		Thread.sleep(2000);
		if (!cp.isContactPopupDisplayed())
		    {
		        test.pass("Contact Popup close icon Verified");
		    }
		    else
		    {
		        test.fail("Contact Popup is not closed");

		        String screenshotName = "Contact closeicon Verification";
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
		test= extent.createTest("Contact Popup close button Verification :-");
     	cp=new ContactPage(driver);
		cp.openContact();
		cp.closebtn().click();
		Thread.sleep(2000);
		if (!cp.isContactPopupDisplayed())
		    {
		        test.pass("Contact Popup close icon Verified");
		    }
		    else
		    {
		        test.fail("Contact Popup is not closed");

		        String screenshotName = "Contact closeicon Verification";
		        ReporterClass.screenshotMethod(driver, screenshotName);

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );
		    }
		
		
	}
	@Test
	
	public void VerifyLabels() throws InterruptedException, IOException {
		
			    driver.get("https://www.demoblaze.com/");
		
			    test = extent.createTest("Contact Form TextField Label Verification :-");
		
		     	cp=new ContactPage(driver);
				cp.openContact();		
		
			    
			    WebElement name=cp.nameLabel();
			    WebElement email=cp.emailLabel();
			    WebElement message=cp.messageLabel();
			  
			   
			    if(email.getText().equals("Contact Email:") && email.isDisplayed())
			    {
					test.pass("Contact email textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Contact email Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Contact email Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Contact email  Label Verification Failed  ");
			    }
			    
			    if(name.getText().equals("Contact Name:") && name.isDisplayed())
			    {
					test.pass("Contact Name textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Contact Name Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Contact Name Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Contact Name  Label Verification Failed  ");
			    }
			    
			    
			    if(message.getText().equals("Message:") && message.isDisplayed())
			    {
					test.pass("Message textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Message Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Message Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Message  Label Verification Failed  ");
			    }

	}
	
@Test
	
	public void VerifyTextbox() throws InterruptedException, IOException 
{
		
			    driver.get("https://www.demoblaze.com/");
		
			    test = extent.createTest("Contact Form TextField Label Verification :-");
		
		     	cp=new ContactPage(driver);
				cp.openContact();	
				
				WebElement nametxtbox=cp.nametextbox();
			    WebElement emailtxtbox=cp.emailtextbox();
			    WebElement messagetxtbox=cp.messagetextbox();
		
			    if(nametxtbox.isDisplayed())
					{
						test.pass(" Contact name textbox  is displayed ");
		
					}
					else
					{
						 test.fail("Contact name textbox Verification Failed: Textbox is not displayed");
						 
						 	            String screenshotName = " Contact name textbox Verification :" ;
						 
						 	            ReporterClass.screenshotMethod(driver, screenshotName);
						 
						 	            test.addScreenCaptureFromPath(
						 	                    "screenshot\\" + screenshotName + ".png"
						 	            );
						 
						 	            Assert.fail(" Contact name textbox Verification ");
					}
			    
			    if(emailtxtbox.isDisplayed())
				{
					test.pass(" Contact email textbox  is displayed ");
	
				}
				else
				{
					 test.fail("Contact email textbox Verification Failed: Textbox is not displayed");
					 
					 	            String screenshotName = " Contact email textbox Verification :" ;
					 
					 	            ReporterClass.screenshotMethod(driver, screenshotName);
					 
					 	            test.addScreenCaptureFromPath(
					 	                    "screenshot\\" + screenshotName + ".png"
					 	            );
					 
					 	            Assert.fail(" Contact email textbox Verification ");
				} 
			    
			    if(messagetxtbox.isDisplayed())
				{
					test.pass(" Message textbox  is displayed ");
	
				}
				else
				{
					 test.fail("Message textbox Verification Failed: Textbox is not displayed");
					 
					 	            String screenshotName = " Message textbox Verification :" ;
					 
					 	            ReporterClass.screenshotMethod(driver, screenshotName);
					 
					 	            test.addScreenCaptureFromPath(
					 	                    "screenshot\\" + screenshotName + ".png"
					 	            );
					 
					 	            Assert.fail("Message textbox Verification");
				} 
				    
	
}
	
	@Test
	public void VerifyButtons() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Contact Modal forms buttons Verification :-");
		cp=new ContactPage(driver);
		cp.openContact();	
		
		WebElement sendbtn=cp.sendbtn();
	    WebElement closebtn=cp.closebtn();

		if(sendbtn.isDisplayed() && sendbtn.isEnabled())
		    {
				test.pass("Send message button  is displayed and enabled");

		    	if(sendbtn.getText().equals("Send message"))
		    	{
					test.pass("Send message button label  is  correct");

		    	}
		    	else
		    	{
		    		test.fail("Send message button label : Button label  is not  correct");
					 
	 	            String screenshotName = "Send message button Verification" ;
	 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Send message button Verification ");
		    	}
		    }
		    else
		    {
		    	test.fail("Send messager button  : Button   is not   displayed and enabled");
				 
 	            String screenshotName = "Send message button Verification :" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Send message button Verification ");
	    	
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
	public void VerifyValidDetails() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest(" Contact Form  Verification :-");
		cp=new ContactPage(driver);
		cp.openContact();
		
		boolean result = cp.validContactDetails();
		
					    if (result)
					    {
					        test.pass("Contact Form  Submitted Successfully ");
					    }
					    else
					    {
					        test.fail("Contact Form not Submitted ");
					        String screenshotName = "Contact Form Verification" ;
		
				            ReporterClass.screenshotMethod(driver, screenshotName);
		
				            test.addScreenCaptureFromPath(
				                    "screenshot\\" + screenshotName + ".png"
				            );
		
		
						    Assert.assertTrue(result, "Contact Form not Submitted");
		
					    }
		
						 
	}
	
	@Test
	public void VerifyInvalidDetails() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest(" Contact Form with invalid data  Verification :-");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		cp=new ContactPage(driver);
		cp.openContact();
		
		boolean result = cp.InvalidContactDetails();
		 // Capture the current page immediately
	    String screenshotName = "Contact_Form_with_invalid_data";

	    ReporterClass.screenshotMethod(driver, screenshotName);

	    test.addScreenCaptureFromPath(
	        "screenshot\\" + screenshotName + ".png"
	    );
	    cp.submitContactForm();

	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertText = alert.getText();
	    System.out.println("Alert message: " + alertText);

	    alert.accept();

	    if (alertText.equals("Thanks for the message!!")) 
	    {
	        test.fail("Contact form accepted invalid data");
	        Assert.fail("Invalid contact data were accepted");
	    } 
	    else 
	    {
	        test.pass("Invalid contact data are not accepted");
	    }
						 
	}
	
	@Test
	public void VerifyNullDetails() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest(" Contact Form with null data  Verification :-");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		cp=new ContactPage(driver);
		cp.openContact();
		
		boolean result = cp.NullContactDetails();
		 // Capture the current page immediately
	    String screenshotName = "Contact_Form_with_null_data";

	    ReporterClass.screenshotMethod(driver, screenshotName);

	    test.addScreenCaptureFromPath(
	        "screenshot\\" + screenshotName + ".png"
	    );
	    cp.submitContactForm();

	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertText = alert.getText();
	    System.out.println("Alert message: " + alertText);

	    alert.accept();

	    if (alertText.equals("Thanks for the message!!")) 
	    {
	        test.fail("Contact form accepted null data");
	        Assert.fail("Null contact data were accepted");
	    } 
	    else 
	    {
	        test.pass("Null contact data are not accepted");
	    }
						 
	}
	
}
