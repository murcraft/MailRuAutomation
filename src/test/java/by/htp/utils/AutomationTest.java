package by.htp.utils;

import org.testng.Assert;
import org.testng.annotations.*;

import steps.Step;

public class AutomationTest {
	
	private Step steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	private final String NEWEMAIL = "Новое письмо";
	

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();
	}

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
	}

}
