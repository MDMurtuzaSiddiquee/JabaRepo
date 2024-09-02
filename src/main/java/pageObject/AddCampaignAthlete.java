package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCampaignAthlete {
	
	WebDriver driver;

	public AddCampaignAthlete(WebDriver driver) {
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@placeholder=\"Search Athletes\"]")
	 WebElement athleteSearchTextField;
	 
	 public WebElement athleteSearchTextField(){
		 return athleteSearchTextField;	 
	 }
	 
	 @FindBy(xpath ="//button[text()='Cancel']")
	 WebElement cancelButton;
	 
	 public WebElement cancelButton(){
		 return cancelButton;	 
	 }
	 
	 @FindBy(xpath ="//button[text()=' Add Talent']")
	 WebElement  addTalentButton;
	 
	 public WebElement addTalentButton(){
		 return addTalentButton;	 
	 }
	 
	 @FindBy(xpath ="(//div/div/p)[2]")
	 WebElement  sportDropDown;
	 
	 public WebElement sportDropDown(){
		 return sportDropDown;	 
	 }
	 
	 @FindBy(xpath ="//span[text()='football']")
	 WebElement  optionFootball;
	 
	 public WebElement optionFootball(){
		 return optionFootball;
	 }
	 
	 @FindBy(xpath ="//span[text()='volleyball']")
	 WebElement  optionvolleyball;
	 
	 public WebElement optionvolleyball(){
		 return optionvolleyball;
	 }
	 @FindBy(xpath ="//span[text()='bowling']")
	 WebElement  optionBowling;
	 
	 public WebElement optionBowling(){
		 return optionBowling;
	 }
	 @FindBy(xpath ="//span[text()='hockey']")
	 WebElement  optionHockey;
	 
	 public WebElement optionHockey(){
		 return optionHockey;
	 }
	 
	 @FindBy(xpath ="//span[text()='rifle']")
	 WebElement  optionRifle;
	 
	 public WebElement optionRifle(){
		 return optionRifle;
	 }
	 @FindBy(xpath ="//span[text()='baseball']")
	 WebElement  optionBaseball;
	 
	 public WebElement optionBaseball(){
		 return optionBaseball;
	 }
	 
	 @FindBy(xpath ="//span[text()='tennis']")
	 WebElement  optionTennis;
	 
	 public WebElement optionTennis(){
		 return optionTennis;
	 }
	 @FindBy(xpath ="//span[text()='soccer']")
	 WebElement  optionSoccer;
	 
	 public WebElement optionSoccer(){
		 return optionSoccer;
	 }
	 @FindBy(xpath ="//span[text()='track & field']")
	 WebElement  optionTrackField;
	 
	 public WebElement optionTrackField(){
		 return optionTrackField;
	 }
	 
	 @FindBy(xpath ="//span[text()='table tennis']")
	 WebElement  optionTableTennis;
	 
	 public WebElement optionTableTennis(){
		 return optionTableTennis;
	 }
	 @FindBy(xpath ="//span[text()='gymnastics']")
	 WebElement  optionGymnastics;
	 
	 public WebElement optionGymnastics(){
		 return optionGymnastics;
	 }
	 
	 @FindBy(xpath ="//span[text()='swimming']")
	 WebElement  optionSwimming;
	 
	 public WebElement optionSwimming(){
		 return optionSwimming;
	 }
	 
	 @FindBy(xpath ="//span[text()='golf']")
	 WebElement  optionGolf;
	 
	 public WebElement optionGolf(){
		 return optionGolf;
	 }
	 @FindBy(xpath ="//span[text()='rowing']")
	 WebElement  optionRowing;
	 
	 public WebElement optionRowing(){
		 return optionRowing;
	 }
	 
	 
	 @FindBy(xpath ="(//div/img[@alt='athlete'])[1]")
	 WebElement  firstAthlete;
	 
	 public WebElement firstAthlete(){
		 return firstAthlete;
	 }
	 
	 @FindBy(xpath ="//button[text()='Next']")
	 WebElement  nextButton;
	 
	 public WebElement nextButton(){
		 return nextButton;
	 }
	 
	 
	 @FindBy(xpath ="//h4[text()='Generate Campaign Ideas']")
	 WebElement  aIGenerateCampaignIdeasPage;
	 
	 public WebElement aIGenerateCampaignIdeasPage(){
		 return aIGenerateCampaignIdeasPage;
	 }
	 
	 @FindBy(xpath ="//button[text()='Not right now']")
	 WebElement  notRightNowButton;
	 
	 public WebElement notRightNowButton(){
		 return notRightNowButton;
	 }
	 
	 @FindBy(xpath ="//div/p[text()='Congratulations, the campaign has been created with the desired athletes']")
	 WebElement  athleteAdded;
	 
	 public WebElement athleteAdded(){
		 return athleteAdded;
	 }
	 
	 @FindBy(xpath ="(//div/div/h1)[1]")
	 WebElement  searchedAthleteNme;
	 
	 public WebElement searchedAthleteNme(){
		 return searchedAthleteNme;
	 }
	 
	 
	 @FindBy(xpath ="//button[text()='Send invite message']")
	 WebElement  sendInviteMessage;
	 
	 public WebElement sendInviteMessage(){
		 return sendInviteMessage;
	 }
	 
	 @FindBy(xpath ="//button[text()='Next']")
	 WebElement  sendInviteMessageNextButton;
	 
	 public WebElement sendInviteMessageNextButton(){
		 return sendInviteMessageNextButton;
	 }
	 
	 @FindBy(xpath ="//button[text()='Invite']")
	 WebElement  sendInviteMessageInviteButton;
	 
	 public WebElement sendInviteMessageInviteButton(){
		 return sendInviteMessageInviteButton;
	 }
	 
	 
	 
	 
	 
}
