package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AthleteHomePage {
	WebDriver driver;
	public AthleteHomePage(WebDriver driver) {
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href= '/athlete']")
	WebElement athleteLogo;
	
	public WebElement athleteLogo() {
		return athleteLogo;
	}
}
