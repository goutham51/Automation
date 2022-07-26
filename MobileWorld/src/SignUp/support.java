package SignUp;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class support {

	@SuppressWarnings("deprecation")
	@Test
	public void contactUS() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	WebDriver d = new ChromeDriver();
	d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	d.get("https://mobileworld.azurewebsites.net/");
		d.findElement(By.linkText("Support")).click();
		d.findElement(By.linkText("Contact Us")).click();
		Set<String> a=d.getWindowHandles();
		Iterator<String> it=a.iterator();
		String parentid=it.next();
		String childid=it.next();
		d.switchTo().window(childid);
		d.manage().window().maximize();
		Thread.sleep(5000);
		String msg="At the July 1989 meeting, the ICC renamed itself as the International Cricket Council";
		d.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Tommy");
		d.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		d.findElement(By.xpath("//input[@type='tel']")).sendKeys("0987654321");
		d.findElement(By.xpath("//textarea[@name='message']")).sendKeys(msg);
		d.findElement(By.xpath("//input[@class='btn']")).click();
		d.quit();
	}
	
	
}
