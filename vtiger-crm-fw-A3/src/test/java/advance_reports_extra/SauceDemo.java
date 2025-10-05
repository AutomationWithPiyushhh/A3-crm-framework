package advance_reports_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SauceDemo {
	WebDriver driver;
	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./errorShots/rep3.html");
		spark.config().setDocumentTitle("Demo");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("ATE", "Dinga");
		report.setSystemInfo("Browser", "Edge");
		report.setSystemInfo("O.S.", "Window");
	}

	@BeforeClass
	public void openBro() {
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
		driver = new EdgeDriver();
	}

	@Test(dataProvider = "getData")
	public void loginSauce(String un, String pwd) throws InterruptedException {
		ExtentTest test = report.createTest("loginSauce");		
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();

//		verify
		boolean status = driver.findElement(By.xpath("//*[local-name()='svg']")).isDisplayed();

		Assert.assertTrue(status); // AssertionError
		test.log(Status.PASS, "Passed....");
	}

	@Test
	public void demoRep() {
		ExtentTest test = report.createTest("demoRep");
		test.log(Status.INFO, "For your kind information...");
		test.log(Status.PASS, "Passed...");
		test.log(Status.WARNING, "Giving warning...");
		test.log(Status.SKIP, "Skipping...");
		test.log(Status.FAIL, "Failing...");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] cred = new Object[4][2];

		cred[0][0] = "standard_user";
		cred[0][1] = "secret_sauce";

		cred[1][0] = "locked_out_user";
		cred[1][1] = "secret_sauce";

		cred[2][0] = "problem_user";
		cred[2][1] = "secret_sauce";

		cred[3][0] = "performance_glitch_user";
		cred[3][1] = "secret_sauce";

		return cred;
	}

	@AfterClass
	public void closeBro() {
		driver.quit();
	}

	@AfterSuite
	public void repBackup() {
		report.flush();
		System.out.println("Report generated successfully!!!");
	}

}
