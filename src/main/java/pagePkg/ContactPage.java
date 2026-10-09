package pagePkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

	@FindBy(linkText = "Contact")
	WebElement contactlink;
	
	@FindBy(id="exampleModal")
	WebElement contactForm;
	
	@FindBy(id="exampleModalLabel")
	WebElement label;
	
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[1]/button")
	WebElement closeicon;
	
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[1]/label")
	
	WebElement email_label;
	
	@FindBy(id="recipient-email")
	
	WebElement emailtxtbox;
	
    @FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[2]/label")
	
	WebElement name_label;
	
	@FindBy(id="recipient-name")
	
	WebElement nametxtbox;
	
   @FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[3]/label")
	
	WebElement message_label;
	
	@FindBy(id="message-text")
	
	WebElement messagetxtbox;
	
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")
	
	WebElement closebtn;
	
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")
	
	WebElement sendbtn;
	
	WebDriver driver;
    WebDriverWait wait;


	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	
	//email field 
	 
	 public WebElement emailLabel()
	 {
		return email_label;
		 
		 
	 }
	 
	 public WebElement emailtextbox()
	 {
		return emailtxtbox;
		 
		 
	 }
	 
	 
	//name field 
	 
	 public WebElement nameLabel()
	 {
		return name_label;
		 
		 
	 }
	 
	 public WebElement nametextbox()
	 {
		return nametxtbox;
		
		  
	 }
	 
	//message field 
	 
		 public WebElement messageLabel()
		 {
			return message_label;
			 
			 
		 }
		 
		 public WebElement messagetextbox()
		 {
			return messagetxtbox;
			
			  
		 }
		 
 //button verification
		 
		
		 public WebElement sendbtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(sendbtn));
			 
		 }
		  
		 public void submitContactForm() 
		 {
		        wait.until(ExpectedConditions.elementToBeClickable(sendbtn)).click();
		 }
		 public WebElement closebtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(closebtn));
			 
		 }
		
	
	//open contact
	
	 public void openContact() {

	        wait.until(
	                ExpectedConditions.elementToBeClickable(contactlink)
	        ).click();
	        
	        wait.until(
	                ExpectedConditions.visibilityOf(contactForm)
	            );
	    }
	
	 //close contact
	 
	 public void closeContact()
	 {
		 wait.until(
	                ExpectedConditions.elementToBeClickable(closeicon)

				 
				 ).click();
	 }
	 
 // Verify contact Popup
	 
	 public boolean isContactPopupDisplayed() 
	 
	 {

	        try {
	            return wait.until(
	                    ExpectedConditions.visibilityOf(contactForm))
	                    .isDisplayed();

	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 //valid data
	 
	 public boolean validContactDetails()
	 {
		 
		 try
		 {
			 emailtxtbox.sendKeys("anjanas1997@gmail.com");
			 nametxtbox.sendKeys("Anjana");
			 messagetxtbox.sendKeys("I want to know my order details");
			 sendbtn.click();
	         return true;

		 }
		 catch(Exception e)
		 {
	         return false;

		 }


		 
	 }
	 
 //invalid data
	 
	 public boolean InvalidContactDetails()
	 {
		 
		 try
		 {
			 emailtxtbox.sendKeys("anjanas1997gmail.com");
			 nametxtbox.sendKeys("Anjana");
			 messagetxtbox.sendKeys("I want to know my order detailssssssssssssssssssss");
	         return true;

		 }
		 catch(Exception e)
		 {
	         return false;

		 }


		 
	 }
 //null data
	 
	 public boolean NullContactDetails()
	 {
		 
		 try
		 {
			 emailtxtbox.sendKeys("");
			 nametxtbox.sendKeys("");
			 messagetxtbox.sendKeys("");
	         return true;

		 }
		 catch(Exception e)
		 {
	         return false;

		 }


		 
	 }
	
}
