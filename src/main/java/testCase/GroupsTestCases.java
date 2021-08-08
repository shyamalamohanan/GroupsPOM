package testCase;

import org.testng.annotations.Test;

import base.BaseMethods;
import pages.LoginPage;

public class GroupsTestCases extends BaseMethods {

	@Test
	public void verifyFunctionalityCreateGroupsWithoutMandatoryFields() {
		new LoginPage(driver,js,wait)
		.enterLoginName()
		.enterLoginPassword()
		.clickLoginButton()
		.clickToggleButton()
		.clickViewAllOption()
		.clickSales()
		.clickMoreTab()
		.clickGroups()
		.clickNew()
		.enterName("HK")
		.clickSave()
		.verifyDisplayedMessage();
	}

}
