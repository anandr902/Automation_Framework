package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority = 2, groups = "Regression")
	public void testInvalidLogin() {
		String sheet = "InvalidLogin";
		String un = Excel.get_cell_val(XL_PATH, sheet, 1, 0);
		String pw = Excel.get_cell_val(XL_PATH, sheet, 1, 1);

		// Enter invalid user name
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);

		// Enter invalid password
		l.setPassword(pw);

		// click on Login
		l.clickLogin();

		// verify the error message is displayed
		l.verifyErrMsgIsDisplayed(driver);

	}

}
