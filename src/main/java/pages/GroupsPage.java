package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseMethods;

public class GroupsPage extends BaseMethods {

	public GroupsPage(WebDriver driver,JavascriptExecutor js,WebDriverWait wait) {
		this.driver = driver;
		this.js = js;
		this.wait = wait;
	}

	public GroupsPage clickMoreTab() {
		WebElement eleMoreDropDown = driver.findElement(By.xpath("//span[@class='slds-p-right_small'][text()='More']"));
		eleMoreDropDown.click();
		return this;
	}

	public GroupsPage clickGroups() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement eleGroups = driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Groups']"));
		js.executeScript("arguments[0].click();", eleGroups);
		return this;
	}

	public GroupsPage clickNew() {
		WebElement eleNew = driver.findElement(By.xpath("//a[@role='button'][@title='New']"));
		eleNew.click();
		return this;
	}
	
	public GroupsPage enterName(String Name) {
		WebElement eleName = driver.findElement(By.xpath("//input[@type='text'][@aria-required='true']"));
		wait.until(ExpectedConditions.visibilityOf(eleName));
		eleName.sendKeys(Name);
		return this;
	}

	public GroupsPage clickSave() {
		WebElement eleSave = driver.findElement(By.xpath("//button//span[text()='Save & Next']"));
		eleSave.click();
		return this;
	}
	
	public GroupsPage verifyDisplayedMessage() {
		String expectedMsg = "These required fields must be completed: Access Type";
		WebElement eleErrorMsg = driver.findElement(By.xpath("//ul[@class='errorsList']//li"));
		String actualMsg = eleErrorMsg.getText();	
		Assert.assertEquals(actualMsg, expectedMsg, "The error message is not displayed as expected! Please Verify!!");
		return this;
	}
	
}
