package com.lao.commonfunctions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.lao.commonutils.CommonUtils;
import com.lao.constants.ConstantsVariables;
import com.lao.pageobjects.CartPage;
import com.lao.pageobjects.CheckOut_Complete_Page;
import com.lao.pageobjects.CheckOut_Step_One_Page;
import com.lao.pageobjects.CheckOut_Step_Two_Page;
import com.lao.pageobjects.InventoryPage;
import com.lao.pageobjects.Inventory_Item_Page;
import com.lao.pageobjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {

	protected static WebDriver driver;
	protected static LoginPage login;
	protected static InventoryPage inventory;
	protected static Inventory_Item_Page inventory_item;
	protected static CartPage cart;
	protected static CheckOut_Step_One_Page checkout_step_one;
	protected static CheckOut_Step_Two_Page checkout_step_two;
	protected static CheckOut_Complete_Page checkout_complete;

	@BeforeSuite
	public void launchBrowser() throws IOException {

		CommonUtils.loadProperties();
		if (ConstantsVariables.BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (ConstantsVariables.BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(ConstantsVariables.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objectVariables();
		login();
	}

	@BeforeClass
	public void navigateToInventoryPage() {
		// User is in inventory page
		driver.navigate().to(ConstantsVariables.INVENTORY_URL);
	}

	@AfterSuite
	public void tearDown() {
		inventory.logOut();
		driver.quit();
	}

	protected void login() {
		// User login with valid credentials
		login.enterUsername(ConstantsVariables.USERNAME);
		login.enterPassword(ConstantsVariables.PASSWORD);
		login.clickLoginButton();
	}

	public void objectVariables() {
		login = new LoginPage(driver);
		inventory = new InventoryPage(driver);
		inventory_item = new Inventory_Item_Page(driver);
		cart = new CartPage(driver);
		checkout_step_one = new CheckOut_Step_One_Page(driver);
		checkout_step_two = new CheckOut_Step_Two_Page(driver);
		checkout_complete = new CheckOut_Complete_Page(driver);
	}
}
