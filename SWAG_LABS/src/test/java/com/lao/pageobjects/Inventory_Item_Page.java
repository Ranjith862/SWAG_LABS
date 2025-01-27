package com.lao.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_Item_Page {

	WebDriver driver;

	public Inventory_Item_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(@class,'inventory_details_back_button')]")
	private WebElement BACK_BUTTON_SAUCE_LABS_BACKPACK;

	public void clickOnBackBtn() {
		BACK_BUTTON_SAUCE_LABS_BACKPACK.click();
	}
}
