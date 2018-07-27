package by.htp.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class ComposeMessage extends AbstractPage {
	private final String URL = "https://e.mail.ru/compose/?1532599725577";
	

	public ComposeMessage (WebDriver driver) {
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
	}
	
	public void sendMessage() {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#b-toolbar__right > div:nth-child(3) > div > div:nth-child(2) > div.b-toolbar__item.b-toolbar__item_.b-toolbar__item_false > div > span")).click();
	}
	
	public String getUrlPage() {
		return driver.getTitle();
	}
	
	public String getSendingConfirm() {
		String text = driver.findElement(By.xpath("//div[@class='message-sent__title']")).getText();
		int positionDot = text.indexOf(".");
		return text.substring(0, positionDot).toLowerCase();
	}
	
	public MainPage goToMainPage() {
		driver.findElement(By.xpath("//div[@id='b-nav_folders']/div/div[1]/a")).click();
		return new MainPage(driver);
	}

}
