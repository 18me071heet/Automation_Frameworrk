package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;

import pageObjects.HomePage;
import testBase.baseClass;

public class Tc_001_UserRegistration extends baseClass{
	
	
	@Test(groups={"Functional","Master"})
	void verify_details() throws InterruptedException {
		
		
		logger.info("***** Starting Test Case:01 *******");
		
		
		try {
			
		Thread.sleep(3000);
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		
		logger.info("Click on My Account link");
		
		
		Thread.sleep(3000);
		
		hp.registerClick();
		logger.info("Click on Register link");

		AccountRegistration reges = new AccountRegistration(driver);
		
		
		logger.info("Providing Customer Details");
		
		reges.frstname(randomString().toUpperCase());
		
		reges.lastname(randomString().toUpperCase());

		reges.emailAdd(randomString()+"@gmail.com");

		reges.telephone(randomNumber());
	
		String password = randomAlphaNumeric(); // (Ex:xyz123)
		
		reges.passwordAdd(password);
		
		reges.confirmPassword(password);
		
		reges.checkBox();
		
		reges.login();
		
		
		logger.info("Validating Excepted Message");
		
		String message= reges.getConfirmationMessage();
		
		if(message.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		
		else {
			
			logger.error("Test Failed");
			logger.debug("Debug Logs....");
			Assert.assertTrue(false);
		}
		
		
		}
		
		catch(Exception e) {
			
		Assert.fail();
		
		
		}
	}
	
	
}
