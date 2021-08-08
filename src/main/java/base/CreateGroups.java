package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateGroups {

	public static void main(String[] args) throws InterruptedException {

		//setup chromedriver.exe and chrome options
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("start-maximized");

		//setup webdriver and login
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		driver.get("https://login.salesforce.com/");
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("cypress@testleaf.com");
		WebElement elePaswword = driver.findElement(By.xpath("//input[@id='password']"));
		elePaswword.sendKeys("Selbootcamp@1234");
		WebElement eleLoginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		eleLoginButton.click();

		//select the toggle menu, click on 'view all'option & select the sales in apps
		WebElement eleToggleButton = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		eleToggleButton.click();
		WebElement eleViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		eleViewAll.click();
		WebElement eleSales = driver.findElement(By.xpath("//p[@class='slds-truncate'][text()='Sales']"));
		eleSales.click();
		
		//click on more and select the groups
		WebElement eleMoreDropDown = driver.findElement(By.xpath("//span[@class='slds-p-right_small'][text()='More']"));
		eleMoreDropDown.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement eleGroups = driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Groups']"));
		//eleGroups.click();
		js.executeScript("arguments[0].click();", eleGroups);
		
		//click on New and enter name click on save
		WebElement eleNew = driver.findElement(By.xpath("//a[@role='button'][@title='New']"));
		eleNew.click();
		
		WebElement eleName = driver.findElement(By.xpath("//input[@type='text'][@aria-required='true']"));
		wait.until(ExpectedConditions.visibilityOf(eleName));
		eleName.sendKeys("HK");
		WebElement eleSave = driver.findElement(By.xpath("//button//span[text()='Save & Next']"));
		eleSave.click();
		
		//verify the error message
		String expectedMsg = "These required fields must be completed: Access Type";
		WebElement eleErrorMsg = driver.findElement(By.xpath("//ul[@class='errorsList']//li"));
		String actualMsg = eleErrorMsg.getText();	
		Assert.assertEquals(actualMsg, expectedMsg, "The error message is not displayed as expected! Please Verify!!");
		
		System.out.println("TC Pass");
		driver.close();
	}

}
