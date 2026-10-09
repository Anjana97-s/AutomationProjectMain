package pagePkg;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy(xpath="//*[@id=\"nava\"]/img")
	WebElement logo;
	
	@FindBy(linkText = "Home")
	WebElement homelink;
	
	@FindBy(linkText = "Contact")
	WebElement contactlink;
	
	@FindBy(linkText = "About us")
	WebElement  Aboutslink;
	
	@FindBy(linkText = "Cart")
	WebElement cartlink;
	
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	@FindBy(linkText = "Sign up")
	WebElement signuplink;
	
	@FindBy(css = "a.carousel-control-prev")
	 WebElement carouselprev;
	
	@FindBy(css = "a.carousel-control-next")
	 WebElement carouselnext;
	
	
	@FindBy(css = "#itemc")
	List<WebElement> categories;
	
	
	@FindBy(id="prev2")
	WebElement previousbtn;
	
	@FindBy(xpath="//*[@id=\"next2\"]")
	WebElement nextbtn;
	
	@FindBy(css = ".card-title a")
	List<WebElement> items;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")
	WebElement Addtocart;
	
	@FindBy(xpath = "//a[text()='Phones']")
	WebElement phones;

	@FindBy(xpath = "//a[text()='Laptops']")
	WebElement laptops;

	@FindBy(xpath = "//a[text()='Monitors']")
	WebElement monitors;

	@FindBy(css = ".card.h-100")
	List<WebElement> products;
	
	@FindBy(xpath="//*[@id=\"navbarExample\"]")
	List<WebElement> navbarLinks;

	
	WebDriver driver;
    WebDriverWait wait;
	Actions ob;

	

	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ob=new Actions(driver);
		PageFactory.initElements(driver, this);



	}
	
	//logo
	public WebElement logo()
	{
		return logo;
		
	}
	
	//navbarlinks
	public  List<WebElement> navbarLink()
	{
		return navbarLinks;
		
	}
	//categoryNames
	public List<String> categoryNames()
	{
	    List<String> names = new ArrayList<>();

	    for(WebElement ele : categories)
	    {
	        names.add(ele.getText());
	    }

	    return names;
	}
	//getCategory
	 public WebElement getCategory(String categoryName) {

	        return driver.findElement(
	            By.xpath("//a[@id='itemc' and normalize-space()='" 
	                     + categoryName + "']")
	        );
	    }
	 // Click category
	    public void clickCategory(String categoryName) {

	        getCategory(categoryName).click();
	    }

	//products
		public List<WebElement> products()
		{
		    return products;
		}
		
//	//items
//		public List<WebElement> items()
//		{
//			 return wait.until(
//		            ExpectedConditions.visibilityOfAllElements(items)
//			        );	
//		}
		
		//
		public List<WebElement> getProducts()
		{
		    return wait.until(ExpectedConditions.visibilityOfAllElements(
		    		items
		    ));
		}
		
		//clickProduct dynamic

		public void clickProduct(String productName)
		{
			String clickprdt = "//a[@class='hrefch' and normalize-space()='";

		    wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath(clickprdt + productName + "']")
		    )).click();
		}

	//phones
	
	public WebElement phones()
	{
		return phones;
		
	}

	//laptops
	
	public WebElement laptops()
	{
		return laptops;
	}
	
	// monitors
	public WebElement monitors()
	{
		return monitors;
	}
	
    //previousbtn
	public WebElement previousbtn()
	{
		return wait.until(
	            ExpectedConditions.visibilityOf(previousbtn)
	        );	
		}
	//clickpreviousbtn
	public void clickPrevious() {
		 wait.until(ExpectedConditions.elementToBeClickable(previousbtn)).click();
		
	}
	//clicknextbtn
		public void clickNext() {
			 wait.until(ExpectedConditions.elementToBeClickable(nextbtn)).click();
			
		}
	
	 //nextbtn
	public WebElement nextbtn()
	{
		return wait.until(
	            ExpectedConditions.visibilityOf(nextbtn)
	        );         
	}
	
	 //carouselprev
		public WebElement carouselprev()
		{
			return wait.until(ExpectedConditions.elementToBeClickable(carouselprev));

					
		}
		
	 //carouselnext
		public WebElement carouselnext()
		{
		  return wait.until(ExpectedConditions.elementToBeClickable(carouselnext));

		}
	
		//slide
		public String getActiveSlide() 
		{
			 return wait.until(
				        ExpectedConditions.visibilityOfElementLocated(
				                By.cssSelector(
				                    "#carouselExampleIndicators .carousel-item.active img"
				                )
				            )
				        ).getAttribute("src");
		}
}
