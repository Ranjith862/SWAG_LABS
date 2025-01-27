package com.lao.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;

@Listeners(com.lao.testnglisteners.ListernerClass.class)
public class TC_001_GetAllProductsNameAndRate extends CommonFunctions {

	@Test
	public void getProductsNames() {
		inventory.getAllProductNamesAndPrices();
	}
}
