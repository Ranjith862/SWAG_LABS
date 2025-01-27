package com.lao.commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.lao.constants.ConstantsVariables;

public class CommonUtils {

	public static void loadProperties() throws IOException {
		FileInputStream fs = new FileInputStream("src/test/resources/config1.properties");
		Properties properties = new Properties();
		properties.load(fs);
		ConstantsVariables.BROWSER = properties.getProperty("browser");
		ConstantsVariables.URL = properties.getProperty("appurl");
		ConstantsVariables.USERNAME = properties.getProperty("usernameswag");
		ConstantsVariables.PASSWORD = properties.getProperty("passwordswag");
		ConstantsVariables.INVALID_USERNAME = properties.getProperty("invalidusername");
		ConstantsVariables.INVALID_PASSWORD = properties.getProperty("invalidpassword");

		ConstantsVariables.LOCKEDUSER = properties.getProperty("lockedUser");
		ConstantsVariables.PROBLEMUSER = properties.getProperty("problemuser");
		ConstantsVariables.PERFORMANCEGLITCHUSER = properties.getProperty("performanceglitchuser");

		ConstantsVariables.FIRSTNAME_CHECKOUT = properties.getProperty("firstName");
		ConstantsVariables.LASTNAME_CHECKOUT = properties.getProperty("lastName");
		ConstantsVariables.ZIP_CODE_CHECKOUT = properties.getProperty("zipCode");

		ConstantsVariables.INVENTORY_URL = properties.getProperty("inventoryURL");

	}
}
