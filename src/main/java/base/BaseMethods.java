package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;	

	@Parameters("browser")
	@BeforeMethod
	public void StartApp(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("disable-notifications");
			options.addArguments("start-maximized");
			driver = new EdgeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		js = (JavascriptExecutor) driver;	
		
		driver.get("https://login.salesforce.com/");
		
		
	}


	@AfterMethod
	public void closeApplication() {
		driver.close();
	}
}