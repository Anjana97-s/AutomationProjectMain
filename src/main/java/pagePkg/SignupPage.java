package pagePkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	@FindBy(linkText = "Sign up")
	WebElement signuplink;
	
	@FindBy(id="signInModal")
	WebElement signInForm;
	
	@FindBy(id="signInModalLabel")
	WebElement label;
	
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[1]/button")
	WebElement closeicon;
	
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[2]/form/div[1]/label")
	
	WebElement usrname_label;
	
	@FindBy(id = "sign-username")
	
	WebElement usrnametxtbox;
	
    @FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[2]/form/div[2]/label")
	
	WebElement pass_label;
	
	@FindBy(id = "sign-password")
	
	WebElement passtxtbox;
	
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
	
	WebElement closebtn;
	
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
	
	WebElement signupbtn;
	
	WebDriver driver;
    WebDriverWait wait;


	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	//Signup
	
	public void Signup(String username,String password)
	{
		 wait.until(
		            ExpectedConditions.visibilityOf(usrnametxtbox)
		        ).sendKeys(username);

		        wait.until(
		            ExpectedConditions.visibilityOf(passtxtbox)
		        ).sendKeys(password);

		        wait.until(
		            ExpectedConditions.elementToBeClickable(signupbtn)
		        ).click();
	}
	
	
	
	//open signup
	
	 public void openSign() {

	        wait.until(
	                ExpectedConditions.elementToBeClickable(signuplink)
	        ).click();
	        
	        wait.until(
	                ExpectedConditions.visibilityOf(signInForm)
	            );
	    }
	 
	 //close signup
	 
	 public void closeSign()
	 {
		 wait.until(
	                ExpectedConditions.elementToBeClickable(closeicon)

				 
				 ).click();
	 }
	 
	  public boolean isSignupPopupDisplayed() 
		 
		 {

		        try {
		            return wait.until(
		                    ExpectedConditions.visibilityOf(signInForm))
		                    .isDisplayed();

		        } catch (Exception e) {
		            return false;
		        }
		    }
	 //Username field
	 public WebElement UsernameLabel()
	 {
		return usrname_label;
		 
	 }
	 public WebElement UsernameTextbox()
	 {
		return usrnametxtbox;
			 
	 }
	 
	 //Password field
	 public WebElement PasswordLabel()
	 {
		return pass_label;
		
		 
	 }
	 public WebElement PasswordTextbox()
	 {
		return passtxtbox;
			 
	 }
	 
	 public WebElement closebtn()
	 {
		 
		return wait.until(ExpectedConditions.elementToBeClickable(closebtn));
		 
	 }
	 
	 public WebElement signupbtn()
	 {
		 
		return wait.until(ExpectedConditions.elementToBeClickable(signupbtn));
		 
	 }
	  
	 public void submitContactForm() 
	 {
	        wait.until(ExpectedConditions.elementToBeClickable(signupbtn)).click();
	 }
	 
	 
	
	
}
