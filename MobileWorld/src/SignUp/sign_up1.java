package SignUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sign_up1 {

	
@SuppressWarnings("deprecation")
@Test(dataProvider="SignUpdata",priority=1)
public void SignupPage(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6) throws InterruptedException {
		//System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		//WebDriver d = new EdgeDriver();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("https://mobileworld.azurewebsites.net/");
		d.manage().window().maximize();
		d.findElement(By.xpath("//button[@class='btn btn-warning my-2 my-sm-0\']")).click();
		d.findElement(By.xpath("//a[@href='signup.html']")).click();
		d.findElement(By.id("myName")).sendKeys(arg1);
		d.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(arg2);
		d.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(arg4);
		d.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(arg3);
		d.findElement(By.xpath("//input[@type='date']")).sendKeys("25-07-1990");
		/*Select day=new Select(date);
		day.selectByValue("16");*/
		//d.findElement(By.xpath(".form-control"));
		d.findElement(By.xpath("//div[@class='col-md-2']/input[@type='radio']")).click();
		d.findElement(By.xpath("//input[@placeholder='91XXXXXXXXXX']")).sendKeys(arg5);
		d.findElement(By.xpath("//textarea[@placeholder='Short Bio\']")).sendKeys(arg6);
		d.findElement(By.xpath("//button[@class='btn btn-info form-control']")).click();
		Thread.sleep(3000);
		d.switchTo().alert().accept();
		Thread.sleep(3000);
		d.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(3000);
		d.switchTo().alert().accept();
		Thread.sleep(2000);
		d.findElement(By.id("username")).sendKeys("Tom");
		d.findElement(By.id("password")).sendKeys("asdfgh123");
		d.findElement(By.xpath("//a[@type='submit']")).click();
		d.quit();
}

@DataProvider
public Object[][] SignUpdata()
{

	Object data[][]=new Object[3][6];
    data[0][0]="Tomthecat";
	data[0][1]="Jerry";
	data[0][2]="Tomandjerry";
	data[0][3]="abcd@gmail.com";
	data[0][4]="9876543210";
	data[0][5]="hi there";
	
	data[1][0]="Black";
	data[1][1]="Panther";
	data[1][2]="Panther";
	data[1][3]="abcd_@gmail.com";
	data[1][4]="987654321";
	data[1][5]="hi there";
	
	data[2][0]="Captian";
	data[2][1]="America";
	data[2][2]="Marvel";
	data[2][3]="abcda@Yahoo.com";
	data[2][4]="987654321";
	data[2][5]="hi there";
	
	return data;
}


}



