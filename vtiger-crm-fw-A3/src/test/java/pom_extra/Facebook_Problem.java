package pom_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook_Problem {	
//	Declaration
	@FindBy(id = "email")
	private WebElement un;

	public WebElement getUn() {
		return un;
	}

//	Initialization
	public Facebook_Problem(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

//		declaration & initialization
//		WebElement un = driver.findElement(By.id("email"));
//		driver.navigate().refresh();

//		RE-INILIAZATION.
//		un = driver.findElement(By.id("email"));

		

		Facebook_Problem fp = new Facebook_Problem(driver);

//		Declaration & Initialization
		WebElement un = fp.getUn();

		driver.navigate().refresh();
		
//		Utilization
		un.sendKeys("admin");

		Thread.sleep(3000);
		driver.quit();
	}
}