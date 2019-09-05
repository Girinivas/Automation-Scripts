package utilityClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AShotScreenshot {

	static WebDriver driver;
	
	public static void takeScreenshot(WebDriver actualDriver) throws IOException{
		driver = actualDriver;
		Screenshot myscreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		Date dateTime1 = new Date();
		String dateTime = dateTime1.toString().replace(" ","_").replace(":","_");
		String fileName = "test-output\\screenshots\\"+dateTime+".jpg";
		ImageIO.write(myscreenshot.getImage(),"jpg", new File(fileName));

	}
	
}
