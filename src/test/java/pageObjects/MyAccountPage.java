package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	        WebDriver driver;
		
			public MyAccountPage(WebDriver driver) {
				
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
			
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath=" //a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	public boolean IsmyAccountPageExist() {
		
		try {
			
			return(txtMyAccount.isDisplayed());
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void logOut() {
		btnLogout.click();
	}
}

