package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;

public class HomePage extends BaseMethods{

	public HomePage(WebDriver driver,JavascriptExecutor js,WebDriverWait wait) {
		this.driver = driver;
		this.js = js;
		this.wait = wait;
	}

	public HomePage clickToggleButton() {
		WebElement eleToggleButton = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		eleToggleButton.click();
		return this;
	}

	public HomePage clickViewAllOption() {
		WebElement eleViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		eleViewAll.click();
		return this;
	}

	public GroupsPage clickSales() {
		WebElement eleSales = driver.findElement(By.xpath("//p[@class='slds-truncate'][text()='Sales']"));
		eleSales.click();
		return new GroupsPage(driver,js,wait);
	}




}
