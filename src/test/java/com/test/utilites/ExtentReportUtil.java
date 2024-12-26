package com.test.utilites;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.intilization.initilaizeTest;

public class ExtentReportUtil  {
	


	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test; 
	
	private static ThreadLocal<ExtentTest> extentTestThread= new ThreadLocal<>();//
	private static ThreadLocal<ExtentReports> extentReportsThread= new ThreadLocal<>();
	
	public void extentReportStart() {
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date() );
		String reportName="Test-report-"+timeStamp+".html";
		
		sparkReporter= new ExtentSparkReporter(".\\reports\\"+reportName);
		sparkReporter.config().setDocumentTitle("selenium basic FW Test");
		sparkReporter.config().setReportName("selenium basic FW");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().thumbnailForBase64(true);// to make screensort display big on the report
		
		extent = new ExtentReports();
		extentReportsThread.set(extent);
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Automationexercise.com");
		extent.setSystemInfo("Operating system",System.getProperty("os.name"));
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviremnt","QA");
		extent.setSystemInfo("user","Tathagata");
	}
	
	
	public void startTestReport(String testName,String categoryName) {
		
	    test =  extentReportsThread.get().createTest(testName);
		extentTestThread.set(test);
		test.assignCategory(categoryName);
		test.createNode(testName);
		
	}
	
	public void info(String info) {
		
		extentTestThread.get().info(info);
		
	}
   public void log(String log, Status status) {
		
	   extentTestThread.get().log(status, log);
		
	}
   
   public void logInfoWithScreensort(String info ,WebDriver driver) {
	   
	   extentTestThread.get().info(info, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	   
   }
	
   
  public void logTestPass(String details ,WebDriver driver) {
	   
	  extentTestThread.get().log(Status.PASS,details, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	   
   }

  public void logTestFail(String details,WebDriver driver ) {
	   
	  extentTestThread.get().log(Status.FAIL,details, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	   
}
  

  public void endTestReport() {
	  
	  extent.flush();
	  
  }



}
