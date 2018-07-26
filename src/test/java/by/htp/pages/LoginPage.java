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
	
	public void login(String username, String pass) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("ag-popup__frame__layout__iframe")));
		inputLogin = driver.findElement(By.xpath("*//div[@class='login-row username']/descendant::input[@class='c0146']"));
		inputLogin.sendKeys("tathtp");
		
		buttonSubmit = driver.findElement(By.xpath("*//div[@class='login-row password']/descendant::input[@class='c0146']"));
		buttonSubmit.click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		inputPassword = driver.findElement(By.xpath("*//div[@class='login-row password']/descendant::input[@class='c0146']"));
		inputPassword.sendKeys("Klopik123");
		buttonSubmit = driver.findElement(By.xpath("//div[@class='c0130 c0131']/descendant::button"));
		buttonSubmit.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public String getLoggedInUserName() {
		linkLoggedInUser = driver.findElement(By.xpath("//i[@id='PH_user-email']"));
		String currentUser = linkLoggedInUser.getText();
		currentUser.matches("^[A-Za-z]*");
		return linkLoggedInUser.getAttribute("content");
	}
	

}
