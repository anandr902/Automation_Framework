package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class CheckProductVersion extends BaseTest {
	@Test(priority = 3, groups = "Regression")
	public void testCheckProductVersion() {

		String sheet = "CheckProductVersion";
		String un = Excel.get_cell_val(XL_PATH, sheet, 1, 0);
		String pw = Excel.get_cell_val(XL_PATH, sheet, 1, 1);
		String eVersion = Excel.get_cell_val(XL_PATH, sheet, 1, 2);
		// Enter valid user name
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);

		// Enter valid password
		l.setPassword(pw);

		// click on login
		l.clickLogin();

		// click on help
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickHelp();

		// click on about your actiTIME
		e.clickAboutActiTIME();
		// verify the product version
		e.verifyVersion(eVersion);

		// click on close button

		// click on logout

	}

}
