package by.htp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
    public ComposePage findMessage() {
        driver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/descendant::a[@class='b-toolbar__btn js-shortcut']")).click();
        return new ComposePage(driver);
    }
	
	public String  getMainPageSend() {
		String textSend = driver.getTitle();
		System.out.println("TeXT: "+ textSend);
		return textSend;
	}
	
	public List<WebElement> findSendingMessages() {
		driver.findElement(By.xpath("//div[@id='b-nav_folders']/div/div[2]/a"));
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='b-datalist__item__addr']"));	
		return list;
	}
}
