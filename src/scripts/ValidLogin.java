package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest {
	@Test(priority = 1, groups = "smoke")
	public void testValidLogin() {
		String un = Excel.get_cell_val(XL_PATH, "ValidLogin", 1, 0);
		String pw = Excel.get_cell_val(XL_PATH, "ValidLogin", 1, 1);
		String eTitle = Excel.get_cell_val(XL_PATH, "ValidLogin", 1, 2);
		// Enter valid user name
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);
		// Enter the valid password
		l.setPassword(pw);
		// Click on login
		l.clickLogin();
		// verify the home page title
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.verifyTitle(driver, eTitle);

	}

}
