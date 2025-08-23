package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
//		Login
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("password");
		
		driver.findElement(By.id("submitButton")).click();
		
//		Create an organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		String orgName = "qsp_" + (int)(Math.random()*1000);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
		
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if (actOrgName.equals(orgName)) {
			System.out.println("Created organization successfullyyyy!!!");
		} else {
			System.out.println("Could not be created org.  :(");
		}
		
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		
		Thread.sleep(50000);

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}
}
