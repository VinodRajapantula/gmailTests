package myListners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import scenarios.TestBase;

public class MyTestListner extends TestBase implements ITestListener{
	
	/*WebDriver driver;
	public MyTestListner(WebDriver driver){
		this.driver = driver;
	}*/
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Listner Testcase Pass" +result.getTestName() );
		log.info("Listner Testcase Pass:");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Listner Testcase failed:" +result.getMethod() );
		log.info("Listner Testcase Fail:");
		//driver.quit();
		closeDriver();
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
		
	}

}
