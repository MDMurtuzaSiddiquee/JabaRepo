package jabaTests;

import java.io.IOException;
import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.AddCampaignAthlete;
import pageObject.JabaPage_CampaignCreate;
import pageObject.LoginPage;
import pageObject.SchoolPage;
import resources.Base;

public class Create_NewCampaign_Admin extends Base{
	
	Actions action;
	Logger log;
	WebDriver driver;
	LoginPage login;
	SchoolPage dashBoard;
	JabaPage_CampaignCreate newCamp;
	Select selectPlatform;
	Select selectSocial;
	WebElement p2;
	AddCampaignAthlete campAthlete;
	WebDriverWait wait;
	WebDriverWait wait1;

	
	
	
	
	
	@BeforeTest
	public void OpenApplication() throws IOException{

		log = LogManager.getLogger(To_Verify_Login_page.class.getName());
		driver=InitializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("mainUrl"));
		log.debug("Navigated to application URL");
	}
	
	@Test(priority = 1)
	public void login_Admin() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
		login = new LoginPage(driver);
		//enter valid Admin Email And Password
		login.emailTextField().sendKeys(prop.getProperty("AdminEmail"));
		log.debug("AdminEmail addressed got entered");
		
		login.passwordTextField().sendKeys(prop.getProperty("AdminPassword"));
		log.debug("AdminPassword addressed got entered");
		
		login.loginButton().click();
		log.debug("Clicked on Login Button");
		
		dashBoard = new SchoolPage(driver);
//		Thread.sleep(3000);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement campButton = wait.until(ExpectedConditions.visibilityOf(dashBoard.NewCampButton()));
		
		String actualResult = dashBoard.NewCampButton().getText();
		// to verify Admin DashBoard page/ New Campaign button
//		System.out.println(actualResult);
		
		if (campButton.isDisplayed()) {
			log.debug("Campaign button is Displayed");
		    
		}else {
			log.debug("Campaign button is not Displayed");
		}
		Assert.assertEquals(actualResult, "New Campaign");
//		Thread.sleep(3000);
		campButton.click();
		log.debug("click on the NewCampaign button");
		
	}

