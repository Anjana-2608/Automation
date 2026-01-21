package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class BaseTest {

	protected	WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite	
	public void setUpReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
		@BeforeMethod
		public void setUp(Method method) {
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("http://tutorialsninja.com/demo");
			
			if (extent == null) {
		        extent = ExtentReportManager.getReportInstance();
		    }
			test = extent.createTest(method.getName());
			
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			
			if(result.getStatus()==ITestResult.FAILURE) {
				test.fail(result.getThrowable());
			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.pass("Test passed");
			}
			driver.quit();
		}
		
		@AfterSuite
		public void flushReport(){
			extent.flush();
		}
	}


