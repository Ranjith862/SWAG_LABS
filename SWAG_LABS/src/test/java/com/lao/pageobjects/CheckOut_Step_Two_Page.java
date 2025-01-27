package com.lao.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Step_Two_Page {
	WebDriver driver;

	public CheckOut_Step_Two_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart_list']")
	private List<WebElement> QTY_DESCRIPTION_OF_PRODUCTS;

	@FindBy(xpath = "//div[@class='summary_info']/div[not(@class='cart_footer')]")
	private List<WebElement> CHECKOUT_INFORMATION;

	@FindBy(xpath = "//div[@class='cart_footer']/child::a[contains(text(),'FINISH')]")
	private WebElement FINISH_BUTTON;


	public void getCheckOutInformation() {
		for (WebElement productInfo : QTY_DESCRIPTION_OF_PRODUCTS) {
			String products = productInfo.getText();
			System.out.println("Product Details: " + products);
		}

		for (WebElement info : CHECKOUT_INFORMATION) {
			String checkOutInfo = info.getText();
			System.out.println("Checkout Details: " + checkOutInfo);
		}
	}

	public void clickOnFinishBtn() {
		FINISH_BUTTON.click();
	}

}
