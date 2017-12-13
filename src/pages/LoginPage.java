package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Automation_utility_libray;
import generic.BaseTest;
import generic.IAutoConst;

public class LoginPage implements IAutoConst {
	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(name = "pwd")
	private WebElement pwTB;

	@FindBy(xpath = ".//div[.='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath = ".//span[contains(.,'invalid')]")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickLogin() {
		loginBTN.click();
	}

	public void verifyErrMsgIsDisplayed(WebDriver driver) {
		String strETO = Automation_utility_libray.getProperty(SETTINGS_PATH, "ETO");
		long ETO = Long.parseLong(strETO);
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Error message is displayed", true);
		} catch (Exception e) {
			Reporter.log("Error message is not displayed", true);
			Assert.fail();
		}
	}

}
