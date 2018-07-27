package by.htp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	
	private final Logger logger = LogManager.getRootLogger();
	private final String URL = "http://mail.ru/login";
	
	private WebElement inputLogin;
	private WebElement  inputPassword;
	private WebElement buttonSubmit;
	private WebElement linkLoggedInUser;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void open() {
		driver.navigate().to(URL);
		logger.info("Login performed");
	}
	
<<<<<<< HEAD
	public void login(String username, String password) {
		driver.switchTo().frame(driver.findElement(By.className("ag-popup__frame__layout__iframe")));
		fillLogin(username);
		fillPass(password);
		buttonSubmit = driver.findElement(By.xpath("//div[@class='c0130 c0131']/descendant::button"));
		buttonSubmit.click();
	}
	
	public void fillLogin(String username) {
		
		inputLogin = driver.findElement(By.xpath("*//div[@class='login-row username']/descendant::input[@class='c0146']"));
		inputLogin.clear();
		inputLogin.sendKeys(username);
	}
	
	public void fillPass(String password) {
		inputPassword = driver.findElement(By.xpath("*//div[@class='login-row password']/descendant::input[@class='c0146']"));
		inputPassword.clear();
		inputPassword.sendKeys(password);
=======
	public void login(String username, String pass) {
		driver.switchTo().frame(driver.findElement(By.className("ag-popup__frame__layout__iframe")));
		inputLogin = driver.findElement(By.xpath("*//div[@class='login-row username']/descendant::input[@class='c0146']"));
		inputLogin.clear();
		inputLogin.sendKeys("tathtp");

		inputPassword = driver.findElement(By.xpath("*//div[@class='login-row password']/descendant::input[@class='c0146']"));
		inputPassword.clear();
		inputPassword.sendKeys("Klopik123");
		
		buttonSubmit = driver.findElement(By.xpath("//div[@class='c0130 c0131']/descendant::button"));
		buttonSubmit.click();
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
	}
	
	public String getLoggedInUserName() {
		linkLoggedInUser = driver.findElement(By.xpath("//i[@id='PH_user-email']"));
		int positionAt = linkLoggedInUser.getText().indexOf('@');
		String currentUser = linkLoggedInUser.getText().substring(0, positionAt);
		return currentUser;
	}
	
<<<<<<< HEAD
	public String getUrlMainPage() {		
		return driver.getCurrentUrl();
=======
	public String getMessagesInbox() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
	}
	


}
