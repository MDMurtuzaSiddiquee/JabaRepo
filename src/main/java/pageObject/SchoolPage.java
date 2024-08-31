package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchoolPage {
	
	WebDriver driver;
	public SchoolPage(WebDriver driver) {
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/school']")
	WebElement schoolLogo;
	
	public WebElement schoolLogo() {
		return schoolLogo;
		
	}
	
	@FindBy(xpath = "//li[@class='menu-item text-red-500']")
	WebElement LogoutButton;
	
	public WebElement LogoutButton() {
		return LogoutButton;
	
	}
	
	@FindBy(xpath="//button[text()='New campaign']")
	WebElement NewCampButton;
	
	public WebElement NewCampButton()
	{
		return NewCampButton;
	}

}
