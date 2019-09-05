package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {
	WebDriver driver;

	public By loginSignupButton = By.linkText("Login & Signup");
	public By email_mobile = By.xpath("//input[@type='text'][@class='_2zrpKA _1dBPDZ']");
	public By password = By.xpath("//input[@type='password'][@class='_2zrpKA _3v41xv _1dBPDZ']");
	public By loginButton = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	public By links = By.tagName("a");
	public By loginName = By.xpath("html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]");
	public By profile = By.xpath("//div[contains(text(),'My Profile')]");
	
	public void setUsername(String username){
		
		driver.findElement(email_mobile).sendKeys(username);
	}
	public void setPassword(String passkey){
		
		driver.findElement(password).sendKeys(passkey);
	}
	
	public void enterLoginCredentials(String username,String password, WebDriver driver)
	{	
		this.driver = driver;
		setUsername(username);
		setPassword(password);
		driver.findElement(loginButton).click();
	}

	public int totalLinks()
	{
		List<WebElement> linklist = driver.findElements(links);
		return linklist.size();
	}
	
	public List<WebElement> getAllLinks(){
		
		List<WebElement> Links = driver.findElements(links);
		List<WebElement> Links1 = driver.findElements(links);
		
		return Links1;
	}
	
	
	
	
}
	
