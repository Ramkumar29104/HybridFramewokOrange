package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	public int browser = 1;
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	
	@BeforeClass
	public void invokeBrowser() {
		

		switch (browser) {
		case 1:
			
			System.out.println("User option is " + browser + ". So, Invoking the Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver = new ChromeDriver();
			break;

		case 2:
			System.out.println("User option is " + browser + ". So, Invoking the Opera Browser");
			System.setProperty("webdriver.chrome.driver", "./drivers/operadriver");
			driver = new ChromeDriver();
			break;
			
		default:
			System.out.println("The browser is not decided");
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));   //for the entire page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));    //for the element which is going to be interacted
		
		driver.navigate().to(url);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	

}
