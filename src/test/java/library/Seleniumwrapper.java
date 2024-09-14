package library;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class Seleniumwrapper extends BaseClass {
	
	public Seleniumwrapper(WebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}
	
	
	public void type(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value, Keys.TAB);
			reportStep("The data " + value + " is successfully entered" , "PASS");
		}
		catch(Exception e) {
			e.printStackTrace();
			reportStep("The data " + value + " is not successfully entered" , "PASS");
		}
	}
	
	public boolean verifyDisplayWithreturn(WebElement element) {
		boolean result = false;
		String text = "";
		
		try {
			text = element.getText();
			if(element.isDisplayed()) {
				reportStep("The element " + text + " is visible", "PASS");
				result = true;
				return result;
			}
			else {
				reportStep("The element " + text + " is not visible", "FAIL");
				result = false;
				return result;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}
	
	public void click(WebElement element) {
		
		String text = "";
		try {
			text = element.getText();
			element.click();
			reportStep("The element " + text + " is clicked successfully", "PASS");
		}
		catch(Exception e) {
			e.printStackTrace();
			reportStep("The element " + text + " is not clicked", "FAIL");
		}
	}

}
