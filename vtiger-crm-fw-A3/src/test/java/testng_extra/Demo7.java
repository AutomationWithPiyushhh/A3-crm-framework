package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo7 {
	
	
	@Parameters("browser")
	@Test
	public void login(String browser) throws InterruptedException {
//		String browser = "firefox";
		
		WebDriver driver ;
		
		if (browser.equals("edge")) {
			driver = new EdgeDriver();	
		}else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
