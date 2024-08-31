package jabaTests;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObject.AthleteHomePage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.SchoolPage;
import resources.Base;

public class To_Verify_Login_page extends Base{

	Logger log;
	WebDriver driver;
	LandingPage home;
	LoginPage login;
	SchoolPage dashBoard;
	
	@BeforeTest
	public void OpenApplication() throws IOException {
		
		log = LogManager.getLogger(To_Verify_Login_page.class.getName());
		driver=InitializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("mainUrl"));
		log.debug("Navigated to application URL");
	}
	
	@Test(priority = 1)
	public void Loginas_Admin() throws IOException, InterruptedException {
		
		home= new LandingPage(driver);
		// landing page
		Assert.assertTrue(home.Welcome_to_JABA().isDisplayed());
		log.debug("Welcome to JABA is displyed");
		
		login= new LoginPage(driver);
		//enter valid Admin Email And Password
		login.emailTextField().sendKeys(prop.getProperty("AdminEmail"));
		log.debug("AdminEmail addressed got entered");
		
		login.passwordTextField().sendKeys(prop.getProperty("AdminPassword"));
		log.debug("AdminPassword addressed got entered");
		
		login.loginButton().click();
		log.debug("Clicked on Login Button");
		
		dashBoard = new SchoolPage(driver);
		
		String expectedResult= "Passed";
		String actualResult= null;
		// to verify Admin DashBoard page/ School page
		if (dashBoard.LogoutButton().isDisplayed()) {
			log.debug("Admin Dashboard page is Displayed");
			 
		    actualResult = "Passed";
		    
		}else {
			log.debug("Admin didn't log in");
		    actualResult = "Failure";
		}
		Assert.assertEquals(actualResult, expectedResult);
		dashBoard.LogoutButton().click();
	}
		@Test(priority = 2)
		 public void LoginasAthlete() throws InterruptedException{
		//enter valid Athlete Email And Password
		login.emailTextField().sendKeys(prop.getProperty("AthleteEmail"));
		log.debug("AdminEmail addressed got entered");
		
		login.passwordTextField().sendKeys(prop.getProperty("AthletePassword"));
		log.debug("AdminPassword addressed got entered");
		
		login.loginButton().click();
		log.debug("Clicked on Login Button");
//		Thread.sleep(9000);
		// to verify Athlete DashBoard page
		AthleteHomePage athlete =new AthleteHomePage(driver);
		String expectedResult= "Passed";
		String actualResult= null;
		if (athlete.athleteLogo().isDisplayed()) {
			log.debug("Athlete Dashboard page is Displayed");
			
		   actualResult = "Passed";
		    
		}else {
			log.debug("Athlete didn't log in");
		    actualResult = "Failure";
		}
		Assert.assertEquals(actualResult, expectedResult);
		dashBoard.LogoutButton().click();
		}
		
		@Test(priority = 3)
		public void InvalidEmail_Message() throws InterruptedException {
		//enter Invalid Email And Valid Password
			
		login.emailTextField().clear();
		login.passwordTextField().clear();
		
		login.emailTextField().sendKeys(prop.getProperty("InvalidEmail"));
		log.debug("Invalid Email addressed got entered");
		
		login.passwordTextField().sendKeys(prop.getProperty("DemoPassword"));
		log.debug("ValidPassword addressed got entered");
		
		login.loginButton().click();
		log.debug("Clicked on Login Button");
		Thread.sleep(2000);
	
		String actualResult = login.Invalid_email().getText();
		
//		System.out.println(actualResult);
		
		//Email Error message is displayed.
	
		if (login.Invalid_email().isDisplayed()) {
			log.debug("invalid Email Message is Displayed");
			
		   
		}else {
			log.debug("invalid Email Message is not Displayed");
		}
		
		Assert.assertEquals(actualResult, "Invalid email.");
		
		login.cancelButton().click();
		driver.navigate().refresh();
		
		
		
		}
		
		
		
		@Test(priority = 4)
		public void InvalidPassword_Message() throws InterruptedException {

//			Thread.sleep(5000);
		//enter valid Email And InValid Password
		login.emailTextField().clear();
		login.passwordTextField().clear();
		
		login.emailTextField().sendKeys(prop.getProperty("DemoEmail"));
		log.debug("Valid Email addressed got entered");
		
		
		login.passwordTextField().sendKeys(prop.getProperty("InvalidPassword"));
		log.debug("invalid Password addressed got entered");
		
		login.loginButton().click();
		log.debug("Clicked on Login Button");
		
		Thread.sleep(2000);
		//Password Error message is displayed.
		String actualResult = login.Invalid_password().getText();
		
		if (login.Invalid_password().isDisplayed()) {
			log.debug("invalid Password Message is Displayed");
			
		    
		}else {
			log.debug("invalid Password Message is not Displayed");
			
		}
		Assert.assertEquals(actualResult,"Invalid password");
	}
	@AfterTest
	public void Closer() {
		driver.close();
		log.debug("Browser got closed");
	}
}
   