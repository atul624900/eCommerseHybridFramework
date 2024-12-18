package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import comPages.BaseClass;
import utils_utilities.extentReport;

public class MyListeners implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	//public WebDriver driver;
	//private WebDriver driver2;
	@Override
	public void onStart(ITestContext context) {
		
		report = extentReport.generateExtentReport();

	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testname=result.getName();
		 test = report.createTest(testname);
		 test.log(Status.INFO, testname+"start executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		  test = report.createTest(testname);
		 test.log(Status.PASS, testname+"test got successfully executed");
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testname=result.getName();
		  test = report.createTest(testname);
		
		WebDriver driver = null;
		try {
		  driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		 
		File srcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShot = System.getProperty("user.dir")+"\\screenshot\\"+testname+".png";
		try {
			FileHandler.copy(srcScreenShot, new File(screenShot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShot);
		test.log(Status.INFO, result.getThrowable());
		 test.log(Status.FAIL, testname+"test fail");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		 ExtentTest test = report.createTest(testname);
		 test.log(Status.INFO,result.getThrowable());
		 test.log(Status.SKIP,  testname+"start executing");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Test execution finished");
		report.flush();
		String extentReportPath = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html";
		File ExtentReport = new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(ExtentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}



