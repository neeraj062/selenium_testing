package check;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class Multiplelinks {
	public static void  launch_browser() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\final\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://http://newtours.demoaut.com/mercurywelcome.php");
		String parent = driver.getWindowHandle();
		List<WebElement> all_links =driver.findElements(By.tagName("a"));
		//Object all_Links;
		for(WebElement link : all_links) {
			if(link.isDisplayed()) {
				String text = link.getText();
				System.out.println(text);
				
				//right click
				Actions action = new Actions(driver);
				action.contextClick(link).build().perform();
				
				//open in new tab
				
				Robot robo = new Robot();
				Thread.sleep(3000);
				robo.keyPress(KeyboardEvent.DOM_VK_ENTER);
				robo.keyRelease(KeyEvent.VK_ENTER);
				
				
				//Getting all windows 
				Set<String> childwindows= driver.getWindowHandles();
				
				for(String win: childwindows) {
					if(!parent.equals(win)) {
						driver.switchTo().window(win);
						driver.manage().window().maximize();
						Thread.sleep(3000);
						driver.close();
					}
				}
				
				driver.switchTo().window(parent);
				Thread.sleep(3000);
			}
		}
		
	}
}
