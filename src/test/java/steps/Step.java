package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.driver.DriverSingleton;
import by.htp.pages.ComposePage;
import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;

public class Step {
	
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		System.out.println(loginPage.getDriver().getCurrentUrl());
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}
	
	public boolean isMessagesInbox(String newEmail) {
		MainPage mainPage = new MainPage(driver );
		System.out.println(mainPage.getDriver().getCurrentUrl());
		String actualPage = mainPage.getMainPageSend();
		logger.info("Actual page: " + actualPage);
		return actualPage.contains(newEmail);
	}
	
	public void pressSendEmail() {
		
	}
	
	public void sendEmail() {
		MainPage mainPage = new MainPage(driver);
		ComposePage composePage = mainPage.findMessage();;
		composePage.fillDestinationAddress(); 
		composePage.findFrameTextEmail();
		
	}
	
	public boolean isSendBoxEmpty() {
		return true;
	}



}
