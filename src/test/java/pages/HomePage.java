package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	By homeIcon = By.className("oxd-brand-banner");
	By administrator = By.xpath("//span[text()='Admin']");
	By pim = By.xpath("//span[text()='PIM']");
	By logoutArrow = By.className("oxd-userdropdown-tab");
	By logout = By.xpath("//a[text()='Logout']");
	
	
	
	public HomePage validateAllElementsInHomePage() {
		if(driver.findElement(homeIcon).isDisplayed() && driver.findElement(administrator).isDisplayed() && driver.findElement(pim).isDisplayed()) {
			System.out.println("User is in home page");
		}
		else {
			System.out.println("User is not in Home page");
		}
		return this;
	}
	
	public LoginPage clickOnLogout() {
		driver.findElement(logoutArrow).click();
		driver.findElement(logout).click();
		return new LoginPage();
	}
	
	

}
