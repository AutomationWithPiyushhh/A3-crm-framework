package advance_reports_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SauceDemo {
	@Test
	public void loginSauce() {
		
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		driver.quit();
	}
}
