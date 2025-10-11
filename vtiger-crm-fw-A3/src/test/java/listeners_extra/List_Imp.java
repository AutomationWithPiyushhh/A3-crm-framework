package listeners_extra;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class List_Imp implements ISuiteListener, ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
//		System.out.println("DB conn + Rep config");

//		2025-10-11T17:40:52.746522400
//		174115_11102025

		String time = JavaUtility.getCurrentTime();

		ExtentSparkReporter spark = new ExtentSparkReporter("./Advance_reports/" + time + " .html");
		spark.config().setDocumentTitle("Demo");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("ATE", "Dinga");
		report.setSystemInfo("Browser", "Edge");
		report.setSystemInfo("O.S.", "Window");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("DB conn close + Rep backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "yayyy !!! " + methodName + " got passed....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Sheyyyyy !!! " + methodName + " got failed...");
		
//		TakesScreenshot tks = (TakesScreenshot) new Demo1Test().driver;
		TakesScreenshot tks = (TakesScreenshot) Demo1Test.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);

		String time = JavaUtility.getCurrentTime();
		test.addScreenCaptureFromBase64String(ss, time);
		
		
//		File src = tks.getScreenshotAs(OutputType.FILE);
//
//
//		File dest = new File("./errorShots/" + time + ".png");
//		try {
//			FileHandler.copy(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + " Got skipped....");
		TakesScreenshot tks = (TakesScreenshot) Demo1Test.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);

		String time = JavaUtility.getCurrentTime();
		test.addScreenCaptureFromBase64String(ss, time);

	}

}
