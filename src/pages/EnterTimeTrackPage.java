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
import generic.IAutoConst;

public class EnterTimeTrackPage implements IAutoConst {
	@FindBy(xpath = "//div[contains(text(),'Help')]")
	private WebElement help;

	@FindBy(linkText = "About your actiTime")
	private WebElement aboutActiTIME;

	@FindBy(xpath = "//span[starts-with(.,'actiTIME')]")
	private WebElement productVersion;

	@FindBy(id = "aboutPopupCloseButtonId")
	private WebElement closeBTN;

	@FindBy(id = "logoutLink")
	private WebElement logoutLink;

	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickHelp() {
		help.click();
	}

	public void clickAboutActiTIME() {
		aboutActiTIME.click();
	}

	public void verifyVersion(String eVerision) {
		String aVersion = productVersion.getText();
		Assert.assertEquals(eVerision, aVersion);
	}

	public void clickClose() {
		closeBTN.click();
	}

	public void verifyTitle(WebDriver driver, String eTitle) {
		String strETO = Automation_utility_libray.getProperty(SETTINGS_PATH, "ETO");
		long ETO = Long.parseLong(strETO);
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching", true);
		} catch (Exception e) {
			Reporter.log("Title is not matching", true);
			Assert.fail();
		}

	}
}
