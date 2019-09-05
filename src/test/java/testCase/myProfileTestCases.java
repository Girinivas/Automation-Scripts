package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import pageObjects.myProfile;
import pageObjects.loginPage;

public class myProfileTestCases {
	
	myProfile MP = new myProfile();
	loginPage LP = new loginPage();
	//homePageLogin HPL = new homePageLogin();
	public static WebDriver driver;

	public static void setDriver(WebDriver driver){
		myProfileTestCases.driver = driver;
	}
	
	
	/*@Test
	public  void updateAddress(){
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(LP.loginName)).perform();
		act.moveToElement(driver.findElement(LP.profile)).click().perform();
	
		driver.findElement(By.xpath("//div[@class='_1GRhLX _1DGSPv']/div[2]/div/div[2]/a[2]/div")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[2]/div[1]")).click();
		//driver.findElement(MP.manageAddress).click();
		//driver.findElement(MP.addAddressBtn).click();
		
	}*/
	
}
