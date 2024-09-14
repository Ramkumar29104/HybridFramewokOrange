package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.Seleniumwrapper;

public class HomePage extends BaseClass {

	private By homeIcon = By.className("oxd-brand-banner");
	private By administrator = By.xpath("//span[text()='Admin']");
	private By pim = By.xpath("//span[text()='PIM']");
	private By logoutArrow = By.className("oxd-userdropdown-tab");
	private By logout = By.xpath("//a[text()='Logout']");
	public WebDriver driver;
	public ExtentTest node;
	Seleniumwrapper wrap;

	public HomePage(WebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		wrap = new Seleniumwrapper(driver, node);
	}

	public HomePage validateAllElementsInHomePage() {

		if (wrap.verifyDisplayWithreturn(driver.findElement(homeIcon))
				&& wrap.verifyDisplayWithreturn(driver.findElement(administrator))
				&& wrap.verifyDisplayWithreturn(driver.findElement(pim))) {
			System.out.println("User is in home page");
		}
		else {
			System.out.println("User is not in Home page");
		}
		return this;
	}

	public LoginPage clickOnLogout() {
		wrap.click(driver.findElement(logoutArrow));
		wrap.click(driver.findElement(logout));
		return new LoginPage(driver, node);
	}

}
