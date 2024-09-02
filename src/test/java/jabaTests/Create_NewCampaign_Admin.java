package jabaTests;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
	WebElement athleteAddButton;
	WebElement athleteSport;
	WebElement athleteCancelButton;
	WebElement camptext;
	Set<String> keys;
	String[] keyArray;

	
	
	
	
	
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
	
	newCamp= new JabaPage_CampaignCreate(driver);
	
	
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
	
	
	
	// Get the set of property names (keys)
    keys = prop.stringPropertyNames();
    
    // Convert Set to an array for indexed access
    keyArray = keys.toArray(new String[0]);
    
    
    List<String> filterAddTask = new ArrayList<>();
    List<String> filterDate = new ArrayList<>();
    List<String> filterPlatform = new ArrayList<>();
    List<String> filterSocialMedia = new ArrayList<>();


    // Loop through the array and filter strings containing
    for (String word : keyArray) {
        if (word.contains("addNewTask")) {
            filterAddTask.add(word);
            log.debug("Task name got added");
        }
        if (word.contains("taskDate")) {
        	filterDate.add(word);
        	log.debug("Task date got added");
        }
        
        if (word.contains("platform")) {
        	filterPlatform.add(word);
        	log.debug("Task platform got added");
        }
        if (word.contains("socialMedia")) {
        	filterSocialMedia.add(word);
        	log.debug("Task Social Media platform got added");
        	
        }else {
        	log.debug("error in the add task");
        }
           
    }
    
    
    // Convert List back to Array if needed
    String[] taskArray = filterAddTask.toArray(new String[0]);
    Arrays.sort(taskArray);
    
    String[] dateArray = filterDate.toArray(new String[0]);
    Arrays.sort(dateArray);
    
    String[] platformArray = filterPlatform.toArray(new String[0]);
    Arrays.sort(platformArray);
    
    String[] socialMediaArray = filterSocialMedia.toArray(new String[0]);
    Arrays.sort(socialMediaArray);
    
    int taskN = taskArray.length;


    for (int i = 0; i < taskN; i++) {
        String taskkey = taskArray[i];
        String datekey = dateArray[i];
        String platformkey = platformArray[i];
        String socialkey = socialMediaArray[i];

        
        newCamp.addTask().click();
    	log.debug("AddTask clicked");
            
    	newCamp.addNewTask().clear();
    	newCamp.addNewTask().sendKeys(prop.getProperty(taskkey));
        log.debug("addNewTask got entered");
    	newCamp.taskDate().clear();

		newCamp.taskDate().sendKeys(prop.getProperty(datekey));
		log.debug("taskDate got entered");
		
		newCamp.platform().click();
    	WebElement p1 = newCamp.platform();
    	selectPlatform =new Select(p1);
    	
    	selectPlatform.selectByVisibleText(prop.getProperty(platformkey));
    	log.debug("platform got selected");
        
      String value = prop.getProperty(platformkey);
      
		if (value.contains("Social") ) {
			
			newCamp.sMedia().click();
        	p2 = newCamp.sMedia();
        	selectSocial =new Select(p2);
        	
        	selectSocial.selectByVisibleText(prop.getProperty(socialkey));
        	log.debug("socialMedia got selected");
        	newCamp.sMedia().click(); 

		}
	  	newCamp.addButton().click();
    	log.debug("task1 created");
        
    }

