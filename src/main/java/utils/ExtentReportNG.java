package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportNG {

    private static ExtentReports extentReports;

    public static ExtentReports getExtentReport() {
        if (extentReports == null) {
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Functional Test Results");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            // System Info
            extentReports.setSystemInfo("Browser", "Chrome");
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("User", System.getProperty("user.name"));

            // Safe check for property reader
            try {
                extentReports.setSystemInfo("Environment", PropertyReader.getValue("url"));
            } catch (Exception e) {
                extentReports.setSystemInfo("Environment", "Not Available");
            }
        }
        return extentReports;
    }
}
