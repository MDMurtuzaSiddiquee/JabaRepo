package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JabaPage_CampaignCreate {
	
	WebDriver driver;

	public JabaPage_CampaignCreate(WebDriver driver) {
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath= "//p[text()='JABA']")
	 WebElement JabaPage;
	 
	 public WebElement JabaPage() {
		 
		 return JabaPage;
	 }
	 
	 @FindBy(xpath= "//button[text()='No']")
	 WebElement noButton;
	 
	 public WebElement noButton() {
		 return noButton;
	 }
	 
	 @FindBy(id ="brand_name")
	 WebElement brandName;
	 
	 public WebElement brandName(){
		 return brandName;
	 }
	 
	 @FindBy(id ="campaign_name")
	 WebElement campaignName;
	 
	 public WebElement campaignName(){
		 return campaignName;
	 }
	 
	 
	 @FindBy(id ="start_date")
	 WebElement startDate;
	 
	 public WebElement startDate(){
		 return startDate;
	 }
	 @FindBy(id ="end_date")
	 WebElement endDate;
	 
	 public WebElement endDate(){
		 return endDate;
	 }
	 
	 @FindBy(id ="exclusivity_window")
	 WebElement exclusivityWindow;
	 
	 public WebElement exclusivityWindow(){
		 return exclusivityWindow;
	 }
	 
	 @FindBy(id ="project_rate")
	 WebElement projectRate;
	 
	 public WebElement projectRate(){
		 return projectRate;
	 }
	 @FindBy(id ="description")
	 WebElement description;
	 
	 public WebElement description(){
		 return description;
	 }
	 
	 @FindBy(xpath ="//button[text()='Add category']")
	 WebElement addCategory;
	 
	 public WebElement addCategory(){
		 return addCategory;
	 }
	 
	 @FindBy(xpath ="//input[@placeholder='Add new category']")
	 WebElement addNewCategory;
	 
	 public WebElement addNewCategory(){
		 return addNewCategory;
	 }
	 
	 @FindBy(xpath ="//button[text()='Add']")
	 WebElement addNewCategoryButton;
	 
	 public WebElement addNewCategoryButton(){
		 return addNewCategoryButton;
	 }	

	 @FindBy(xpath ="//button[text()='Add task']")
	 WebElement addTask;
	 
	 public WebElement addTask(){
		 return addTask;
	 }
	 
	 @FindBy(xpath ="//input[@placeholder='Add new task']")
	 WebElement addNewTask;
	 
	 public WebElement addNewTask(){
		 return addNewTask;
	 }
	 @FindBy(xpath ="//div/div/form/input[2]")
	 WebElement taskDate;
	 
	 public WebElement taskDate(){
		 return taskDate;
	 }
	 @FindBy(xpath ="//select[@placeholder='Select platform']")
	 WebElement platform;
	 
	 public WebElement platform(){
		 return platform;
	 }
	 
	 @FindBy(xpath ="//div/div/form/select[1]")
	 WebElement sMedia;
	 
	 public WebElement sMedia(){
		 return sMedia;
	 }
	 @FindBy(xpath ="//button[text()='Add']")
	 WebElement addButton;
	 
	 public WebElement addButton(){
		 return addButton;
	 }
	 
	 @FindBy(xpath ="//button[text()='Add requirement']")
	 WebElement addRequirement;
	 
	 public WebElement addRequirement(){
		 return addRequirement;	 
	 }
	 
	 @FindBy(xpath ="//input[@placeholder='Add new requirement']")
	 WebElement requirementTextField;
	 
	 public WebElement requirementTextField(){
		 return requirementTextField;	 
	 }
	 
	 @FindBy(xpath ="//button[text()='Add']")
	 WebElement requirementAddButton;
	 
	 public WebElement requirementAddButton(){
		 return requirementAddButton;	 
	 }
	 
	 @FindBy(xpath ="//button[text()='Preview']")
	 WebElement previewButton;
	 
	 public WebElement previewButton(){
		 return previewButton;	 
	 }
	 
	 @FindBy(xpath ="//button[text()='I have some changes.']")
	 WebElement  someChangesButton;
	 
	 public WebElement someChangesButton(){
		 return someChangesButton;	 
	 }
	 
	 @FindBy(xpath ="//button[text()='Looks good!']")
	 WebElement looksgoodButton;
	 
	 public WebElement looksgoodButton(){
		 return looksgoodButton;	 
	 }
	 
	 @FindBy(xpath ="//div/main/h2")
	 WebElement campName;
	 
	 public WebElement campName(){
		 return campName;	 
	 }
	 
	 
}