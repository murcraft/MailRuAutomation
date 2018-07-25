package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	protected final WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public abstract void open(); 
	
	

}
