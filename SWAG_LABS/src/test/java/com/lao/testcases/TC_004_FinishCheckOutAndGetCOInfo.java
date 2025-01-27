package com.lao.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;
import com.lao.constants.ConstantsVariables;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TC_004_FinishCheckOutAndGetCOInfo extends CommonFunctions {

	@Test
	public void addProductFromInventoryPage() {
		// add 2 products
		inventory.clickOnAddBtnForBackPack();
		inventory.clickOnAddBtnForFleeceJacket();
		// click on cart icon
		inventory.clickOnCartIcon();
		// click on checkout button
		cart.clickOnCheckOutButton();
	}

	@Test(priority = 1)
	public void performCheckOutStepOne() {
		// enter user information
		checkout_step_one.addFirstName(ConstantsVariables.FIRSTNAME_CHECKOUT);
		checkout_step_one.addLastName(ConstantsVariables.LASTNAME_CHECKOUT);
		checkout_step_one.addZipCode(ConstantsVariables.ZIP_CODE_CHECKOUT);
		// click on continue button
		checkout_step_one.clickOnContinueButton();
	}

	@Test(priority = 2)
	public void getCheckOutInfoFromCheckOutStepTwo() {
		// get checkout information
		checkout_step_two.getCheckOutInformation();
	}

	@Test(priority = 3)
	public void clickOnFinish() {
		// click on finish button
		checkout_step_two.clickOnFinishBtn();

		String message = checkout_complete.getThankYouMessage();
		Assert.assertTrue(message.contains("THANK YOU"), "The process is not finished...");
	}

}
