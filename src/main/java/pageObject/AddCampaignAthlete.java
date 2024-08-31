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
	 
	 @FindBy(xpath ="(//div/p)[3]")
	 WebElement  sportDropDown;
	 
	 public WebElement sportDropDown(){
		 return sportDropDown;	 
	 }
	 
	 @FindBy(xpath ="//span[text()='Football']")
	 WebElement  optionFootball;
	 
	 public WebElement optionFootball(){
		 return optionFootball;
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
