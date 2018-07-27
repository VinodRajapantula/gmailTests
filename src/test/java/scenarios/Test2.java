package scenarios;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import gmailPages.HomePage;
import gmailPages.LoginPage;

public class Test2 extends TestBase {
	
	ExtentTest logger1 = null;
	@BeforeClass
	public void setUp() throws IOException {
	      init(); 
	      logger1 = extent.createTest("Test2");
	}
	
	
	@Test
	public void mySecondTest() throws InterruptedException{
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
			logger1.log(Status.PASS, "Test2 Pass");
		}else{
			log.error("myFirstTest got Failed");
			logger1.log(Status.FAIL, "Test2 Fail");
		}
		
		closeDriver();
		extent.flush();
	}
	
	/*@AfterTest
	public void endTest() {
		closeDriver();
	}*/

}
