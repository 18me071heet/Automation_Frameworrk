package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AccountRegistration  {
	
	
      WebDriver driver;
	
	public AccountRegistration(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfrstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtphone;
	
	@FindBy(xpath=" //input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkprivacy;
	
	@FindBy(xpath=" //input[@value='Continue']")
	WebElement btnlogin;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtconfirmation;
	
	public void frstname(String fname) {
		
		txtfrstname.sendKeys(fname);
	}
	
	public void lastname(String lname) {
		
		txtlastname.sendKeys(lname);
	}
	
	
	public void emailAdd(String email) {
		
		txtmail.sendKeys(email);
	}
	
	
	public void passwordAdd(String pass) {
		
		password.sendKeys(pass);
	}
	
	
	public void confirmPassword(String cpass) {
		
		cpassword.sendKeys(cpass);
	}
	
	
	public void telephone(String number) {
		
		txtphone.sendKeys(number);
	}
	
	public void checkBox() {
		
		chkprivacy.click();
	}
	
	
	public void login() {
		
		btnlogin.click();
	}
	
	public String getConfirmationMessage() {
		
		try {
			
			return(txtconfirmation.getText());
		}
		catch(Exception e) {
			
			return(e.getMessage());
			
		}
	}

	
	
	
}
