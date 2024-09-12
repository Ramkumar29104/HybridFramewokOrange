package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	By userName = By.name("username");
	By password = By.name("password");
	By login = By.xpath(" //button[text()=' Login ']");
	By forgotPassword = By.xpath("//p[text()='Forgot your password? ']");
	By webSiteLink = By.xpath("//a[text()='OrangeHRM, Inc']");
	By errorMsg = By.xpath("//p[text()='Invalid credentials']");
	
	public boolean validateAllTheElementsInLoginPage() {
		
		if(driver.findElement(userName).isDisplayed() && driver.findElement(password).isDisplayed() && driver.findElement(login).isDisplayed() &&
				driver.findElement(forgotPassword).isDisplayed() && driver.findElement(webSiteLink).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String uName) {
		driver.findElement(userName).sendKeys(uName);
		return this;
	}
	
	public LoginPage enterPassword(String pword) {
		driver.findElement(password).sendKeys(pword);
		return this;
	}
	
	public HomePage validLogin() {
		driver.findElement(login).click();
		return new HomePage();
	}
	
	public LoginPage inValidLogin() throws Exception {
		driver.findElement(login).click();
		Thread.sleep(5000);
		return this;
	}
	
	public boolean validateErrorMessage() {
		if (driver.findElement(errorMsg).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
}
