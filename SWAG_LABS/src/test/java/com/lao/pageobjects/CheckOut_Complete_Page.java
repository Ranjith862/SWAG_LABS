package com.lao.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Complete_Page {
	WebDriver driver;

	public CheckOut_Complete_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(text(),'THANK YOU')]")
	private WebElement THANK_YOU_MESSAGE;

	public String getThankYouMessage() {
		return THANK_YOU_MESSAGE.getText();
	}
}
