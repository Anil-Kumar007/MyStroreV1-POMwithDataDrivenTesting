package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		System.out.println("Configuring Extent Reports...");
		
		ReadConfig readConfig = new ReadConfig();
		
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "EcommerceProjectTestReport-"+ timeStamp+".html";
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add system information/environment info to reports
		reports.setSystemInfo("Machine:", "Dell-Laptop_001");
		reports.setSystemInfo("O.S:", "Windows 10");
		reports.setSystemInfo("Browser:", readConfig.getBrowserName());
		reports.setSystemInfo("Developer:", "Anil Kumar");
		reports.setSystemInfo("Language and Tools:", "Java and Selenium");
		reports.setSystemInfo("Framework", "POMWithDataDrivenTesting");

		// Configuration to change look and feel of report
		htmlReporter.config().setReportName("Automation Test Scripts: ");
		htmlReporter.config().setDocumentTitle("Extent Listener Project HybridFramework Report.!!");
		htmlReporter.config().setDocumentTitle("This my first report.");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	// onStart() method is called when any test starts. It will run only one time
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On start method invoked...");
	}

	// onFinish() method after all t. It will run only one time
	public void onFinish(ITestContext Result) {
		System.out.println("On finish method invoked..");
		reports.flush();
		// It is mandatory to call flush() method to ensure information is written to
		// the started reporter.
	}

	// Whenever test cases failed this method will called.
	public void onTestFailure(ITestResult Result) {
//		System.out.println("Name of the test method failed: " + Result.getName());
		test = reports.createTest(Result.getName()); // to create entry in HTML Report
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test cases is: " + Result.getName(), ExtentColor.RED));

		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File screenshotFile = new File(screenShotPath);
		if (screenshotFile.exists()) {
			test.fail("Captured screenshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
		}

	}

	// Whenever test cases skipped this method will called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of the test method skipped: " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test cases is: " + Result.getName(), ExtentColor.YELLOW));
	}

	// When test cases get starts this method will called
	public void onTestStart(ITestResult Result) {
		System.out.println("Name of the test method started: " + Result.getName());
	}

	// When test cases passed, this method will called.
	public void onTestSuccess(ITestResult Result) {
//		System.out.println("Name of test method sucessfully executed: " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed test cases:" + Result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

}
