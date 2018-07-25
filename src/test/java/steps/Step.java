package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.driver.DriverSingleton;
import by.htp.pages.LoginPage;

public class Step {
	
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void login(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.login(username, password);
	}

//	public boolean isLoggedIn(String username)
//	{
//		LoginPage loginPage = new LoginPage(driver);
//		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
//		logger.info("Actual username: " + actualUsername);
//		return actualUsername.equals(username);
//	}



}
