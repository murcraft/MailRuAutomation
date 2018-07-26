package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ComposePage extends AbstractPage {
	private final String URL = "https://e.mail.ru/compose/?1532599725577";

	public ComposePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void open() {
		driver.navigate().to(URL);
	}
	
	public void fillDestinationAddress() {
		WebElement emailArea = driver.findElement(By.xpath("//div[@class='compose-head']/descendant::textarea[@tabindex='4']"));
		emailArea.clear();
		emailArea.sendKeys("ogulikpurse@gmail.com");
		driver.findElement(By.xpath("//div[@class='compose-head']/descendant::input[@class='b-input']")).sendKeys("Test sending email");
	}
	
	public void findFrameTextEmail() {
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'composeEditor_ifr')]"));
		driver.switchTo().frame(frame);
		WebElement elementMessageBody = driver.findElement(By.id("tinymce"));
		elementMessageBody.sendKeys("Hello, I am doing test of mailru and it's cool!))");
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#b-toolbar__right > div:nth-child(3) > div > div:nth-child(2) > div.b-toolbar__item.b-toolbar__item_.b-toolbar__item_false > div > span")).click();
	}

}
