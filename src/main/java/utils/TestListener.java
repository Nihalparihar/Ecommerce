package utils;
import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

     ExtentReports extentReports;
    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
        extentReports=ExtentReportNG.getExtentReport();
        extentReports.createTest(result.getMethod().getMethodName());
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test passes
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
        System.out.println("Test Failed: " + result.getName());
        // Example: Capture screenshot or log error here
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: implement if needed
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any test starts
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all tests finish
        System.out.println("Test Suite Finished: " + context.getName());
        extentReports.flush();
    }
}
