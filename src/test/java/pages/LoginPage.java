package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.Seleniumwrapper;

public class LoginPage extends BaseClass {

	private By userName = By.name("username");
	private By password = By.name("password");
	private By login = By.xpath(" //button[text()=' Login ']");
	private By forgotPassword = By.xpath("//p[text()='Forgot your password? ']");
	private By webSiteLink = By.xpath("//a[text()='OrangeHRM, Inc']");
	private By errorMsg = By.xpath("//p[text()='Invalid credentials']");
	private WebDriver driver;
	private ExtentTest node;
	Seleniumwrapper wrap;

	public LoginPage(WebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		wrap = new Seleniumwrapper(driver, node);
	}

	public boolean validateAllTheElementsInLoginPage() {

		if (wrap.verifyDisplayWithreturn(driver.findElement(userName))
				&& wrap.verifyDisplayWithreturn(driver.findElement(password))
				&& wrap.verifyDisplayWithreturn(driver.findElement(login))
				&& wrap.verifyDisplayWithreturn(driver.findElement(forgotPassword))
				&& wrap.verifyDisplayWithreturn(driver.findElement(webSiteLink))) {
			return true;
		} else {
			return false;
		}
	}

	public LoginPage enterUserName(String uName) {
		wrap.type(driver.findElement(userName), uName);
		return this;
	}

	public LoginPage enterPassword(String pword) {
		wrap.type(driver.findElement(password), pword);
		return this;
	}

	public HomePage validLogin() {
		wrap.click(driver.findElement(login));
		return new HomePage(driver, node);
	}

	public LoginPage inValidLogin() throws Exception {
		wrap.click(driver.findElement(login));
		Thread.sleep(5000);
		return this;
	}

	public boolean validateErrorMessage() {
		if (wrap.verifyDisplayWithreturn(driver.findElement(errorMsg))) {
			return true;
		} else {
			return false;
		}
	}
}
