package gmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scenarios.TestBase;

public class LoginPage extends TestBase{
	WebDriver driver = null;

	@FindBy(xpath = "//input[@autocomplete='username']")
	WebElement txtUserName;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement btnNext;

	@FindBy(xpath = "//input[@type='password']")
	WebElement txtPassword;



	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String uname) {
		txtUserName.sendKeys(uname);
		log.info("UserName Entered");
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
		log.info("Password Entered");
	}
	
	public void clickOnNextButton() {
		btnNext.click();;
		log.info("UserName Entered");
	}

}
