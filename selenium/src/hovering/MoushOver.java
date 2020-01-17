package hovering;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoushOver {

	public static void takePicture(WebDriver driver,String filename) throws Exception{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("D:\\screenshot\\"+filename+".png"));
	}

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\final\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Watches");
		Thread.sleep(3000);
		
		for(int i=1;i<=4;i++) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		}
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		takePicture(driver, "image");
		
//		for(int i=1;i<=4;i++) {
//			WebElement elementLocator = driver.findElement(By.id("ID"));
//			Thread.sleep(3000);
//			}
//		
//		driver.findElement(By.id("watches")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		takePicture(driver, "image1");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("swisso"))).build().perform();
		Thread.sleep(3000);
		takePicture(driver, "image1");
		
		driver.close();
	
	}

}