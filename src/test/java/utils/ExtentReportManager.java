package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {
            ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "TutorialsNinja");
            extent.setSystemInfo("Tester", "Anjana");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
