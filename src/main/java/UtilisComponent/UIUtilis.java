package UtilisComponent;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIUtilis {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String Currentdateandtime;
	public static WebDriver driver;
	
	
	public static String getpropvalue(String key) {
		String value = null;
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//input.properties");
			prop.load(ip);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String GetDateandTime() {
		DateFormat dateFormat = null;
		Date date = null;
		try {
			dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			date = new Date();
		} catch (Exception e) {
			System.out.println("Error in Getdateandtime : " + e.getMessage());
		}

		return dateFormat.format(date);
	}

	public static void ExtentReportStarter() {

		try {
			Currentdateandtime = GetDateandTime();
			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/UITestReport.html");
			// Create an object of Extent Reports
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Company", "Casa Retail");
			extent.setSystemInfo("Environment", "Production");
			htmlReporter.config().setDocumentTitle("Casa Retail Testing Report");
			htmlReporter.config().setTheme(Theme.STANDARD);
		} catch (Exception e) {
			System.out.println("Error in ExtentReportStarter : " + e.getMessage());
		}
	}

	public static void ExtentReportFinisher() {

		try {
			extent.flush();
		} catch (Exception e) {
			System.out.println("Error in ExtentReportFinisher : " + e.getMessage());
		}
	}

	public static boolean GetURL(String url) {
		boolean flag = false;
		try {
			driver.get(url);
			test.log(Status.PASS, "URL Launched Successfully : " + url);
			flag = true;
		} catch (Exception e) {

			System.out.println("Error in GetUrl : " + e.getMessage());
			test.log(Status.FAIL, "Error in GetUrl : " + e.getMessage());

		}
		return flag;
	}

	public static boolean typetext(WebElement element, String Text, String Lable) {
		boolean flag = false;
		try {
			if (waitfor(element, Lable)) {
				element.sendKeys(Text);
				test.log(Status.PASS, Text + "is  typed in " + Lable);
				flag = true;
			}
		} catch (Exception e) {

			System.out.println("Error in Typetext : " + e.getMessage());
			test.log(Status.FAIL, "Error in GetUrl : " + e.getMessage());

		}
		return flag;
	}
	
	public static boolean jstypetext(WebElement element, String Text, String Lable) {
		boolean flag = false;
		try {
			if (waitfor(element, Lable)) {
				((JavascriptExecutor)driver).executeScript("arguments[0].value='"+Text+"'",element); 
				test.log(Status.PASS, Text + "is  typed in " + Lable);
				flag = true;
			}
		} catch (Exception e) {

			System.out.println("Error in Typetext : " + e.getMessage());
			test.log(Status.FAIL, "Error in GetUrl : " + e.getMessage());

		}
		return flag;
	}

	public static boolean click(WebElement element, String Lable) {
		boolean flag = false;
		try {
			if (waitfor(element, Lable)) {
				element.click();
				;
				test.log(Status.PASS, Lable + "is Clicked");
				flag = true;
			}
		} catch (Exception e) {

			System.out.println("Error in click : " + e.getMessage());
			test.log(Status.FAIL, "Error in click : " + e.getMessage());

		}
		return flag;
	}

	public static boolean Switchtab()
	{
		boolean flag=false;
		try {
			String currentHandle= driver.getWindowHandle();
			Set<String> handles=driver.getWindowHandles();
			for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
			//Switch to the opened tab
			driver.switchTo().window(actual);
			}
			}
			test.log(Status.PASS,"Switch the Tab Successfully");
			flag=true;
			} 
			catch (Exception e) {
			
			System.out.println("Error in Switchtab : "+ e.getMessage());
			test.log(Status.FAIL, "Error in Switchtab : "+ e.getMessage());	
			
		}
		return flag;
	}

	public static boolean waitfor(WebElement element, String Lable) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(element));
			test.log(Status.PASS, Lable + " is Visible and Stable");
			flag = true;
		} catch (Exception e) {

			System.out.println("Error in waitfor : " + e.getMessage());
			test.log(Status.FAIL, "Error in Waitfor : " + e.getMessage());

		}
		return flag;
	}
	
	public static boolean elementnotpresent(WebElement element, String Lable) {
		boolean flag = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element));
			test.log(Status.FAIL, Lable + " is not displayed");
			flag = false;
		} catch (Exception e) {
			test.log(Status.PASS, Lable + " is displayed");

		}
		return flag;
	}

	public static void browserlaunch(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			else if (browsername.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			else if (browsername.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}

			else if (browsername.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			test.log(Status.PASS, "Browser Launch");

		} catch (Exception e) {

			System.out.println("Error in Browser Launch: " + e.getMessage());
			test.log(Status.FAIL, "Error in Browser Launch: " + e.getMessage());
		}

	}

}
