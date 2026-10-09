package pagePkg;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	@FindBy(id = "cartur")
	WebElement cartlink;
	
	@FindBy(xpath ="//a[normalize-space()='Add to cart']")
	WebElement addcart;
	
	@FindBy(xpath = "//button[@data-target='#orderModal']")
	WebElement placeorder;
	
	//placeorderForm
	
	@FindBy(id="orderModal")
	WebElement placeorderForm;
	
	//before place order btn 
	
	@FindBy(xpath="//*[@id=\"totalp\"]")
	WebElement totalp;
	
	//after place order btn 

	@FindBy(xpath="//*[@id=\"totalm\"]")
	WebElement totala;
	
	@FindBy(xpath = "//*[@id='tbodyid']/tr/td/a[normalize-space()='Delete']")
	List<WebElement> deleteLinks;
	
	
	
    //	label
	@FindBy(id="orderModalLabel")
	WebElement placeorderLabel;
	
	
	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div/form/div")
    List<WebElement> textbox_group;

	@FindBy(xpath = "//*[@id=\"tbodyid\"]/tr")
	
    List<WebElement> cartprdt;
	
	@FindBy(id="tbodyid")
	WebElement cartAll;

	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[2]/form/div[1]/label")
	WebElement nameLabel;
	
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[2]/form/div[2]/label")
	WebElement countryLabel;
	
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[2]/form/div[3]/label")
	WebElement cityLabel;
	
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[2]/form/div[4]/label")
	WebElement creditLabel;
	
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[2]/form/div[5]/label")
	WebElement monthLabel;
	
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[2]/form/div[6]/label")
	WebElement yearLabel;
	
	@FindBy(xpath = "//*[@id=\"name\"]")
	WebElement name;
	
	@FindBy(xpath ="//*[@id=\"country\"]")
	WebElement country;
	
	@FindBy(xpath ="//*[@id=\"city\"]")
	WebElement city;
	
	@FindBy(xpath ="//*[@id=\"card\"]")
	WebElement credit;
	
	@FindBy(xpath ="//*[@id=\"month\"]")
	WebElement month;
	
	@FindBy(xpath ="//*[@id=\"year\"]")
	WebElement year;
	
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
	WebElement closebtn;
	@FindBy(xpath ="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	WebElement purchasebtn;
	@FindBy(xpath = "//div[@id='orderModal']//button[@class='close']")
	WebElement closeicon;
	
	
	
	WebDriver driver;
    WebDriverWait wait;
	Actions ob;

	public CartPage(WebDriver driver)
	{
		this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ob=new Actions(driver);
		PageFactory.initElements(driver, this);


	}
	
	//name field 
	 
		 public WebElement nameLabel()
		 {
			return nameLabel;
			 
			 
		 }
		 
		 public WebElement nametextbox()
		 {
			return name;
			 
			 
		 }
		 
		 //country field 

		 public WebElement countryLabel()
		 {
			return countryLabel;
			 
			 
		 }
		 
		 public WebElement countrytextbox()
		 {
			return country;
			 
			 
		 }
		 
		 //city field 

		 public WebElement cityLabel()
		 {
			return cityLabel;
			 
			 
		 }
		 
		 public WebElement citytextbox()
		 {
			return city;
			 
			 
		 }
		 
		 //credit field 

		 public WebElement creditLabel()
		 {
			return creditLabel;
			 	 
		 }
		 
		 public WebElement credittextbox()
		 {
			return credit;
			 
			 
		 }
		 
		 //month field 

		 public WebElement monthLabel()
		 {
			return monthLabel;
			 	 
		 }
		 
		 public WebElement monthtextbox()
		 {
			return month;
			 
			 
		 }
		 
		 //year field 

		 public WebElement yearLabel()
		 {
			return yearLabel;
			 	 
		 }
		 
		 public WebElement  yeartextbox()
		 {
			return  year;
			 
			 
		 }
		 //button verification
		 
		 public  WebElement orderbtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(placeorder));
			 
		 }
		 public WebElement purchasebtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(purchasebtn));
			 
		 }
		 public WebElement closebtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(closebtn));
			 
		 }
		 public WebElement CartAll()
		 {
			return cartAll;
			 	 
		 }
		 public WebElement PlaceOrderForm()
		 {
			return placeorderForm;
	            
			 	 
		 }
		 
		
	//cartlink
	
	public void clickCart() throws InterruptedException 
	{
	//	cartlink.click();
		wait.until(
		        ExpectedConditions.elementToBeClickable(cartlink)
		    ).click();
	}
	
	 // Click first Delete button
    public void clickFirstDelete() 
    {

        List<WebElement> deleteButtons = deleteLinks;

        if (!deleteButtons.isEmpty()) 
        {
            deleteButtons.get(0).click();
        }
    }

 // Remove all products
    public void removeAllItems() throws InterruptedException 
    {


	    while (true) {

	        // Find delete links again after every deletion
		    List<WebElement> rows = cartprdt;

            System.out.println("Cart rows found: " + rows.size());

            if (rows.isEmpty()) {
                break;
            }

            WebElement firstRow = rows.get(0);

            clickFirstDelete();

            try {
                wait.until(ExpectedConditions.stalenessOf(firstRow));
            } catch (Exception e) {
                Thread.sleep(1000);
            }

            Thread.sleep(5000);
	    }
	}
	//cart count
	public int getCartProductCount() 
	{


	    List<WebElement> rows = cartprdt;

	    return rows.size();
	}
	//cart-prdt
	
	public List<WebElement> cart_product()
	{
		return  wait.until(
	                ExpectedConditions.visibilityOfAllElements(cartprdt)
	            );
		
	}
	//prod_list
	public void addToCart()
	{
	    wait.until(ExpectedConditions.elementToBeClickable(
	           addcart
	    )).click();
	}

	public void handleAddToCartAlert()
	{
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}
	
	//place order btn
	public WebElement placeOrderbtn()
	{
	    return wait.until(ExpectedConditions.elementToBeClickable(placeorder));

	}
	//open place order modal
	 public void openOrder() {

	        wait.until(
	                ExpectedConditions.elementToBeClickable(placeorder)
	        ).click();
	        
	        wait.until(
	                ExpectedConditions.visibilityOf(placeorderForm)
	            );
	    }
	 
	  // Verify Place Order Popup
	 
	 public boolean isOrderPopupDisplayed() 
	 {

	        try {
	            return wait.until(
	                    ExpectedConditions.visibilityOf(placeorderForm))
	                    .isDisplayed();

	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 //close place order modal
	 
	 public void closeOrder()
	 {
		 wait.until(
	                ExpectedConditions.elementToBeClickable(closeicon)

				 
				 ).click();
	 }
	 
	//  amount  in Cart
	    public String getCartAmount() {

	        wait.until(ExpectedConditions.visibilityOf(totalp));

	        return totalp.getText().trim();
	    }
	    
	    // Get amount  in Order 
	    public String getOrderAmount() {

	        wait.until(ExpectedConditions.visibilityOf(totala));

	        return totala.getText().trim();
	    }
	    
	    // Click Place Order button
	    public void clickPlaceOrder() {

	        wait.until(ExpectedConditions.elementToBeClickable(placeorder));

	        placeorder.click();
	        wait.until(ExpectedConditions.visibilityOf(
	        		placeorderForm ));
	    }


	 // Compare Cart amount and Order amount
	    public boolean CheckAmount() 
	    {

	        try {

	            String cartAmount = getCartAmount();
	            
	            clickPlaceOrder();

	            String orderAmount = getOrderAmount();
	            orderAmount = orderAmount.replace("Total:", "").trim();


	            System.out.println("Cart Amount  : " + cartAmount);
	            System.out.println("Order Amount : " + orderAmount);

	            return cartAmount.equals(orderAmount);

	        } catch (Exception e) {

	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	
	 
	 //vaild details
	 public boolean ValidOrderDetails()
	 {
	     try
	     {
	         name.sendKeys("Anjana");
	         country.sendKeys("India");
	         city.sendKeys("Kochi");
	         credit.sendKeys("411111111111111");
	         month.sendKeys("10");
	         year.sendKeys("2026");

	         purchasebtn.click();

	         return true;
	     }
	     catch (Exception e)
	     {
	         return false;
	     }
	 }
	 
	 //vaild details
	 public boolean ValidWithMandatoryField()
	 {
	     try
	     {
	         name.sendKeys("Anjana");
	         country.sendKeys("");
	         city.sendKeys("");
	         credit.sendKeys("411111111111111");
	         month.sendKeys("");
	         year.sendKeys("");

	         purchasebtn.click();

	         return true;
	     }
	     catch (Exception e)
	     {
	         return false;
	     }
	 }
	 //invalid details
	 public boolean InvalidOrderDetails()
	 {
		 System.out.println("InvalidOrderDetails");
	     try
	     {
	    	 name.sendKeys("12345");              // Invalid name
	    	 country.sendKeys("12345");           // Invalid country
	    	 city.sendKeys("12345");              // Invalid city
	    	 credit.sendKeys("123");              // Invalid/short card number
	    	 month.sendKeys("15");                // Invalid month
	    	 year.sendKeys("2020");               // Expired year
	         purchasebtn.click();

	         return true;
	     }
	     catch (Exception e)
	     {
	         return false;
	     }
	 }
	 
	//null details
		 public boolean NullvaluesOrderDetails()
		 {
			 System.out.println("InvalidOrderDetails");
		     try
		     {
		    	 name.sendKeys("");
		    	 country.sendKeys("");
		    	 city.sendKeys("");
		    	 credit.sendKeys("");
		    	 month.sendKeys("");
		    	 year.sendKeys("");
		         purchasebtn.click();

		         return true;
		     }
		     catch (Exception e)
		     {
		         return false;
		     }
		 }
		 
		 
		 
		 
		 public boolean PlaceOrderWithEmptyCart()
		 {
		     // Check whether cart is empty
		     List<WebElement> products =cartprdt;

		     if (products.isEmpty())
		     {
		         System.out.println("Cart is empty");

		         // Try clicking Place Order
		         placeorder.click();

		         // Check whether order modal is displayed
		         return placeorderForm.isDisplayed();
		     }

		     return false;
		 }
		 
	  
	 
	 
}
