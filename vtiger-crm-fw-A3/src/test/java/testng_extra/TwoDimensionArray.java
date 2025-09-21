package testng_extra;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoDimensionArray {

	@Test(dataProvider = "studData")
	public void fbLogin(String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		Actions act = new Actions(driver);
		act.sendKeys(username + Keys.TAB + password).build().perform();

		Thread.sleep(1000);
		driver.quit();

	}

	@DataProvider
	public Object[][] studData() {
		Object[][] stud = new Object[3][2];

		stud[0][0] = "dinga";
		stud[0][1] = "dingi@123";

		stud[1][0] = "dingi";
		stud[1][1] = "dinga@123";

		stud[2][0] = "dingu";
		stud[2][1] = "DingaLovesDingi";

		return stud;
	}
}
