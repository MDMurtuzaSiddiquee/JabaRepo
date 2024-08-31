package jabaTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Base;

public class test extends Base{

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://ec2-54-173-227-35.compute-1.amazonaws.com:3005/login");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("testgrooth@gmail.com");
		
		WebElement	password=driver.findElement(By.id("password"));
		password.sendKeys("Test@123");
		
		WebElement	button=driver.findElement(By.xpath("//button[text()='Login']"));
		button.click();
		
		WebElement	camp=driver.findElement(By.xpath("//button[text()='New campaign']"));
		camp.click();
		
		WebElement	no =driver.findElement(By.xpath("//button[text()='No']"));
		no.click();
		
		
		
		
		
		
		
		
		
		
	}

}
