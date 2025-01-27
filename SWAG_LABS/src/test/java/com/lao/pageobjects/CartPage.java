package com.lao.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart_footer']/child::a[contains(text(),'CHECKOUT')]")
	private WebElement CHECKOUT_LINK;

	// for single remove button
	@FindBy(xpath = "//button[contains(text(),'REMOVE')]")
	private WebElement REMOVE_BUTTON;

	// for multiple remove buttons
	@FindBys(@FindBy(xpath = "//button[contains(text(),'REMOVE')]"))
	private List<WebElement> REMOVE_BUTTONS;

	@FindBy(xpath = "//a[contains(text(),'Continue Shopping')]")
	private WebElement CONTINUE_SHOPPING;

	public void clickOnCheckOutButton() {
		CHECKOUT_LINK.click();
	}

	public void clickOnContinueShopping() {
		CONTINUE_SHOPPING.click();
	}

	// for single remove button
	public void clickOnRemoveButton() {
		REMOVE_BUTTON.click();
	}

	// for multiple remove buttons
	public void removeMultipleItems() {
		for (WebElement clickRemoveBtns : REMOVE_BUTTONS) {
			clickRemoveBtns.click();
		}
	}

}
