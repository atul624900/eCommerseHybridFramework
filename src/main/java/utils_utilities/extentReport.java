package utils_utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extent = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		
		extent.attachReporter(spark);
		
		return extent;

	}

}
