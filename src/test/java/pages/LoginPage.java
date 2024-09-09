package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	By userName = By.name("username");
	By password = By.name("password");
	By login = By.xpath(" //button[text()=' Login ']");
	By forgotPassword = By.xpath("//p[text()='Forgot your password? ']");
	By webSiteLink = By.xpath("//a[text()='OrangeHRM, Inc']");
	
	
}
