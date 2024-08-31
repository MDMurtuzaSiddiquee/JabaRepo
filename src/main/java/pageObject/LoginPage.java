package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement emailTextField;
	
	public WebElement emailTextField() {
		return emailTextField;
	}
	
	@FindBy(id="password")
	WebElement passwordTextField;
	
	public WebElement passwordTextField() {
		return passwordTextField;
	}
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	
	public WebElement loginButton() {
		return loginButton;
	}
	
			//invalid Notification popUp
	
	@FindBy(xpath = "//div[text()='Invalid email.']")
	WebElement Invalid_email;
	
	public WebElement Invalid_email() {
		return Invalid_email;
	}
	
	@FindBy(xpath = "//button[@aria-label='close']")
	WebElement cancelButton;
	
	public WebElement cancelButton() {
		return cancelButton;
	}
	
	
	@FindBy(xpath = "//div[text()='Invalid password']")
	WebElement Invalid_password;
	
	public WebElement Invalid_password() {
		return Invalid_password;
	}
	
	
}