//	Thread.sleep(5000);
	
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
                                                	
                                                	
                                                	Thread.sleep(2000);
                                                	
                                                	wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

                                                	Actions someChangeButton = action.moveToElement(newCamp.someChangesButton());
                                                	
                                                	someChangeButton.click().perform();
                                                	Thread.sleep(2000);

                                                	newCamp.previewButton().click();
                                                	log.debug("preview got clicked");
                                                	
                               
                                                	
                                                	WebElement looksgood1 = wait1.until(ExpectedConditions.elementToBeClickable(newCamp.looksgoodButton()));
                                                	String looksgood = looksgood1.getText();
                                                	
                                                	Assert.assertEquals(looksgood, "Looks good!");
                                                	
                                                	Thread.sleep(2000);
                                                	
                                                	looksgood1.click();
                                                	log.debug("looksgood got clicked");
                                                	
                                                	
                                                	
			}

                             	     
                                              
              @Test(priority = 3)
              public void addCampAthlete() throws InterruptedException {

            	campAthlete = new AddCampaignAthlete(driver);
//
            	Thread.sleep(3000);
       
            	athleteCancelButton = wait.until(ExpectedConditions.elementToBeClickable(campAthlete.cancelButton()));

            	athleteCancelButton.click();
            	
            	camptext = wait.until(ExpectedConditions.visibilityOf(newCamp.campName()));
            	
            	String campNametext = camptext.getText();
            	
//            	System.out.println(campNametext);
            	
            	String expectedResult = prop.getProperty("campaignName");
            	
            	Assert.assertEquals(campNametext, expectedResult);
            	log.debug("Campaign is created");
            	
            	Thread.sleep(3000);
            	
            	athleteAddButton = wait.until(ExpectedConditions.elementToBeClickable(campAthlete.addTalentButton()));
            	
            	athleteAddButton.click();
            	log.debug("Add Athlete is Clicked");

            	
//            	Thread.sleep(2000);

                // Convert Set to an array for indexed access

                List<String> filterAthletelist = new ArrayList<>();
                List<String> filterSportlist = new ArrayList<>();
                
                
                for (String words : keyArray) {
                    if (words.contains("AddAthleteName")) {
                    	filterAthletelist.add(words);
                        log.debug("Task name got added");
                    }
                    if (words.contains("AthleteSport")) {
                    	filterSportlist.add(words);
                    	log.debug("Task date got added");
                    }
                    
                  else {
                    	log.debug("error in the add at");
                    }
                       
                }

                // Convert List back to Array if needed
                String[] athleteArray = filterAthletelist.toArray(new String[0]);
                Arrays.sort(athleteArray);
                
                String[] sportArray = filterSportlist.toArray(new String[0]);
                Arrays.sort(sportArray);
   
                WebElement footballLocation = campAthlete.optionFootball();
            	String prFootball = prop.getProperty("AthleteSport1");
            	
            	WebElement volleyballLocation = campAthlete.optionvolleyball();

            	String prVolleyball = prop.getProperty("AthleteSport2");
            	
            	for(int i=0; i<athleteArray.length;i++) {
            		
            		  String athletekey = athleteArray[i];
            	        String sportskey = sportArray[i];
            	        String sportValur = prop.getProperty(sportskey);
            	        String athleteValur = prop.getProperty(athletekey);
            	        
            	        // clear the search text field
            	        campAthlete.athleteSearchTextField().clear();
            	        // Enter Athlete name into the Search text field.
                    	campAthlete.athleteSearchTextField().sendKeys(prop.getProperty(athletekey));
                    	log.debug("Athlete Name got Entered");
                    	
                    	//Click on Sport Drop Down
                    	campAthlete.sportDropDown().click();
                    	
                    	if(sportValur == prFootball) {

                    		footballLocation.click();
                    		log.debug("option football is selected");
                    		
                    		String athleteNameSearched = campAthlete.searchedAthleteNme().getText();

            				log.debug("Searched Athlete Name is displayed");
            				//Verify the Athlete
            				Assert.assertEquals(athleteNameSearched, athleteValur);
            				//Add the athlete
            				action= new Actions(driver);
            				action.moveToElement(campAthlete.firstAthlete()).click().perform();
            				log.debug(athleteValur+"Athlete is Selected");
            				
                    		
                    		
                    	}
                    	else if(sportValur==prVolleyball) {
                    		
                    		volleyballLocation.click();
                    		log.debug("option volleyball is selected");
                    		
                    		String athleteNameSearched = campAthlete.searchedAthleteNme().getText();
            				log.debug("Searched Athlete Name is displayed");
            				//Verify the Athlete
            				Assert.assertEquals(athleteNameSearched, athleteValur);
            				//Add the athlete
            				action= new Actions(driver);
            				action.moveToElement(campAthlete.firstAthlete()).click().perform();
            				log.debug(athleteValur+"Athlete is Selected");
                    		
                    		
                    	}else {
                    		System.out.println("Athlete not Added");
                    	}
            	}

            	
				campAthlete.nextButton().click();
				log.debug("Athlete is Added in to the campaign");
				
				String GenerateCampaignIdeasPage = campAthlete.aIGenerateCampaignIdeasPage().getText();
				System.out.println(GenerateCampaignIdeasPage);
				log.debug("Generate Campaign Ideas page is displayed");

				Assert.assertEquals(GenerateCampaignIdeasPage, "Generate Campaign Ideas");

				campAthlete.notRightNowButton().click();
				log.debug("Athlete is Added into the campaign");
				
				String athleteAddedSuccessFully = campAthlete.athleteAdded().getText();
				
//				System.out.println(athleteAddedSuccessFully);
				
				Assert.assertEquals(athleteAddedSuccessFully, "Congratulations, the campaign has been created with the desired athletes");
				log.debug("Congratulations, the campaign has been created with the desired athletes");

				wait1.until(ExpectedConditions.elementToBeClickable(campAthlete.sendInviteMessage()));

				String sendInviteButton = campAthlete.sendInviteMessage().getText();
//				System.out.println(sendInviteButton);
				log.debug("sendInviteMessage page is displayed");

				Assert.assertEquals(sendInviteButton, "Send invite message");
				
				
//				campAthlete.sendInviteMessage().click();
				
//				campAthlete.sendInviteMessageNextButton().click();
//				
//				
//				campAthlete.sendInviteMessageNextButton().click();


				
				
    
              }
              
//              @AfterTest
//          	public void Closer() {
//          		driver.close();
//          		log.debug("Browser got closed");
//          	}

}
