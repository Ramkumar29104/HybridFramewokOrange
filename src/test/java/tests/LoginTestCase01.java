package tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTestCase01 extends BaseClass{
	
	
	@BeforeTest
	public void testSetup() {
		excelName = "login";
		testcaseName = "Login";
		testCaseDescription = "Validating Login Functionality";
		module = "Login module";
		author = "Ram Kumar";
		category = "Smoke";
		
	}
	
	
	@Test(priority = 1)
	public void validateAllElements() {
		
		boolean result = new LoginPage(driver, node).
		validateAllTheElementsInLoginPage();
		AssertJUnit.assertEquals(result, true);
	}
	
	@Test(priority = 2,dataProvider = "ExcelData")
	public void LoginwithCorrectCredentials(String userName, String password) {
		
		boolean result = new LoginPage(driver, node).
		enterUserName(userName).
		enterPassword(password).
		validLogin().
		validateAllElementsInHomePage().
		clickOnLogout().
		validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
		
	}
	
	@Test(priority = 3)
	public void LoginWithIncorrectcredentials() throws Exception {
		
		boolean result = new LoginPage(driver, node).
		enterUserName("fff").
		enterPassword("rrr").
		inValidLogin().
		validateErrorMessage();
		Assert.assertEquals(result, true);
		
		
		
	}

}
