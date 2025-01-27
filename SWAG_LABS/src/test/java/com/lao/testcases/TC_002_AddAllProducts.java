package com.lao.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TC_002_AddAllProducts extends CommonFunctions {

	@Test
	public void addAllProducts() {
		inventory.clickAllAddToCartButtons();

		String message = inventory.getCartNumber();
		if (message.equalsIgnoreCase("6")) {
			System.out.println(message + " Cart Added");
		} else {
			System.out.println("Product Not added");
		}

		// click on cart icon
		inventory.clickOnCartIcon();
		cart.removeMultipleItems();
		// cart.clickOnContinueShopping();
	}
}
