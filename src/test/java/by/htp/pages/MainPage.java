package by.htp.pages;

<<<<<<< HEAD
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

=======
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private final String BaseURL = "https://e.mail.ru/messages/inbox/";
	private WebElement buttonWriteMesage;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void open() {
		driver.navigate().to(BaseURL);
	}
	
<<<<<<< HEAD
	public void findWriteMessButton() {
		driver.findElement(By.xpath("//*[@id='b-toolbar__left']/descendant::a[@class='b-toolbar__btn js-shortcut']")).click();
	}
	
    public ComposeMessage findMessage() {
        driver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/descendant::a[@class='b-toolbar__btn js-shortcut']")).click();
        return new ComposeMessage(driver);
=======
    public ComposePage findMessage() {
        driver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/descendant::a[@class='b-toolbar__btn js-shortcut']")).click();
        return new ComposePage(driver);
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
    }
	
	public String  getMainPageSend() {
		String textSend = driver.getTitle();
		System.out.println("TeXT: "+ textSend);
		return textSend;
	}
	
<<<<<<< HEAD
	public void findOutbox() {
		driver.findElement(By.xpath("//div[@id='b-nav_folders']/div/div[2]/a")).click();
	}
	
	public List<WebElement> findSendingMessages() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[1]/div/a/div[4]/div[3]/div[2]"));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
=======
	public List<WebElement> findSendingMessages() {
		driver.findElement(By.xpath("//div[@id='b-nav_folders']/div/div[2]/a"));
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='b-datalist__item__addr']"));	
>>>>>>> 741ae21b29fcfe21d1c39149e12a8496018382fe
		return list;
	}
}