@Test(priority = 2)
public void NewCampaign() throws InterruptedException{
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	
	newCamp= new JabaPage_CampaignCreate(driver);
	
//	Thread.sleep(3000);
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	WebElement campNoButton = wait.until(ExpectedConditions.visibilityOf(newCamp.noButton()));
	
	String actualResult = newCamp.JabaPage().getText();
	
	Assert.assertEquals(actualResult, "JABA");
	log.debug("Jaba chat New Campaign page is displayed");
	
	campNoButton.click();
	
	newCamp.brandName().clear();
	newCamp.brandName().sendKeys(prop.getProperty("barandName"));
	log.debug("BarandName got entered");
	
	
	newCamp.campaignName().clear();
	newCamp.campaignName().sendKeys(prop.getProperty("campaignName"));
	log.debug("CampaignName got entered");
	
	newCamp.startDate().sendKeys(prop.getProperty("startDate"));
	log.debug("startDate got entered");
	

	newCamp.endDate().sendKeys(prop.getProperty("endDate"));
	log.debug("endDate got entered");
	

	newCamp.exclusivityWindow().sendKeys(prop.getProperty("exclusivitWindow"));
	log.debug("exclusivityWindow got entered");
	

	newCamp.projectRate().sendKeys(prop.getProperty("projectRate"));
	log.debug("projectRate got entered");

	newCamp.description().sendKeys(prop.getProperty("description"));
	log.debug("description got entered");

	newCamp.addCategory().click();
	log.debug("addCategory clicked");

	newCamp.addNewCategory().sendKeys(prop.getProperty("exclusivityCategories"));
	log.debug("addNewCategory got entered");

	newCamp.addNewCategoryButton().click();
	log.debug("addCategoryButton got clicked");
	
	
	//for task1
	newCamp.addTask().click();
	log.debug("AddTask clicked");
        
			newCamp.addNewTask().clear();
			newCamp.addNewTask().sendKeys( prop.getProperty("addNewTask1"));
        	log.debug("addNewTask got entered");
			
        	newCamp.taskDate().clear();
//        	Thread.sleep(2000);
        	newCamp.taskDate().sendKeys(prop.getProperty("tDate1"));
        	log.debug("taskDate got entered");
        	
        	newCamp.platform().click();
        	WebElement p1 = newCamp.platform();
        	selectPlatform =new Select(p1);
        	
        	selectPlatform.selectByVisibleText(prop.getProperty("platform1"));
        	log.debug("platform got selected");
        	

        	newCamp.sMedia().click();
        	
        	p2 = newCamp.sMedia();
        	selectSocial =new Select(p2);
        	
        	selectSocial.selectByVisibleText(prop.getProperty("socialMedia1"));
        	log.debug("socialMedia got selected");
        	
        	newCamp.sMedia().click();        	
        	
        	newCamp.addButton().click();
        	log.debug("task1 created");
        	
        	//for task2
        	newCamp.addTask().click();
        	log.debug("AddTask clicked");
                
        			newCamp.addNewTask().clear();
        			newCamp.addNewTask().sendKeys( prop.getProperty("addNewTask2"));
                	log.debug("addNewTask got entered");
        			
                	newCamp.taskDate().clear();
//                	Thread.sleep(2000);
                	newCamp.taskDate().sendKeys(prop.getProperty("tDate2"));
                	log.debug("taskDate got entered");
                	
                	newCamp.platform().click();
                	
//                	selectPlatform =new Select(newCamp.platform());
                	
                	selectPlatform.selectByVisibleText(prop.getProperty("platform1"));
                	log.debug("platform got selected");
                	
                	
                	
//                	WebElement p3 = newCamp.sMedia();
//                	 select3 = new Select(p3);
                	
                	 selectSocial.selectByVisibleText(prop.getProperty("socialMedia2"));
                	log.debug("socialMedia got selected");
                	
                	
                	
                	

                	newCamp.sMedia().click();
////                	select2 =new Select(newCamp.platform());
//                	
//                	new Select(newCamp.platform()).selectByVisibleText(prop.getProperty("socialMedia2"));
//                	log.debug("socialMedia got selected");
                	
                	newCamp.sMedia().click();        	
                	
                	newCamp.addButton().click();
                	log.debug("task2 created");
                	
                	//for Task3
                	
                	newCamp.addTask().click();
                	log.debug("AddTask clicked");
                        
                			newCamp.addNewTask().clear();
                			newCamp.addNewTask().sendKeys( prop.getProperty("addNewTask3"));
                        	log.debug("addNewTask got entered");
                			
                        	newCamp.taskDate().clear();
//                        	Thread.sleep(2000);
                        	newCamp.taskDate().sendKeys(prop.getProperty("tDate3"));
                        	log.debug("taskDate got entered");
                        	
                        	newCamp.platform().click();
//                        	select =new Select(newCamp.platform());
                        	
                        	selectPlatform.selectByVisibleText(prop.getProperty("platform1"));
                        	log.debug("platform got selected");
                        	

                        	newCamp.sMedia().click();
                        	
                        	
//                        	select2 =new Select(newCamp.platform());
                        	
                        	selectSocial.selectByVisibleText(prop.getProperty("socialMedia2"));
                        	log.debug("socialMedia got selected");
                        	
                        	newCamp.sMedia().click();        	
                        	
                        	newCamp.addButton().click();
                        	log.debug("task created");
                        	
                        	//for Task4
                        	
                        	newCamp.addTask().click();
                        	log.debug("AddTask clicked");
                                
                        			newCamp.addNewTask().clear();
                        			newCamp.addNewTask().sendKeys( prop.getProperty("addNewTask4"));
                                	log.debug("addNewTask got entered");
                        			
                                	newCamp.taskDate().clear();
//                                	Thread.sleep(2000);
                                	newCamp.taskDate().sendKeys(prop.getProperty("tDate4"));
                                	log.debug("taskDate got entered");
                                	
                                	newCamp.platform().click();
//                                	select =new Select(newCamp.platform());
                                	
                                	selectPlatform.selectByVisibleText(prop.getProperty("platform1"));
                                	log.debug("platform got selected");
                                	

                                	newCamp.sMedia().click();
                                	
                                	
//                                	select2 =new Select(newCamp.platform());
                                	
                                	selectSocial.selectByVisibleText(prop.getProperty("socialMedia2"));
                                	log.debug("socialMedia got selected");
                                	
                                	newCamp.sMedia().click();        	
                                	
                                	newCamp.addButton().click();
                                	log.debug("task4 created");
                                	
                                	//for Task5
                                	
                                	newCamp.addTask().click();
                                	log.debug("AddTask clicked");
                                        
                                			newCamp.addNewTask().clear();
                                			newCamp.addNewTask().sendKeys( prop.getProperty("addNewTask5"));
                                        	log.debug("addNewTask got entered");
                                			
                                        	newCamp.taskDate().clear();
//                                        	Thread.sleep(2000);
                                        	newCamp.taskDate().sendKeys(prop.getProperty("tDate5"));
                                        	log.debug("taskDate got entered");
                                        	
                                        	newCamp.platform().click();
//                                        	select =new Select(newCamp.platform());
                                        	
                                        	selectPlatform.selectByVisibleText(prop.getProperty("platform1"));
                                        	log.debug("platform got selected");
                                        	

                                        	newCamp.sMedia().click();
                                        	
                                        	
//                                        	select2 =new Select(newCamp.platform());
                                        	
                                        	selectSocial.selectByVisibleText(prop.getProperty("socialMedia3"));
                                        	log.debug("socialMedia got selected");
                                        	
                                        	newCamp.sMedia().click();        	
                                        	
                                        	newCamp.addButton().click();
                                        	log.debug("task5 created");
                                        	
                                        	//for Task6
                                        	
                                        	newCamp.addTask().click();
                                        	log.debug("AddTask clicked");
                                                
                                        			newCamp.addNewTask().clear();
                                        			newCamp.addNewTask().sendKeys( prop.getProperty("addNewTask6"));
                                                	log.debug("addNewTask got entered");
                                        			
                                                	newCamp.taskDate().clear();
//                                                	Thread.sleep(2000);
                                                	newCamp.taskDate().sendKeys(prop.getProperty("tDate6"));
                                                	log.debug("taskDate got entered");
                                                	
                                                	newCamp.platform().click();
//                                                	select =new Select(newCamp.platform());
                                                	
                                                	selectPlatform.selectByVisibleText(prop.getProperty("platform1"));
                                                	log.debug("platform got selected");
                                                	

                                                	newCamp.sMedia().click();
                                                	
                                                	
//                                                	select2 =new Select(newCamp.platform());
                                                	
                                                	selectSocial.selectByVisibleText(prop.getProperty("socialMedia3"));
                                                	log.debug("socialMedia got selected");
                                                	
                                                	newCamp.sMedia().click();        	
                                                	
                                                	newCamp.addButton().click();
                                                	log.debug("task6 created");
                                                	
                                                	
                                                	// Add Requirment
                                                	
                                                	newCamp.addRequirement().click();
                                                	newCamp.requirementTextField().sendKeys(prop.getProperty("requirement"));
                                                	log.debug("requirement got entered");
                                                	newCamp.requirementAddButton().click();
                                                	log.debug("requirement created");
                                                	
                                                	
                                                	String preview = newCamp.previewButton().getText();
//                                                	System.out.println(preview);
                                                	
                                                	Assert.assertEquals(preview, "Preview");
                                                
                                                	newCamp.previewButton().click();
                                                	log.debug("preview got clicked");
                                                	
                                                	action=new Actions(driver);
                                                	
                                                	
//                                                	Thread.sleep(2000);
                                                	
                                                	wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

                                                	Actions someChangeButton = action.moveToElement(newCamp.someChangesButton());
                                                	someChangeButton.click().perform();

                                                	newCamp.previewButton().click();
                                                	log.debug("preview got clicked");
                                                	
                                                	
                                                	
//                                                	WebElement looksgood = wait.until(ExpectedConditions.visibilityOf(newCamp.looksgoodButton()));
                                               
//                                                	String looks = looksgood.getText();
//                                                	System.out.println(looks);
                                                	
                                                	WebElement looksgood1 = wait1.until(ExpectedConditions.elementToBeClickable(newCamp.looksgoodButton()));
                                                	String looksgood = looksgood1.getText();
                                                	
                                                	Assert.assertEquals(looksgood, "Looks good!");
                                                	
                                                	Thread.sleep(2000);
                                                	
                                                	looksgood1.click();
                                                	log.debug("looksgood got clicked");
                                                	
                                                	
                                                	
			}
                                                	
                                                	
                                                	     
                                              
              @Test(priority = 3)
              public void addCampAthlete() throws InterruptedException {
            	  
            	  
            	  Thread.sleep(2000);
            	campAthlete = new AddCampaignAthlete(driver);

            	
            	campAthlete.cancelButton().click();
            	
//            	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            	
//            	WebElement athleteCancelButton = wait.until(ExpectedConditions.visibilityOf(campAthlete.cancelButton()));
//
//            	athleteCancelButton.click();
            	
            	WebElement camptext = wait.until(ExpectedConditions.visibilityOf(newCamp.campName()));
            	
            	String campNametext = camptext.getText();
            	
//            	System.out.println(campNametext);
            	
            	String expectedResult = prop.getProperty("campaignName");
            	
            	Assert.assertEquals(campNametext, expectedResult);
            	
            	log.debug("Campaign is created");
            	
            	
            	
            	
            	
            	
            	
            	
            	WebElement athleteAddButton = wait.until(ExpectedConditions.visibilityOf(campAthlete.addTalentButton()));
            	
            	athleteAddButton.click();
            	log.debug("Add Athlete is Clicked");
            	
            	campAthlete.athleteSearchTextField().clear();
            	
            	campAthlete.athleteSearchTextField().sendKeys(prop.getProperty("AthleteName"));
            	log.debug("Athlete Name got Entered");
            	
            	
            	WebElement athleteSport = campAthlete.sportDropDown();
            	athleteSport.click();
            	
            	campAthlete.optionFootball().click();
            	log.debug("Athlete is displayed");
            	
            	
            	action= new Actions(driver);
				action.moveToElement(campAthlete.firstAthlete()).click().perform();
				log.debug("Athlete is Selected");
            	
            	
				campAthlete.nextButton().click();
				log.debug("Athlete is Added in to the campaign");
				
				String GenerateCampaignIdeasPage = campAthlete.aIGenerateCampaignIdeasPage().getText();
//				System.out.println(GenerateCampaignIdeasPage);
				log.debug("Generate Campaign Ideas page is displayed");

				Assert.assertEquals(GenerateCampaignIdeasPage, "Generate Campaign Ideas");
				
				
				
				campAthlete.notRightNowButton().click();
				log.debug("Athlete is Added into the campaign");
				
				String athleteAddedSuccessFully = campAthlete.athleteAdded().getText();
				
//				System.out.println(athleteAddedSuccessFully);
				
				Assert.assertEquals(athleteAddedSuccessFully, "Congratulations, the campaign has been created with the desired athletes");
				log.debug("Congratulations, the campaign has been created with the desired athletes");

				
//				
//				wait1.until(ExpectedConditions.visibilityOf(campAthlete.sendInviteMessage()));
////				
//				campAthlete.sendInviteMessage().click();
//				
////				campAthlete.sendInviteMessageNextButton().click();
////				
////				
////				campAthlete.sendInviteMessageNextButton().click();


				
				
    
              }
              
//              @AfterTest
//          	public void Closer() {
//          		driver.close();
//          		log.debug("Browser got closed");
//          	}

}
