package testPkg;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import basePkg.ReporterClass;
import pagePkg.CartPage;
import pagePkg.HomePage;
import pagePkg.LoginPage;

public class CartTest extends BaseClass {
	
	CartPage cp;
	LoginPage lp;
	HomePage hp;
	


@Test
public void VerifyOrderPopup() throws InterruptedException, IOException {

    driver.get("https://www.demoblaze.com/");

    test = extent.createTest("Place Order Popup Verification");

    lp = new LoginPage(driver);
    hp = new HomePage(driver);
    cp = new CartPage(driver);

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(20));

    lp.openLogin();

    lp.Login("archa", "anju123");

    lp.submitLoginForm();
    WebElement username=lp.LoggedInUsername();
    WebElement loginform=lp.loginform();
    wait.until(ExpectedConditions.visibilityOf(
            username
    ));

    wait.until(ExpectedConditions.invisibilityOf(
    		loginform
    ));

    cp.clickCart();

    WebElement placeOrderButton = cp.placeOrderbtn();
    placeOrderButton.click();
    if (cp.isOrderPopupDisplayed()) {

        test.pass("Place Order Popup Open Verified");

    } else {

        test.fail("Place Order Popup was not displayed");

        String screenshotName = "Place_Order_Popup_Open_Verification";

        ReporterClass.screenshotMethod(driver, screenshotName);

        test.addScreenCaptureFromPath(
                "screenshot\\" + screenshotName + ".png"
        );

        Assert.fail("Place Order Popup was not displayed");
    }
   
}

	@Test()
	public void VerifyOrderCloseicon() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("PlaceOrder Popup Close icon Verification :-");

		    WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(20));

		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
       cp=new CartPage(driver);
		lp.openLogin();
		
		lp.Login("archa", "anju123");
		lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	    WebElement placeOrder=cp.PlaceOrderForm();
	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();

	    WebElement placeOrderButton = cp.placeOrderbtn();
	    placeOrderButton.click();
	    
	    cp.closeOrder();

	    boolean closed = wait.until(
	            ExpectedConditions.invisibilityOf(
	            		placeOrder
	            )
	    );
		    if (closed)
		    {
		        test.pass("Place Order Popup Close Icon Verified");
		    }
		    else
		    {
		        test.fail("Place Order Popup was not closed");

		        String screenshotName = "Place Order Close Icon Verification";
		        ReporterClass.screenshotMethod(driver, screenshotName);

		        test.addScreenCaptureFromPath(
		                "screenshot\\" + screenshotName + ".png"
		        );
		    }

	}
	@Test(priority=1)
	public void AddToCart() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("AddtoCart Verification :-");

		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
         cp=new CartPage(driver);
		lp.openLogin();
		lp.Login("archa", "anju123");
		// Get products from home page
	    List<WebElement> items = hp.getProducts();
	    System.out.println(items.size());
	    List<String> productNames = new ArrayList<>();

	    for (WebElement product : items)
	    {
	        productNames.add(product.getText());
	    }
  
	    
	    // Print product names
	    for (String name : productNames)
	    {
	        System.out.println("Product from Home Page: " + name);
	    }

	    // Add each product
	    for (String productName : productNames)
	    {
	        driver.get("https://www.demoblaze.com/");

	        hp.clickProduct(productName);

	        cp.addToCart();
	        cp.handleAddToCartAlert();

	        System.out.println("Added to cart: " + productName);
	    }
	    cp.clickCart();
	    Thread.sleep(5000);

	    if (cp.getCartProductCount() == productNames.size())
	    {
	        test.pass("All products were added to cart successfully.");
	    }
	    else
	    {
	        test.fail(
	            "Expected " + productNames.size()
	            + " products, but found "
	            + cp.getCartProductCount()
	            + " products in cart."
	        );

	        String screenshotName = "Add To Cart Verification";
	        ReporterClass.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(
	                "screenshot\\" + screenshotName + ".png"
	        );
	    }	    
	    
       }
	@Test(priority=2)
	public void PlaceOrder() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("Order Place Verification :-");
		 WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(20));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
        cp=new CartPage(driver);
		lp.openLogin();
		
		lp.Login("archa", "anju123");

		lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	    WebElement placeOrder=cp.PlaceOrderForm();
	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();
	    
	    wait.until(ExpectedConditions.urlContains("cart.html"));
	    
	    cp.openOrder();
	    
	    wait.until(ExpectedConditions.visibilityOf(
	    		placeOrder ));
			   boolean result = cp.ValidOrderDetails();

			    if (result)
			    {
			        test.pass("Order placed  successfully");
			    }
			    else
			    {
			        test.fail("Order not placed ");
			        String screenshotName = "Order Place Verification" ;

		            ReporterClass.screenshotMethod(driver, screenshotName);

		            test.addScreenCaptureFromPath(
		                    "screenshot\\" + screenshotName + ".png"
		            );


				    Assert.assertTrue(result, "Order not placed");

			    }

				 

			  
			}
			   
	@Test(priority=3)
	public void CheckPrice() throws InterruptedException, IOException {

	    driver.get("https://www.demoblaze.com/");
	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(20));
	    test = extent.createTest("Cart Amount Verification :-");

	    lp = new LoginPage(driver);
	    cp = new CartPage(driver);

        lp.openLogin();
		
		lp.Login("archa", "anju123");

		lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	  //  WebElement placeOrder=cp.PlaceOrderForm();
	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();
	    wait.until(ExpectedConditions.urlContains("cart.html"));



	    boolean result = cp.CheckAmount();

	    if (result) {

	        test.pass("Cart amount and Order amount are equal.");

	    } else {

	        test.fail("Cart amount and Order amount are NOT equal.");
			 
	            String screenshotName = "Cart Amount Verification" ;

	            ReporterClass.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(
	                    "screenshot\\" + screenshotName + ".png"
	            );

	            Assert.fail("Cart Amount Verification Failed  ");

	        Assert.fail(
	                "Cart amount and Order amount are different."
	        );
	    }
	}


	@Test(priority=4)
	public void RemoveItem() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("Remove Items from cart Verification :-");
		 WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(20));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
        cp=new CartPage(driver);
		lp.openLogin();
		lp.Login("archa", "anju123");

		lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	  //  WebElement placeOrder=cp.PlaceOrderForm();
	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();
	    wait.until(ExpectedConditions.urlContains("cart.html"));


		    int initialCount = cp.getCartProductCount();

		    System.out.println("Initial cart count: " + initialCount);

		    Assert.assertTrue(initialCount > 0,
		            "Cart is empty. No products available.");

		    cp.removeAllItems();

		    int finalCount = cp.getCartProductCount();

		    System.out.println("Final cart count: " + finalCount);

		    Assert.assertEquals(finalCount, 0,
		            "All products were not removed.");
		    if(finalCount == 0)
		    {
		    	test.pass("All products removed successfully from cart.");
		    }
		    else
		    {
		    	test.fail("Remove Items from cart Verification Failed:All products are not removed  from cart ");
				 
 	            String screenshotName = "Remove Items from cart Verification" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Remove Items from cart Verification Failed  ");
		    }
	
	



		
	}
	
	@Test()
	
	public void VerifyLabels() throws InterruptedException, IOException {
		
			    driver.get("https://www.demoblaze.com/");
		
			    test = extent.createTest("Place Order Form Label Verification :-");
			    WebDriverWait wait =
			            new WebDriverWait(driver, Duration.ofSeconds(20));

			    lp = new LoginPage(driver);
			    cp = new CartPage(driver);
		
			    lp.openLogin();
			    lp.Login("archa", "anju123");
				lp.submitLoginForm();
			    WebElement username=lp.LoggedInUsername();
			    WebElement loginform=lp.loginform();
			    WebElement placeOrder=cp.PlaceOrderForm();

			    wait.until(ExpectedConditions.visibilityOf(
			            username
			    ));

			    wait.until(ExpectedConditions.invisibilityOf(
			    		loginform
			    ));

			    cp.clickCart();

			    cp.openOrder();
			    
			    wait.until(ExpectedConditions.visibilityOf(
			    		placeOrder
			    ));
			    WebElement name=cp.nameLabel();
			    WebElement country=cp.countryLabel();
			    WebElement credit=cp.creditLabel();
			    WebElement month=cp.monthLabel();
			    WebElement city=cp.cityLabel();
			    WebElement year=cp.yearLabel();
			   
			    
			    if(name.getText().equals("Name:") && name.isDisplayed())
			    {
					test.pass("Name textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Name Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Name Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Name  Label Verification Failed  ");
			    }
			    
			    if(country.getText().equals("Country:") && country.isDisplayed())
			    {
					test.pass("Country textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Country Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Country Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Country  Label Verification Failed  ");
			    }
			    
			    if(credit.getText().equals("Credit card:") && credit.isDisplayed())
			    {
					test.pass("Credit card textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Credit card Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Credit card Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Credit card  Label Verification Failed  ");
			    }
			    
			    if(month.getText().equals("Month:") && month.isDisplayed())
			    {
					test.pass("Month textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Month Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Month Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Month  Label Verification Failed  ");
			    }
			    
			    if(year.getText().equals("Year:") && year.isDisplayed())
			    {
					test.pass("Year textbox label verified");
			    }
			    else
			    {
			    	 test.fail("Year Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "Year Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("Year  Label Verification Failed  ");
			    }
			    
			    if(city.getText().equals("City:") && city.isDisplayed())
			    {
					test.pass("City textbox label verified");
			    }
			    else
			    {
			    	 test.fail("City Label Verification Failed:Label is not correct ");
					 
		 	            String screenshotName = "City Label Verification:" ;
		 
		 	            ReporterClass.screenshotMethod(driver, screenshotName);
		 
		 	            test.addScreenCaptureFromPath(
		 	                    "screenshot\\" + screenshotName + ".png"
		 	            );
		 
		 	            Assert.fail("City  Label Verification Failed  ");
			    }


		
			}
	@Test()
	public void VerifyTextbox() throws InterruptedException, IOException
	{
		 driver.get("https://www.demoblaze.com/");
			
		    test = extent.createTest("Place Order Form Textbox Verification :-");
		    WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(20));
		    lp = new LoginPage(driver);
		    cp = new CartPage(driver);
	
		    lp.openLogin();
		    lp.Login("archa", "anju123");
	
		    lp.submitLoginForm();
		    WebElement username=lp.LoggedInUsername();
		    WebElement loginform=lp.loginform();
		    WebElement placeOrder=cp.PlaceOrderForm();

		    wait.until(ExpectedConditions.visibilityOf(
		            username
		    ));

		    wait.until(ExpectedConditions.invisibilityOf(
		    		loginform
		    ));

		    cp.clickCart();

		    cp.openOrder();
		    
		    wait.until(ExpectedConditions.visibilityOf(
		    		placeOrder
		    ));
		    
		    WebElement nametxt=cp.nametextbox();
		    WebElement countrytxt=cp.countrytextbox();
		    WebElement credittxt=cp.credittextbox();
		    WebElement monthtxt=cp.monthtextbox();
		    WebElement citytxt=cp.citytextbox();
		    WebElement yeartxt=cp.yeartextbox();
		    
		    if(nametxt.isDisplayed())
			{
				test.pass("Name textbox  is displayed ");

			}
			else
			{
				 test.fail("Name textbox Verification Failed: Textbox is not displayed");
				 
				 	            String screenshotName = "Name textbox Verification :" ;
				 
				 	            ReporterClass.screenshotMethod(driver, screenshotName);
				 
				 	            test.addScreenCaptureFromPath(
				 	                    "screenshot\\" + screenshotName + ".png"
				 	            );
				 
				 	            Assert.fail("Name textbox Verification ");
			}
		    
		    if(countrytxt.isDisplayed())
			{
				test.pass("Country textbox  is displayed");

			}
			else
			{
				 test.fail("Country textbox Verification Failed: Textbox is not displayed");
				 
				 	            String screenshotName = "Country textbox Verification :" ;
				 
				 	            ReporterClass.screenshotMethod(driver, screenshotName);
				 
				 	            test.addScreenCaptureFromPath(
				 	                    "screenshot\\" + screenshotName + ".png"
				 	            );
				 
				 	            Assert.fail("Country textbox Verification ");
			}
		    
		    if(credittxt.isDisplayed())
			{
				test.pass("Credit card textbox  is displayed");

			}
			else
			{
				 test.fail("Credit card textbox Verification Failed: Textbox is not displayed");
				 
				 	            String screenshotName = "Credit card textbox Verification :" ;
				 
				 	            ReporterClass.screenshotMethod(driver, screenshotName);
				 
				 	            test.addScreenCaptureFromPath(
				 	                    "screenshot\\" + screenshotName + ".png"
				 	            );
				 
				 	            Assert.fail("Credit card textbox Verification ");
			}
		    
		    if(monthtxt.isDisplayed())
			{
				test.pass("Month textbox  is displayed");

			}
			else
			{
				 test.fail("Month textbox Verification Failed: Textbox is not displayed");
				 
				 	            String screenshotName = "Month textbox Verification :" ;
				 
				 	            ReporterClass.screenshotMethod(driver, screenshotName);
				 
				 	            test.addScreenCaptureFromPath(
				 	                    "screenshot\\" + screenshotName + ".png"
				 	            );
				 
				 	            Assert.fail("Month textbox Verification ");
			}
		    
		    if(citytxt.isDisplayed())
			{
				test.pass("City textbox  is displayed");

			}
			else
			{
				 test.fail("City textbox Verification Failed: Textbox is not displayed");
				 
				 	            String screenshotName = "City textbox Verification :" ;
				 
				 	            ReporterClass.screenshotMethod(driver, screenshotName);
				 
				 	            test.addScreenCaptureFromPath(
				 	                    "screenshot\\" + screenshotName + ".png"
				 	            );
				 
				 	            Assert.fail("City textbox Verification ");
			}
		    if(yeartxt.isDisplayed())
			{
				test.pass("Year textbox  is displayed");

			}
			else
			{
				 test.fail("Year textbox Verification Failed: Textbox is not displayed");
				 
				 	            String screenshotName = "Year textbox Verification :" ;
				 
				 	            ReporterClass.screenshotMethod(driver, screenshotName);
				 
				 	            test.addScreenCaptureFromPath(
				 	                    "screenshot\\" + screenshotName + ".png"
				 	            );
				 
				 	            Assert.fail("Year textbox Verification ");
			}
	}
	@Test()
	public void VerifyButtons() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		test= extent.createTest("Place Order buttons Verification :-");
		  WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(20));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
         cp=new CartPage(driver);
		lp.openLogin();
		
		lp.Login("archa", "anju123");

		 lp.submitLoginForm();
		    WebElement username=lp.LoggedInUsername();
		    WebElement loginform=lp.loginform();
		    WebElement placeOrder=cp.PlaceOrderForm();



		    wait.until(ExpectedConditions.visibilityOf(
		            username
		    ));

		    wait.until(ExpectedConditions.invisibilityOf(
		    		loginform
		    ));

		    cp.clickCart();

		   // cp.openOrder();
		    // Wait for Place Order button
		    WebElement orderbtn = wait.until(
		            ExpectedConditions.elementToBeClickable(
		                   cp.placeOrderbtn()));

		    orderbtn.click();
		    wait.until(ExpectedConditions.visibilityOf(
		    		placeOrder
		    ));
		    if(orderbtn.isDisplayed() && orderbtn.isEnabled())
		    {
				test.pass("Place order button  is displayed and enabled");

		    	if(orderbtn.getText().equals("Place Order"))
		    	{
					test.pass("Place order button label  is  correct");

		    	}
		    	else
		    	{
		    		test.fail("Place order button label : Button label  is not  correct");
					 
	 	            String screenshotName = "Place order button Verification" ;
	 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Place order button Verification ");
		    	}
		    }
		    else
		    {
		    	test.fail("Place order button  : Button   is not   displayed and enabled");
				 
 	            String screenshotName = "Place order button Verification :" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Place order button Verification ");
	    	
		    }
		  //  orderbtn.click();
		     wait.until(
		            ExpectedConditions.visibilityOf(
		            		placeOrder));
		    WebElement closebtn = cp.closebtn();

		    wait.until(ExpectedConditions.visibilityOf(closebtn));

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
		    WebElement purchasebtn=cp.purchasebtn();

		    wait.until(ExpectedConditions.visibilityOf(purchasebtn));

		    if(purchasebtn.isDisplayed() && purchasebtn.isEnabled())
		    {
				test.pass("Purchase button  is displayed and enabled");

		    	if(purchasebtn.getText().equals("Purchase"))
		    	{
					test.pass("Purchase button label  is  correct");

		    	}
		    	else
		    	{
		    		test.fail("Purchase button label : Button label  is not  correct");
					 
	 	            String screenshotName = "Purchase button Verification :" ;
	 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Purchase button Verification ");
		    	}
		    }
		    else
		    {
		    	test.fail("Purchase button  : Button   is not   displayed and enabled");
				 
 	            String screenshotName = "Purchase button Verification" ;
 
 	            ReporterClass.screenshotMethod(driver, screenshotName);
 
 	            test.addScreenCaptureFromPath(
 	                    "screenshot\\" + screenshotName + ".png"
 	            );
 
 	            Assert.fail("Purchase button Verification ");
	    	
		    }
		    

	}
	
	@Test()
	public void VerifyInvalidData() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("Invalid Data Verification :-");
		 WebDriverWait wait =
		            new WebDriverWait(driver, Duration.ofSeconds(20));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
        cp=new CartPage(driver);
		lp.openLogin();
		
		lp.Login("archa", "anju123");
		lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	    WebElement placeOrder=cp.PlaceOrderForm();

	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();

	    cp.openOrder();
	    
	    wait.until(ExpectedConditions.visibilityOf(
	    		placeOrder
	    ));
			  
			   boolean result = cp.InvalidOrderDetails();

			    if (!result)
			    {
			        test.pass("Invalid data are not accept");
			    }
			    else
			    {
			        test.fail(" Invalid data are accept");
			        String screenshotName = "Invalid data Verification" ;
					 
	 	            ReporterClass.screenshotMethod(driver, screenshotName);
	 
	 	            test.addScreenCaptureFromPath(
	 	                    "screenshot\\" + screenshotName + ".png"
	 	            );
	 
	 	            Assert.fail("Invalid data are accept  ");
			    }

			    Assert.assertTrue(result, "Invalid data are accept");
				 

			  
			}		 
	@Test()
	public void VerifyNullData() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("Null Data Verification :-");
		 WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(10));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
        cp=new CartPage(driver);
		lp.openLogin();
		
		lp.Login("archa", "anju123");

		lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	    WebElement placeOrder=cp.PlaceOrderForm();

	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    System.out.println("Logged in successfully: "
	            + username.getText());
	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();

	    cp.openOrder();
	    
	    wait.until(ExpectedConditions.visibilityOf(
	    		placeOrder
	    ));;
			 cp.NullvaluesOrderDetails();
			 
	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 String message = alert.getText();
	    System.out.println("Null Alert: " + message);
			   
	    if (message.equals("Please fill out Name and Creditcard.")) {

	        test.pass("Validation alert displayed for empty Name and Credit Card");

	    } else {

	        test.fail("Null data are accept: " + message);
	        String screenshotName = "Null data Verification" ;
			 
	            ReporterClass.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(
	                    "screenshot\\" + screenshotName + ".png"
	            );

	            Assert.fail("Null data are accept  ");
	    }

		 
	    alert.accept();

	    Assert.assertEquals(
	            message,
	            "Please fill out Name and Creditcard.",
	            "Incorrect validation alert message"
	    );		        

			  
			}
	
	@Test()
	public void VerifyMandatoryFieldData() throws InterruptedException, IOException
	{
		driver.get("https://www.demoblaze.com/");
		 test= extent.createTest("Null data expect name and credit card field Verification :-");
		 WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(10));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
        cp=new CartPage(driver);
        lp.openLogin();
		
		lp.Login("archa", "anju123");

        lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	    WebElement placeOrder=cp.PlaceOrderForm();

	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    System.out.println("Logged in successfully: "
	            + username.getText());
	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();

	    cp.openOrder();
	    
	    wait.until(ExpectedConditions.visibilityOf(
	    		placeOrder
	    ));;
			  
	    cp.ValidWithMandatoryField();
			   
	  

	    if (!cp.ValidWithMandatoryField()) {
	        test.pass("Null data expect name and credit card field are not accept");
	    } 
	    else 
	    {
	        test.fail("Null data expect name and credit card field are accepted ");

	        String screenshotName = "Mandatory_Field_Verification";
	        ReporterClass.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(
	                "screenshot\\" + screenshotName + ".png");

	    }

	    

				 }
	@Test()
	public void VerifyPlaceOrderWithEmptyCart() throws InterruptedException, IOException
	{
	    test = extent.createTest("Place Order With Empty Cart Verification ");
	    driver.get("https://www.demoblaze.com/");
	    WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
		 lp=new LoginPage(driver);
		 hp = new HomePage(driver);
       cp=new CartPage(driver);
       lp.openLogin();
		
		lp.Login("archa", "anju123");

       lp.submitLoginForm();
	    WebElement username=lp.LoggedInUsername();
	    WebElement loginform=lp.loginform();
	    WebElement placeOrder=cp.PlaceOrderForm();
        WebElement cart=cp.CartAll();
	    wait.until(ExpectedConditions.visibilityOf(
	            username
	    ));

	    System.out.println("Logged in successfully: "
	            + username.getText());
	    wait.until(ExpectedConditions.invisibilityOf(
	    		loginform
	    ));

	    cp.clickCart();

	    
	    wait.until(ExpectedConditions.urlContains("cart.html"));


	    // Verify empty cart and Place Order 
	    boolean result = cp.PlaceOrderWithEmptyCart();

	    if (result)
	    {
	        test.pass("User cannot place an order when cart is empty");

	    }
	    else
	    {
	        test.fail("Place Order modal is displayed even though cart is empty");
	        String screenshotName = "cart is empty" ;
			 
	            ReporterClass.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(
	                    "screenshot\\" + screenshotName + ".png"
	            );

	        Assert.fail("User should not be able to place an order with an empty cart");
	    }
	}
}