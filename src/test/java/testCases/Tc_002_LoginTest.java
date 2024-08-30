package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;

public class Tc_002_LoginTest extends baseClass {

	@Test(groups= {"Smoke","Master"})
	public void verify_login(){
		
		try {
			
		logger.info("***** Starting Tc_002 Login Test Case******");
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.loginClick();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.loginBtn();
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage =ap.IsmyAccountPageExist();
		Assert.assertEquals(targetPage, true);
		
		logger.info("***** Tc_003 Finished *****");
		
		}

		catch(Exception e) {
			Assert.fail();
		}
		
	}
}
