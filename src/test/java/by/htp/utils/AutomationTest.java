package by.htp.utils;

import org.testng.Assert;
import org.testng.annotations.*;

import steps.Step;

public class AutomationTest {
	
	private Step steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
<<<<<<< HEAD
	private final String confirmSendingEmail = "Ваше письмо отправлено";
	private final String emailTo = "ogulikpurse@gmail.com";
=======
	private final String NEWEMAIL = "Новое письмо";
	
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();
	}

<<<<<<< HEAD
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
=======
	@Test(groups = {"init"}, description = "Login to Email")
	public void oneCanLogin() {
		steps.login(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}
	@Test//(dependsOnGroups = {"init"})
	public void checkNewEmailPage() {
		Assert.assertTrue(steps.isMessagesInbox(NEWEMAIL));
	}
	
	@Test
	public void checkSendEmail() {
		steps.sendEmail();
		System.out.println("I entered");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
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
