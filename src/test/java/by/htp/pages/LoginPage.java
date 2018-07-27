package by.htp.pages;

import java.util.concurrent.TimeUnit;

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
	}
	
	public String getLoggedInUserName() {
		linkLoggedInUser = driver.findElement(By.xpath("//i[@id='PH_user-email']"));
		int positionAt = linkLoggedInUser.getText().indexOf('@');
		String currentUser = linkLoggedInUser.getText().substring(0, positionAt);
		return currentUser;
	}
	
	public String getUrlMainPage() {		
		return driver.getCurrentUrl();
	}
	


}
