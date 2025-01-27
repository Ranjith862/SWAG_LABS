package com.lao.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;
import com.lao.constants.ConstantsVariables;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TC_005_VerifyTheErrorMessageInCOInfo extends CommonFunctions {

	@Test
	public void verifyTheErrorMessageforFirstName() {
		addWithOutFirstName();
		String message = checkout_step_one.getErrorMessage();
		System.out.println(message);
		Assert.assertTrue(message.contains("First Name is required"), "Error message not displayed!");
		// navigate back
		driver.navigate().back();
	}

	@Test(priority = 1)
	public void verifyTheErrorMessageforLastName() {
		addWithOutLastName();
		String message = checkout_step_one.getErrorMessage();
		System.out.println(message);
		Assert.assertTrue(message.contains("Last Name is required"), "Error message not displayed!");
		// navigate back
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void verifyTheErrorMessageforZipCode() {
		addWithOutZipCode();
		String message = checkout_step_one.getErrorMessage();
		System.out.println(message);
		Assert.assertTrue(message.contains("Postal Code is required"), "Error message not displayed!");
		// navigate back
		driver.navigate().back();
	}

	@Test(priority = 3)
	public void verifyTheErrorMessageforEmptyfields() {
		addEmptyProduct();
		String message = checkout_step_one.getErrorMessage();
		System.out.println(message);
		Assert.assertTrue(message.contains("First Name is required"), "Error message not displayed!");
		// navigate back
		driver.navigate().back();
	}

	public void addWithOutFirstName() {
		// Add 1 product
		inventory.clickOnAddBtnForBackPack();
		// click on add to cart icon
		inventory.clickOnCartIcon();
		// click on checkout button
		cart.clickOnCheckOutButton();
		// add lastname and ZipCode
		checkout_step_one.addLastName(ConstantsVariables.LASTNAME_CHECKOUT);
		checkout_step_one.addZipCode(ConstantsVariables.ZIP_CODE_CHECKOUT);
		// click on continue button
		checkout_step_one.clickOnContinueButton();
	}

	public void addWithOutLastName() {
		// click on checkout button
		cart.clickOnCheckOutButton();
		// add lastname and ZipCode
		checkout_step_one.addFirstName(ConstantsVariables.FIRSTNAME_CHECKOUT);
		checkout_step_one.addZipCode(ConstantsVariables.ZIP_CODE_CHECKOUT);
		// click on continue button
		checkout_step_one.clickOnContinueButton();
	}

	public void addWithOutZipCode() {
		// click on checkout button
		cart.clickOnCheckOutButton();
		// add lastname and ZipCode
		checkout_step_one.addFirstName(ConstantsVariables.FIRSTNAME_CHECKOUT);
		checkout_step_one.addLastName(ConstantsVariables.LASTNAME_CHECKOUT);
		// click on continue button
		checkout_step_one.clickOnContinueButton();
	}

	public void addEmptyProduct() {
		// click on checkout button
		cart.clickOnCheckOutButton();
		// click on continue button
		checkout_step_one.clickOnContinueButton();
	}

}
