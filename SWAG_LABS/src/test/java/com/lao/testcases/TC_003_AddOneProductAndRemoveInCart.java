package com.lao.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TC_003_AddOneProductAndRemoveInCart extends CommonFunctions {

	@Test
	public void addOneProductAndRemoveInCart() {
		inventory.clickOnBackPackLink();
		inventory.clickOnAddBtnForBackPack();
		inventory.clickOnCartIcon();
		cart.clickOnRemoveButton();
		cart.clickOnContinueShopping();
	}
}
