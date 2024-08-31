package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h1[text()='Welcome to JABA ']")
	WebElement Welcome_to_JABA;
	
	public WebElement Welcome_to_JABA() {
		
		return Welcome_to_JABA;
	}

}
