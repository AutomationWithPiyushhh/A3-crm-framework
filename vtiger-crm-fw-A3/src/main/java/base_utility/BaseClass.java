package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;

	@BeforeClass
	public void openBro() throws IOException {

		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");

//		Browser Opening
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
//		Logout
		WebElement profile = hp.getProfile();
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		hp.getSignOut().click();
	}

	@AfterClass
	public void closeBro() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
