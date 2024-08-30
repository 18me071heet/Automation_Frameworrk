package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	  WebDriver driver;
		
		public LoginPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement txtemail;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement txtpassword;
		
		@FindBy(xpath="//input[@value='Login']")
		WebElement btnlogin;
		
	    public void email(String emailAdd) {
	    	
	    	txtemail.sendKeys(emailAdd);
	    }
	    
       public void password(String pass) {
	    	
	    	txtpassword.sendKeys(pass);
	    }
       
       public void loginBtn() {
    	   
    	   btnlogin.click();
       }
 
	 
}
