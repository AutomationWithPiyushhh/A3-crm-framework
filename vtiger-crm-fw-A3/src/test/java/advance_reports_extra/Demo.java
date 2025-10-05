package advance_reports_extra;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Demo {
	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./errorShots/rep4.html");
		spark.config().setDocumentTitle("Demo");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("ATE", "Dinga");
		report.setSystemInfo("Browser", "Edge");
		report.setSystemInfo("O.S.", "Window");
	}

	@Test
	public void case1() {
		ExtentTest test = report.createTest("case1");
		test.log(Status.PASS, "Passed....");
		Assert.assertTrue(true);
	}

	@Test
	public void case2() {
		ExtentTest test = report.createTest("case2");
		test.log(Status.FAIL, "Failed....");
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = "case2")
	public void case3() {
		ExtentTest test = report.createTest("case3");
		test.log(Status.SKIP, "Skipped....");
		Assert.assertTrue(true);
	}

	@AfterSuite
	public void repBackup() {
		report.flush();
		System.out.println("Report generated successfully!!!");
	}
}
