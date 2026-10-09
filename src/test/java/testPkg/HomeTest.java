package testPkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import basePkg.ReporterClass;
import pagePkg.HomePage;
import java.util.List;

public class HomeTest extends BaseClass {
	
	HomePage hp;
	Actions ob;

	@Test
	public void VerifyLogo() throws IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Logo Verification :-");
        hp=new HomePage(driver);
        WebElement logo=hp.logo();
        if(logo.isDisplayed())
        {
			test.pass("Logo verified");

        }
        else
        {
        	test.fail("Logo verification failed");
        	 String screenshotName = "Logo  Verification:" ;
			 
	            ReporterClass.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(
	                    "screenshot\\" + screenshotName + ".png"
	            );

	            Assert.fail("Logo  Verification Failed  ");
        }
	}
	
	@Test
	public void VerifyTitle() throws IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Title Verification :-");
        hp=new HomePage(driver);
        String actual=driver.getTitle();
        String expected="STORE";
        if(actual.equals(expected))
        {
			test.pass("Title Verified");

        }
        else
        {
        	test.fail("Title verification failed");
       	 String screenshotName = "Title  Verification:" ;
			 
	            ReporterClass.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(
	                    "screenshot\\" + screenshotName + ".png"
	            );

	            Assert.fail("Title  Verification Failed  ");
        }
	}
	
	@Test
public void VerifyNavbar() throws InterruptedException {

	    driver.get("https://www.demoblaze.com/");

	    // Create Extent test
	    test = extent.createTest("Navbar Items  Verification");

	    hp = new HomePage(driver);
        ob=new Actions(driver);

	    List<WebElement> navlinks=hp.navbarLink();
	    
	    try
	    {
	    		
			  for(WebElement ele:navlinks)
			{
				
			        ob.moveToElement(ele).perform();
			        if(ele.isDisplayed() && ele.isEnabled())
			        {
			    	    test.pass("All navbar links are displayed and enabled");

			        }
			        else
			        {
				    	test.fail("All navbar links are not displayed and enabled");

			        }
	
	
			        Thread.sleep(1000);
			}
	    test.pass("Successfully hovered over all navbar links");
	    }
	    catch(Exception e)
	    {
	    	test.fail("Navbar Items Hover Verification Failed");
	    }


	    }
	
	@Test
	public void VerifyCategories() throws InterruptedException {

	    driver.get("https://www.demoblaze.com/");

	    test = extent.createTest("Categories Verification");

	    hp = new HomePage(driver);

	    // Get category names
	    List<String> categoryNames = hp.categoryNames();

	    for(String categoryName : categoryNames) {

	        System.out.println("Category: " + categoryName);

	        // Click category
	        hp.clickCategory(categoryName);

	        Thread.sleep(3000);

	        // Get products
	        List<WebElement> products = hp.products();

	        System.out.println(
	            "Products displayed: " + products.size()
	        );

	        if(products.size() > 0) {

	            test.pass(
	                categoryName + 
	                " category displayed products successfully"
	            );

	        } else {

	            test.fail(
	                categoryName + 
	                " category has no products"
	            );
	        }

	        // Return to home page
	        driver.get("https://www.demoblaze.com/");

	        Thread.sleep(3000);
	    }
	}
	
	@Test
	public void VerifyButtons() throws InterruptedException
	{
		driver.get("https://www.demoblaze.com/");

	    test = extent.createTest("Previous and Next Button Verification");

	    hp = new HomePage(driver);

	    WebElement prevbtn = hp.previousbtn();
	    WebElement nextbtn = hp.nextbtn();

//	    // Get products
//	    List<WebElement> items = hp.items();
//
//
//	    for (WebElement item : items) {
//	        System.out.println("Item = " + item.getText());
//	    }
        //Verify Next button label
	    
	    if(nextbtn.getText().equals("Next"))
	    {
	    	test.pass("Next button label is correct");

	    }
	    else
	    {
	    	test.fail("Next button label is not correct");
	    }
	    

	    // Verify Next button
	    if (nextbtn.isDisplayed() && nextbtn.isEnabled()) {

	        test.pass("Next button is displayed and enabled");
	        hp.clickNext();
	    	test.pass("Next button  is clicked");

	    } 
	    else {
	        test.fail("Next button is not displayed or enabled");
	    }
        //Verify Previous button label
	    
	    if(prevbtn.getText().equals("Previous"))
	    {
	    	test.pass("Previous button label is correct");

	    }
	    else
	    {
	    	test.fail("Previous button label is not correct");
	    }
	    // Verify Previous button
	    if (prevbtn.isDisplayed() && prevbtn.isEnabled()) {
	        test.pass("Previous button is displayed and enabled");
	        hp.clickPrevious();


	    	test.pass("Previous button  is clicked");

	    } else {
	        test.fail("Previous button is not displayed or enabled");
	    }
	   
     
	}
	
	@Test
	public void VerifyCarouselbutton() throws InterruptedException
	{
	    driver.get("https://www.demoblaze.com/");

	    test = extent.createTest(
	        "Previous and Next Carousel Button Verification"
	    );

	    hp = new HomePage(driver);

	    WebElement prevCarouselbtn = hp.carouselprev();
	    WebElement nextCarouselbtn = hp.carouselnext();


	  

	    if(nextCarouselbtn.isDisplayed() && nextCarouselbtn.isEnabled())
	    {
	        test.pass("Next carousel control is displayed and enabled");

	        String beforeNext = hp.getActiveSlide();

	        System.out.println("Before Next : " + beforeNext);

	        nextCarouselbtn.click();

	        Thread.sleep(1500);

	        String afterNext = hp.getActiveSlide();

	        System.out.println("After Next : " + afterNext);

	        if(!beforeNext.equals(afterNext))
	        {
	            test.pass("Next carousel control clicked successfully");
	        }
	        else
	        {
	            test.fail("Next carousel control did not change the slide");
	        }
	    }
	    else
	    {
	        test.fail("Next carousel control is not displayed or enabled");
	    }


	    

	    if(prevCarouselbtn.isDisplayed() && prevCarouselbtn.isEnabled())
	    {
	        test.pass("Previous carousel control is displayed and enabled");

	        String beforePrevious = hp.getActiveSlide();

	        System.out.println(
	            "Before Previous : " + beforePrevious
	        );

	        prevCarouselbtn.click();

	        Thread.sleep(1500);

	        String afterPrevious = hp.getActiveSlide();

	        System.out.println(
	            "After Previous : " + afterPrevious
	        );

	        if(!beforePrevious.equals(afterPrevious))
	        {
	            test.pass(
	                "Previous carousel control clicked successfully"
	            );
	        }
	        else
	        {
	            test.fail(
	                "Previous carousel control did not change the slide"
	            );
	        }
	    }
	    else
	    {
	        test.fail(
	            "Previous carousel control is not displayed or enabled"
	        );
	    }
	}
}
	

       
        
        
	


