package gmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver = null;

	@FindBy(xpath = "//div[text()='COMPOSE']")
	WebElement btnCompose;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean composeButtonExists() {
		
		if(btnCompose.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}

}
