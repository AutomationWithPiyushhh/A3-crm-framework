package organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {

////		Get the data from prop file
//		FileInputStream fis = new FileInputStream("./src\\test\\resources\\commondata.properties");
//
//		Properties pObj = new Properties();
//		pObj.load(fis);
//
//		String BROWSER = pObj.getProperty("bro");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("un");
//		String PASSWORD = pObj.getProperty("pwd");
		
		FileUtility fUtil = new FileUtility();
		
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
		
		
//		Get the data from excel file

//		FileInputStream fis1 = new FileInputStream("./src/test/resources/testScriptData.xlsx");
//
//		Workbook wb = WorkbookFactory.create(fis1);
//
//		Sheet sh = wb.getSheet("Org");
//
//		Row row = sh.getRow(5);
//
//		Cell cell = row.getCell(0);
//
//		String orgName = cell.getStringCellValue() + (int) (Math.random() * 1000);
//
//		wb.close();
		
		String orgName = fUtil.getDataFromExcelFile("Org", 8, 0) + (int)(Math.random()*9999);

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

//		Login
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

//		Create an organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

//		String orgName = "qsp_" + (int) (Math.random() * 1000);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Created organization successfullyyyy!!!");
		} else {
			System.out.println("Could not be created org.  :(");
		}

//		Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Thread.sleep(50000);

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(2000);

		driver.quit();

	}
}
