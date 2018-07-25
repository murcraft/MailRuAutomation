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
	
	private WebElement inputLogin; // = Find(By("mailbox__login"));
	private WebElement  inputPassword; // = By.id("mailbox__password");
	private WebElement buttonSubmit;

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
		driver.switchTo().frame(driver.findElement(By.className("ag-popup__frame__layout__iframe")));
		inputLogin = driver.findElement(By.xpath("//input[@class='c0146']"));
		inputLogin.sendKeys("tathtp");
		buttonSubmit = driver.findElement(By.xpath("//div[@class='c0130 c0131']/descendant::button"));
		buttonSubmit.click();
		inputPassword = driver.findElement(By.xpath("//input[@class='c0146']"));
		inputPassword.sendKeys("Klopik123");
		inputPassword.click();
	}
	

}
