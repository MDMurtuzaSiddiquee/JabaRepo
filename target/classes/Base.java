package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	
	public Properties prop;
	
	public WebDriver InitializeDriver() throws IOException {
		
		
		
		
		prop= new Properties();
		
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream File =new FileInputStream(propPath);
		
		prop.load(File);
		
	
		
	String	BrowserName= prop.getProperty("Browser");
	
	if(BrowserName.equalsIgnoreCase("Chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}else if(BrowserName.equalsIgnoreCase("FireFox")){
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if (BrowserName.equalsIgnoreCase("Safari")) {
	
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
	}else if(BrowserName.equalsIgnoreCase("Edge")) {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}else {
		System.out.println("Browser Not Avalible");
	}
	
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	
	return driver;
		
		
	}

}
