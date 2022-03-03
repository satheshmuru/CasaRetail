package EngineComponent;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.mongodb.util.Util;

import UtilisComponent.UIUtilis;

import org.testng.annotations.BeforeMethod;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Runner extends UIUtilis{
 
  @BeforeMethod
  public void Initialset(ITestContext context) {
	  //Browser Setup
	  test=extent.createTest("Verify Creation of orders");
	  browserlaunch("chrome");
	  GetURL(getpropvalue("URL"));
	   }

  @AfterMethod
  public void afterMethod() {
	  // Extent Report Flush
	 driver.close();
	  ExtentReportFinisher();
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  
	  //Extent Report and Other Environment SetUp 
	  ExtentReportStarter();
  }

  @AfterSuite
  public void afterSuite() {
	// Extent Report Flush and Killing the other Operation Setup
	ExtentReportFinisher();
	  
  }

}
