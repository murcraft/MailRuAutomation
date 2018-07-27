package by.htp.utils;

import org.testng.Assert;
import org.testng.annotations.*;

import steps.Step;

public class AutomationTest {
	
	private Step steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	private final String confirmSendingEmail = "Ваше письмо отправлено";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();
	}

	@Test(description = "Login to Github")
	public void checkLogin() {
		steps.login(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}
	
	@Test
	public void checkSendMessage() {
		System.out.println("Check sending megssage:");
		steps.composeMessage();
		Assert.assertEquals(steps.descriptionOfConfirm(), confirmSendingEmail.toLowerCase());
	}

//	@AfterMethod(description = "Stop Browser")
//	public void stopBrowser() {
//		steps.closeDriver();
//	}

}
