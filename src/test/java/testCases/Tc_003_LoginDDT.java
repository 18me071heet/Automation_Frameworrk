package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;
import utilities.DataProviders;

public class Tc_003_LoginDDT extends baseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"dataDriven"})
	public void verify_loginDDT(String email,String pwd,String exp){
		
		try {
			
		logger.info("***** Starting Tc_002 Login Test Case******");
		
		//Home Page
		
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.loginClick();
		
		
		// Login Page
		
		LoginPage lp = new LoginPage(driver);
		
		Thread.sleep(2000);
		lp.email(email);
		lp.password(pwd);
		lp.loginBtn();
		
		// My Account Page
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage =ap.IsmyAccountPageExist();
		Assert.assertEquals(targetPage, true);
		
		
		/* Data is Valid - Login Success - Test Pass - Logout
		                   Login Failed - Test Failed
		                   
		   Data is Invalid - Login Success - Test Failed - Logout
		                   Login Failed - Test Passed
		 */
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				ap.logOut();
				Assert.assertTrue(true);
			}
			
			else {
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetPage==true) {
				ap.logOut();
				Assert.assertTrue(false);
			}
			
			else {
				Assert.assertTrue(true);
			}
			
		}
		
		
		logger.info("***** Tc_003 Finished *****");
		
		}

		catch(Exception e) {
			Assert.fail();
		}
		
	}
}
