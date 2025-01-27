package com.lao.loginTS;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;
import com.lao.constants.ConstantsVariables;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TS_002_LoginWithDiffUsername extends CommonFunctions {

	@Test
	public void tc_001_locked_out_user() {
		login.enterUsername(ConstantsVariables.LOCKEDUSER);
		login.enterPassword(ConstantsVariables.PASSWORD);
		login.clickLoginButton();

		// Get error message
		String errorMessage = login.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Epic sadface: Sorry, this user has been locked out."),
				"User logged in...");

		login.clickErrorIcon();
	}

	@Test(priority = 1)
	public void tc_002_problem_user() {
		login.enterUsername(ConstantsVariables.PROBLEMUSER);
		login.enterPassword(ConstantsVariables.PASSWORD);
		login.clickLoginButton();

		// Check with URL after user loggein
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("inventory"), "user not loggin");

		// logout
		inventory.logOut();
	}

	@Test(priority = 2)
	public void tc_003_performance_glitch_user() {
		login.enterUsername(ConstantsVariables.PERFORMANCEGLITCHUSER);
		login.enterPassword(ConstantsVariables.PASSWORD);
		login.clickLoginButton();

		// Check with URL after user loggein
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("inventory"), "user not loggin");

		// logout
		inventory.logOut();
	}
}
