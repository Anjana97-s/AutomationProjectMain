package pagePkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	@FindBy(id="logInModal")
	WebElement loginInForm;
	
	@FindBy(id="logInModalLabel")
	WebElement label;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[1]/button")
	WebElement closeicon;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[2]/form/div[1]/label")
	
	WebElement usrname_label;
	
	@FindBy(id="loginusername")
	
	WebElement usrnametxtbox;
	
    @FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[2]/form/div[2]/label")
	
	WebElement pass_label;
	
	@FindBy(id="loginpassword")
	
	WebElement passtxtbox;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")
	
	WebElement closebtn;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	
	WebElement loginbtn;
	
	@FindBy(id="nameofuser")
	WebElement loggeduser;
	
    @FindBy(id="logout2")
	WebElement logout; 
	WebDriver driver;
    WebDriverWait wait;


	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	//Login
	
		public void Login(String username,String password)
		{
			 wait.until(
			            ExpectedConditions.visibilityOf(usrnametxtbox)
			        ).sendKeys(username);

			        wait.until(
			            ExpectedConditions.visibilityOf(passtxtbox)
			        ).sendKeys(password);


		}
		
		//open login
		
		 public void openLogin() {

		        wait.until(
		                ExpectedConditions.elementToBeClickable(loginlink)
		        ).click();
		        
		        wait.until(
		                ExpectedConditions.visibilityOf(loginInForm)
		            );
		    }
		 
		 //close login
		 
		 public void closeLogin()
		 {
			 wait.until(
		                ExpectedConditions.elementToBeClickable(closeicon)

					 
					 ).click();
		 }
		 
          public boolean isLoginPopupDisplayed() 
		 
		 {

		        try {
		            return wait.until(
		                    ExpectedConditions.visibilityOf(loginInForm))
		                    .isDisplayed();

		        } catch (Exception e) {
		            return false;
		        }
		    }
		 
		 
		 //logged user
		 
		 public boolean verifyLoggedInUsername(String expectedUsername) 
		 {

		        return wait.until(
		                ExpectedConditions.visibilityOf(
		                		loggeduser
		                )
		        ).getText().contains(expectedUsername);
		    }
		 public WebElement LoggedInUsername()
		 {
			return loggeduser;
			 
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
		 
		 public WebElement loginbtn()
		 {
			 
			return wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
			 
		 }
		 public WebElement loginform()
		 {
			return loginInForm;
			 
			 
		 }
		  
		 public void submitLoginForm() 
		 {
		        wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
		 }
		 
		 public boolean logout()
		 {
			 try {
		             wait.until(
		                    ExpectedConditions.elementToBeClickable(logout))
		                    .click();
		             return true;

		        } catch (Exception e) {
		            return false;
		        }
		 }
		 

}
