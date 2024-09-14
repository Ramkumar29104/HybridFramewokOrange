package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import library.HTMLReport;
import utility.ExcelReader;

public class BaseClass extends HTMLReport {

	public WebDriver driver;
	public int browser = 1;
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	public String excelName = "";
	public String sheetName = "";
	public String testcaseName, testCaseDescription,module;
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void endreport() {
		endReport();
	}

	@BeforeClass
	public void invokeBrowser() {

		switch (browser) {
		case 1:

			System.out.println("User option is " + browser + ". So, Invoking the Chrome Browser");
			System.setProperty("webdriver.chrome.driver",
			"/home/ramkumarra/eclipse-workspace/HybridFrameworkOrange/src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();
			break;

		case 2:
			System.out.println("User option is " + browser + ". So, Invoking the Opera Browser");
			// System.setProperty("webdriver.chrome.driver",
			// "/home/ramkumarra/eclipse-workspace/HybridFrameworkOrange/src/test/resources/drivers/operadriver");
			break;

		default:
			System.out.println("The browser is not decided");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.navigate().to(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // for the entire page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // for the element which is going to  interacted
		startTestCase(testcaseName, testCaseDescription);
		startTestCase(module);
		
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="ExcelData")
	public Object[][] excelReader() {
		Object[][] value = ExcelReader.getValueFromExcel(excelName);
		return value;
	}

	@Override
	public String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/img" + System.currentTimeMillis() + ".png";
		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(source, dest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}
	

}
