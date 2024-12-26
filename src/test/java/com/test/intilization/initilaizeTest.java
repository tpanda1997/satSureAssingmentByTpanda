package com.test.intilization;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.test.utilites.ExtentReportUtil;
import com.test.utilites.readProperty;



public class initilaizeTest {
	
	public Logger logger= LogManager.getLogger(this.getClass());
	
	public static WebDriver driver ;
	readProperty read= new readProperty();
	ExtentReportUtil extentReport = new ExtentReportUtil();
	
	
	@BeforeSuite
	public void initialization() {
		
		lunchBrowser();
		extentReport.extentReportStart();
		
		
	}
	
	
	
  public void lunchBrowser() {
	 
	  switch (read.readResources("config").getString("Browser").toLowerCase()) {
	  
	case "chrome":
		
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();;
		break;
     case "edge":
		
    	 driver = new EdgeDriver();
    	  driver.manage().window().maximize();
		break;	
	
	default : 
		logger.info("invalid browser name");
		break;
	}
	  
	  
	
  }
	

	@BeforeTest
	public void getUrl() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(read.readResources("config").getString("url"));	
		
	}
	
	
	@AfterSuite
	public void testCloser() {
		
		driver.quit();
		extentReport.endTestReport();
	}

}
