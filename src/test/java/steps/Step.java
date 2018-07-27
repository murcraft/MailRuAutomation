package steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.driver.DriverSingleton;
<<<<<<< HEAD
import by.htp.pages.ComposeMessage;
=======
import by.htp.pages.ComposePage;
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
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
<<<<<<< HEAD
		System.out.println(loginPage.getUrlMainPage());
=======
		System.out.println(loginPage.getDriver().getCurrentUrl());
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
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

	public void composeMessage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.findWriteMessButton();
		ComposeMessage compMessage = new ComposeMessage(driver);
		compMessage.fillDestinationAddress();
		compMessage.findFrameTextEmail();
		compMessage.sendMessage();
	}
	
	public String descriptionOfConfirm() {
		ComposeMessage compMessage = new ComposeMessage(driver);
		return compMessage.getSendingConfirm();
	}
	
	public MainPage linkToInboxPage() {
		ComposeMessage compMessage = new ComposeMessage(driver);
		return compMessage.goToMainPage();
	}
	
	public String goToSendMessages() {
		MainPage page = linkToInboxPage();
		driver.switchTo().defaultContent();
		page.findOutbox();
		List<WebElement> list = page.findSendingMessages();
		String email = "";
		for(WebElement el : list) {
			email = el.getText();
			System.out.println(email);
		}
		return email;
	}


}
