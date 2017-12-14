package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority = 2, groups = "Regression")
	public void testInvalidLogin() {
		String sheet = "InvalidLogin";
		int rc = Excel.get_Row(XL_PATH, sheet);
		LoginPage l = new LoginPage(driver);
		for (int i = 1; i <= rc; i++) {
			String un = Excel.get_cell_val(XL_PATH, sheet, i, 0);
			String pw = Excel.get_cell_val(XL_PATH, sheet, i, 1);
			// Enter invalid user name
			l.setUserName(un);
			// Enter invalid password
			l.setPassword(pw);
			// click on Login
			l.clickLogin();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			// verify the error message is displayed
			l.verifyErrMsgIsDisplayed(driver);
		}
	}

}
