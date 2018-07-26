package by.htp.utils;

import org.testng.Assert;
import org.testng.annotations.*;

import steps.Step;

public class AutomationTest {
	
	private Step steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();
	}

	@Test(description = "Login to Github")
	public void oneCanLogin() {
		steps.login(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
