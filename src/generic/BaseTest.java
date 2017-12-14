package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void OpenApplication(@Optional("chrome") String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {
			driver = new FirefoxDriver();
		}
		String AUT = Automation_utility_libray.getProperty(SETTINGS_PATH, "AUT");
		String strITO = Automation_utility_libray.getProperty(SETTINGS_PATH, "ITO");
		long ITO = Long.parseLong(strITO);
		String strPLTO = Automation_utility_libray.getProperty(SETTINGS_PATH, "PLTO");
		long PLTO = Long.parseLong(strPLTO);
		driver.get(AUT);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PLTO, TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun = true)
	public void CloseApplication(ITestResult res) {
		String testName = res.getName();
		if (res.getStatus() == 2) {
			Automation_utility_libray.takePhoto(PHOTO_PATH, testName, driver);
		}

		driver.quit();

	}

}
