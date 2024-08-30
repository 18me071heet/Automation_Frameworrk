package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath=" //a[normalize-space()='Login']")
	WebElement login;
	
	public void myAccountClick() {
		
		myAccount.click();
	}
	
	public void registerClick() {
		
		register.click();
	}
	
	public void loginClick() {
		
		login.click();
		
	}

	
}
