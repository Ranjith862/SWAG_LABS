package com.lao.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Step_One_Page {
	WebDriver driver;

	public CheckOut_Step_One_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='checkout_info']/child::input[@id='first-name']")
	private WebElement FIRST_NAME;

	@FindBy(xpath = "//div[@class='checkout_info']/child::input[@id='last-name']")
	private WebElement LAST_NAME;

	@FindBy(xpath = "//div[@class='checkout_info']/child::input[@id='postal-code']")
	private WebElement ZIP_CODE;

	@FindBy(xpath = "//div[@class='checkout_buttons']/child::input[@class='btn_primary cart_button']")
	private WebElement CONTINUE_BUTTON;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement ERROR_MESSAGE_CHECKOUT;

	@FindBy(xpath = "//h3[@data-test='error']/child::button/child::*")
	private WebElement ERROR_ICON;

	public void addFirstName(String firstName) {
		FIRST_NAME.sendKeys(firstName);
	}

	public void addLastName(String lastName) {
		LAST_NAME.sendKeys(lastName);
	}

	public void addZipCode(String zipCode) {
		ZIP_CODE.sendKeys(zipCode);
	}

	public void clickOnContinueButton() {
		CONTINUE_BUTTON.click();
	}

	public String getErrorMessage() {
		return ERROR_MESSAGE_CHECKOUT.getText();
	}

	public void clickOnErrorIcon() {
		ERROR_ICON.click();
	}
}
