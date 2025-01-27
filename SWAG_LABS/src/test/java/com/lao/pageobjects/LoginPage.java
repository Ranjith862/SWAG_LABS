package com.lao.pageobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form/child::input[@type='text']")
	private WebElement USERNAME_FIELD;

	@FindBy(xpath = "//form/child::input[@type='password']")
	private WebElement PASSWORD_FIELD;

	@FindBy(xpath = "//form/child::input[@type='submit']")
	private WebElement LOGIN_BUTTON;

	@FindBy(xpath = "//h3/child::button[@class='error-button']")
	private WebElement ERROR_BUTTON;

	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: ')]")
	private WebElement ERROR_MESSAGE;

	public void enterUsername(String uname) {
		USERNAME_FIELD.clear();
		USERNAME_FIELD.sendKeys(uname);
	}

	public void enterPassword(String pword) {
		PASSWORD_FIELD.clear();
		PASSWORD_FIELD.sendKeys(pword);
	}

	public void clickLoginButton() {
		LOGIN_BUTTON.click();
	}

	public void clickErrorIcon() {
		ERROR_BUTTON.click();
	}

	public String getErrorMessage() {
		return ERROR_MESSAGE.getText();
	}

}
