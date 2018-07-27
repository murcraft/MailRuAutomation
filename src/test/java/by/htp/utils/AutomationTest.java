package by.htp.utils;

import org.testng.Assert;
import org.testng.annotations.*;

import steps.Step;

public class AutomationTest {
	
	private Step steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	private final String confirmSendingEmail = "Ваше письмо отправлено";
	private final String emailTo = "ogulikpurse@gmail.com";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();
	}

	@Test(description = "Login to MailRu")
	public void checkLogin() {
		steps.login(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}
	
	@Test(description = "SendMessage")
	public void checkSendMessage() {
		System.out.println("Check sending megssage:");
		steps.composeMessage();
		Assert.assertEquals(steps.descriptionOfConfirm(), confirmSendingEmail.toLowerCase());
	}
	
	@Test(description = "Check message in Outbox")
	public void checkSendMessageInBox() {
		System.out.println("Check sending megssage in the SendBox:");
		Assert.assertEquals(steps.goToSendMessages(), emailTo);
	}

//	@AfterMethod(description = "Stop Browser")
//	public void stopBrowser() {
//		steps.closeDriver();
//	}

}
