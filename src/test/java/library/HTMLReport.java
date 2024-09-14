package library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class HTMLReport {

	public static ExtentSparkReporter html;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public String author, category;
	public String reportPath = "./report/Orange.html";

	public void startReport() {
		html = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	public void endReport() {
		extent.flush();
	}

	public ExtentTest startTestCase(String testCaseName, String testCaseDescription) {
		test = extent.createTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}

	public ExtentTest startTestCase(String module) {
		node = extent.createTest(module);
		return node;
	}

	public void reportStep(String desc, String status) {
		try {
			if (status.equalsIgnoreCase("pass")) {
				System.out.println("This testcase is passed");
				// test.pass(desc,
				// MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

			} else if (status.equalsIgnoreCase("fail")) {
				test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else {
				node.info(desc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract String takeScreenshot();

}
