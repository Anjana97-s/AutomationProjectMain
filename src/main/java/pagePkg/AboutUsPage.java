package pagePkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage {

	@FindBy(linkText = "About us")
	WebElement  Aboutslink;
	
	@FindBy(id="videoModal")
	WebElement AboutsForm;
	
	@FindBy(xpath = "//*[@id=\"example-video\"]/button")
	WebElement playbutton;
	
	@FindBy(xpath="//*[@id=\"videoModal\"]/div/div/div[1]/button")
	WebElement closeicon;
	
	@FindBy(xpath="//*[@id=\"videoModal\"]/div/div/div[3]/button")
	WebElement closebtn;
	
	WebDriver driver;
	
    WebDriverWait wait;


	public AboutUsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	
	//open about us
	
		 public void openAboutus() {

		        wait.until(
		                ExpectedConditions.elementToBeClickable(Aboutslink)
		        ).click();
		        
		        wait.until(
		                ExpectedConditions.visibilityOf(AboutsForm)
		            );
		    }
		
		 //close  about us
		 
		 public void closeAbout()
		 {
			 wait.until(
		                ExpectedConditions.elementToBeClickable(closeicon)

					 
					 ).click();
		 }
		 
	 // Verify  about us Popup
		 
		 public boolean isAboutPopupDisplayed() 
		 
		 {

		        try {
		            return wait.until(
		                    ExpectedConditions.visibilityOf(AboutsForm))
		                    .isDisplayed();

		        } catch (Exception e) {
		            return false;
		        }
		    }
		 
		 public WebElement closebtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(closebtn));
			 
		 }
		 
		 public WebElement playbtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(playbutton));
			 
		 }
		 
		 public boolean clickplaybutton()
		 {
		     try {
		         wait.until(
		             ExpectedConditions.elementToBeClickable(playbutton)
		         ).click();

		         return true;
		     }
		     catch (Exception e) {
		         return false;
		     }
		 }

}
