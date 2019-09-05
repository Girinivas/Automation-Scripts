package testCase;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.diagnostics.logging.Logger;

import pageObjects.loginPage;
import pageObjects.myProfile;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilityClass.AShotScreenshot;

@Listeners(listenerClass.listnerClassForTests.class)	

public class homePageLogin {
 
	public WebDriver driver;
	loginPage LP = new loginPage();
	myProfile MP = new myProfile();
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void launchBrowser()
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	@BeforeClass
	public void extendReportSetup()
	{
	reporter = new ExtentHtmlReporter("E:/BACKUP's/Wipro Laptop Backup/Selenium/Projects/FlipkartTesting/test-output/extent-reports/extentreport.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}
	
	@BeforeTest
	public void browerSetup()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void enterLoginCredentials() throws IOException
	{	
		ExtentTest logger = extent.createTest("Login Test");
		driver.get("https://www.flipkart.com/");
		logger.log(Status.INFO, "Launched Flipkart");
		LP.enterLoginCredentials("girinivasnm@gmail.com", "Mpadmaveni@9", driver);
		AShotScreenshot.takeScreenshot(driver);
		logger.log(Status.PASS, "Logged into Flipkart. Testcase is passed");
		extent.flush();
	}
	
	@Test(priority=2)
	public void totalLinks()
	{
		ExtentTest logger = extent.createTest("Links Test");
		int linklist = LP.totalLinks();
		System.out.println(linklist);
		logger.log(Status.INFO, "Total links has bee displayed");
		extent.flush();
	}
	
/*	@Test(priority=3)
	public void getAlllinks() throws IOException
	{
		//Assert.fail();
		List<WebElement> links = LP.getAllLinks();
		List<String> linkText = new ArrayList<String>();
		
		for(WebElement link : links)
		{
			
			linkText.add(link.getAttribute("href"));
		}
		
		Iterator<String> itr = linkText.iterator();
		while(itr.hasNext())
		{
			driver.get((String) itr.next());
			AShotScreenshot.takeScreenshot(driver);
		}
	}
	*/
	@Test(priority=4)
	public void loginName(){
		String loggedonuser = driver.findElement(LP.loginName).getText();
		Assert.assertEquals(loggedonuser, "Girinivas");
		System.out.println(loggedonuser);
		
	}
	
	@Test(priority=6)
	public void autoIT() throws IOException{
		driver.get("C:\\Users\\USER\\Desktop\\File Upload.html");
		driver.findElement(By.id("1")).click();
		Runtime.getRuntime().exec("C:\\Users\\USER\\Desktop\\AutoIT\\FileUpload.exe");
		
	}

	@Test(priority=5)
	public void setDriver()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(LP.loginName)).perform();
		act.moveToElement(driver.findElement(LP.profile)).click().perform();
		driver.findElement(MP.manageAddress).click();
		driver.findElement(MP.addAddressBtn).click();
		
		
		//myProfileTestCases.setDriver(driver);
	}

		@AfterTest
		public void closeBrowser(){
			driver.close();
			driver.quit();
		}
}
