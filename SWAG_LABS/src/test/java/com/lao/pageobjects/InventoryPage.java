package com.lao.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='bm-burger-button']/child::button[contains(text(),'Open')]")
	private WebElement OPEN_MENU;

	@FindBy(linkText = "Logout")
	private WebElement LOGOUT_LINK;

	@FindBys(@FindBy(xpath = "//a/div"))
	private List<WebElement> PRODUCTS;

	@FindBys(@FindBy(xpath = "//button[@class='btn_primary btn_inventory']"))
	private List<WebElement> ADD_TO_CART_BUTTONS;

	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	private WebElement CART_ICON;

	@FindBy(xpath = "//a[@id='item_4_title_link']/child::div[@class='inventory_item_name']")
	private WebElement SAUCE_LABS_BACKPACK;

	@FindBy(xpath = "(//button[contains(@class,'btn_primary btn_inventory')])[1]")
	private WebElement ADD_TO_BUTTON_SAUCE_LABS_BACKPACK;

	@FindBy(xpath = "(//div[@class='inventory_item_label']/descendant::div[contains(text(),'Fleece Jacket')]/following::button)[1]")
	private WebElement ADD_TO_BUTTON_SAUCE_LABS_FLEECE_JACKET;

	// for single remove button
	@FindBy(xpath = "//button[contains(text(),'REMOVE')]")
	private WebElement REMOVE_BUTTON;

	@FindBy(css = "svg path")
	private WebElement CART_ICON_SVG_PATH;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'inventory_item_price')]"))
	private List<WebElement> RATE_OF_PRODUCTS;

	public void logOut() {
		OPEN_MENU.click();
		LOGOUT_LINK.click();
	}

	public void getAllProductNamesAndPrices() {
		for (WebElement product : PRODUCTS) {
			String productName = product.getText();
			System.out.println("Product Name: " + productName);
		}
		for (WebElement rate : RATE_OF_PRODUCTS) {
			String price = rate.getText();
			System.out.println("Price: " + price);

		}
	}

	public void clickAllAddToCartButtons() {
		for (WebElement clickAddToCart : ADD_TO_CART_BUTTONS) {
			clickAddToCart.click();
		}
	}

	public String getCartNumber() {
		return CART_ICON.getText();
	}

	public void clickOnBackPackLink() {
		SAUCE_LABS_BACKPACK.click();

	}

	public void clickOnAddBtnForBackPack() {
		ADD_TO_BUTTON_SAUCE_LABS_BACKPACK.click();
	}

	public void clickOnAddBtnForFleeceJacket() {
		ADD_TO_BUTTON_SAUCE_LABS_FLEECE_JACKET.click();
	}

	public void clickOnCartIcon() {
		CART_ICON_SVG_PATH.click();
	}

	// for single remove button
	public void clickOnRemoveButton() {
		REMOVE_BUTTON.click();
	}

}
