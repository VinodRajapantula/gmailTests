package scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import myListners.MyTestListner;

public class TestBase {

	String browser = "chrome";
	String url = "http://gmail.com";
	public WebDriver driver = null;
	String log4jConfPath = "log4j.properties";
	public static Logger log = null;
	//MyTestListner myTestListner = null;
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./src/main/java/myReports/extentReport.html");;
	public static ExtentReports extent = null;

	
	public void init() throws IOException {		
		PropertyConfigurator.configure(log4jConfPath);
		log = Logger.getRootLogger();
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		getBrowser();
		getUrl(url);
		System.out.println("driver: " + driver);
		//myTestListner = new MyTestListner(driver);
	}

	public void getBrowser() {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome driver initiated");
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Driver initiated");
		}

		driver.manage().window().maximize();
		log.info("Driver maxmized");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("implicit timeout set");
		driver.manage().deleteAllCookies();
		log.info("Deleted all cookies");

	}

	public void getUrl(String url) {
		driver.get(url);
		log.info("invoked base url");
	}
	
	
	public void closeDriver() {
		System.out.println("Close drver functon");
		log.info("Drver got closed");
		driver.quit();
		
	}
	
	/*@AfterClass(alwaysRun = true)
	public void endTest() {
		closeDriver();
	}*/

}
