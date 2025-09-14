package organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		String orgName = fUtil.getDataFromExcelFile("Org", 8, 0) + (int) (Math.random() * 9999);

//		Browser Opening
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		OrgPage op = new OrgPage(driver);
		VerifyOrgPage vop = new VerifyOrgPage(driver);

		driver.get(URL);

//		Login
		lp.login(USERNAME, PASSWORD);

//		Create an organization
		hp.getOrgLink().click();

		op.getPlusIcon().click();

		WebElement orgField = op.getOrgField();
		orgField.sendKeys(orgName);
		op.getSaveBtn().click();

		String actOrgName = vop.getActOrgName();
		if (actOrgName.equals(orgName)) {
			System.out.println("Created organization successfullyyyy!!!");
		} else {
			System.out.println("Could not be created org.  :(");
		}

//		Logout
		WebElement profile = hp.getProfile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		hp.getSignOut().click();

		Thread.sleep(2000);
		driver.quit();
	}
}
