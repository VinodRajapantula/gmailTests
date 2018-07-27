package scenarios;

import java.io.IOException;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import gmailPages.HomePage;
import gmailPages.LoginPage;

public class Test1 extends TestBase {
	
	
	ExtentTest logger = null;
	@BeforeClass
	public void setUp() throws IOException {
	      init(); 
	      logger = extent.createTest("Test1");
	}
	
	
	@Test
	public void myFirstTest() throws InterruptedException{
		String uname = "vinodrtest1234@gmail.com";
		String password = "Test#1234";
		log.info("FirstTest started");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(uname);
		loginPage.clickOnNextButton();
		Thread.sleep(2000);
		loginPage.enterPassword(password);
		loginPage.clickOnNextButton();
		Thread.sleep(2000);
		HomePage homePage = new HomePage (driver);
		
		if(homePage.composeButtonExists()){
			log.info("myFirstTest got Passed");
			logger.log(Status.PASS, "Test1 Pass");
		}else{
			log.error("myFirstTest got Failed");
			logger.log(Status.FAIL, "Test1 Fail");
		}
		
		closeDriver();
		extent.flush();
	}
	
	/*@AfterClass
	public void endTest() {
		closeDriver();
	}*/

}
