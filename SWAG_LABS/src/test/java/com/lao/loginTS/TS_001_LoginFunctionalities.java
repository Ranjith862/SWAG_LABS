package com.lao.loginTS;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.lao.commonfunctions.CommonFunctions;
import com.lao.constants.ConstantsVariables;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TS_001_LoginFunctionalities extends CommonFunctions {

	@Test()
	public void tc_001_loginWithValidUnameAndInvalidPword() {
		// Valid Username and Invalid Password
		login.enterUsername(ConstantsVariables.USERNAME);
		login.enterPassword(ConstantsVariables.INVALID_PASSWORD);
		login.clickLoginButton();

		// Get error message
		String errorMessage = login.getErrorMessage();
		Assert.assertTrue(
				errorMessage.contains("Epic sadface: Username and password do not match any user in this service"),
				"Error message not shown");
		login.clickErrorIcon();
	}

	@Test(priority = 1)
	public void tc_002_loginWithInValidUnameAndValidPword() {
		// Invalid Username and Valid Password
		login.enterUsername(ConstantsVariables.INVALID_USERNAME);
		login.enterPassword(ConstantsVariables.PASSWORD);
		login.clickLoginButton();

		// Get error message
		String errorMessage = login.getErrorMessage();
		Assert.assertTrue(
				errorMessage.contains("Epic sadface: Username and password do not match any user in this service"),
				"Error message not shown");
		login.clickErrorIcon();

	}

	@Test(priority = 2)
	public void tc_003_loginWithInValidCredentials() {
		// Invalid Username and Invalid Password
		login.enterUsername(ConstantsVariables.INVALID_USERNAME);
		login.enterPassword(ConstantsVariables.INVALID_PASSWORD);
		login.clickLoginButton();

		// Get error message
		String errorMessage = login.getErrorMessage();
		Assert.assertTrue(
				errorMessage.contains("Epic sadface: Username and password do not match any user in this service"),
				"Error message not shown");
		login.clickErrorIcon();
	}

	@Test(priority = 3)
	public void tc_004_loginWithValidCredentials() {
		// Valid Username and Valid Password
		login.enterUsername(ConstantsVariables.USERNAME);
		login.enterPassword(ConstantsVariables.PASSWORD);
		login.clickLoginButton();

		// Check with URL after user loggein
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("inventory"), "user not loggin");

		// logout
		inventory.logOut();
	}

}
