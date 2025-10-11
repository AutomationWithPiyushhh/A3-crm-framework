package listeners_extra;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_extra.List_Imp.class)
public class Demo1Test {

	public WebDriver driver;
	public static WebDriver sdriver; //sdriver => null

	@BeforeClass
	public void openBro() {
		driver = new ChromeDriver();
		sdriver = driver; //sdriver ko value mil chuki he
	}

//	@Test
//	public void case1() {
//		Assert.assertTrue(true);
//		System.out.println("passed");
//	}

	@Test(retryAnalyzer = listeners_extra.Retry_Imp.class)
	public void case2() throws IOException {
		driver.get("https://www.amazon.in/");

		boolean status = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
		
		Assert.assertTrue(status);
	}
//
//	@Test(dependsOnMethods = "case2")
//	public void case3() {
//		System.out.println("skipped");
//		Assert.assertTrue(true);
//	}

	@AfterClass
	public void closeBro() {
		driver.quit();
	}

}
