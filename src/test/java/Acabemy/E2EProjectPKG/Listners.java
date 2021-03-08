package Acabemy.E2EProjectPKG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pkg_Resources.Base;
import pkg_Resources.ExtentReportNG;

public class Listners extends Base implements ITestListener{
	
	ExtentReports extent=ExtentReportNG.getReportObjects();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test=extent.createTest(result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Pass");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		test.fail(result.getThrowable());
		WebDriver driver=null;
		
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getScreenshotPath(testMethodName,driver);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
