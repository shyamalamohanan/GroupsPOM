package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;

public class LoginPage extends BaseMethods {
	public LoginPage(WebDriver driver,JavascriptExecutor js, WebDriverWait wait) {
		this.driver = driver;
		this.js = js;
		this.wait = wait;
	}

	public LoginPage enterLoginName(){
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("cypress@testleaf.com");
		return this;
	}
	
	public LoginPage enterLoginPassword(){
		WebElement eleUserPassword = driver.findElement(By.xpath("//input[@id='password']"));
		eleUserPassword.sendKeys("Selbootcamp@1234");
		return this;
	}
	
	public HomePage clickLoginButton() {
		WebElement eleLoginButton = driver.findElement(By.xpath("//input[@id='Login']"));	
		eleLoginButton.click();
		return new HomePage(driver,js,wait);
	}


}
