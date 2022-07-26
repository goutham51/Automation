package SignUp;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class support_order {
	
	
	//@Parameters({"URL"})
	@Test(dataProvider="orderData")
	public void order(String Fn,String Sn,String mail,String pwd,String mob,String add1,String add2,String city,String qty) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)d;
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("https://mobileworld.azurewebsites.net/");
		d.manage().window().maximize();
		d.findElement(By.linkText("Support")).click();
		d.findElement(By.linkText("Order")).click();
		Set<String> a=d.getWindowHandles();
		Iterator<String> it=a.iterator();
		String parentid=it.next();
		String childid=it.next();
		d.switchTo().window(childid);
		d.findElement(By.id("inputFirstName")).sendKeys(Fn);//Fn
		d.findElement(By.xpath("//body/div[@class='container']/div[@class='card']/div[@class='card-body']/form[@id='myForm']/div[1]/div[2]/input[1]")).sendKeys(Sn); //Sn
		d.findElement(By.id("inputEmail")).sendKeys(mail);//mail
		d.findElement(By.id("inputPassword")).sendKeys(pwd);//Pwd
		d.findElement(By.id("flexRadioDefault1")).click();
		d.findElement(By.xpath("//input[@placeholder='00000000000']")).sendKeys(mob);//mob
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id=' address1']")).sendKeys(add1);//add1
		d.findElement(By.xpath("//input[@placeholder='Main St']")).sendKeys(add2);//add2
		d.findElement(By.id("inputCity")).sendKeys(city);//city
		d.findElement(By.id("inputZip")).sendKeys("zip123");
		WebElement State=d.findElement(By.id("inputState"));
		Select drp=new Select(State);
		drp.selectByIndex(2);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@rel='apple']")).click();
		d.findElement(By.xpath("//input[@rel='samsung']")).click();
		d.findElement(By.xpath("//input[@placeholder='no of mobiles']")).sendKeys(qty);//qty
		d.findElement(By.xpath("//select[@id='bought']/option[@value='0']")).click();
		d.findElement(By.xpath("//div[@class='apple']//option[1]")).click();
		List<WebElement> c=d.findElements(By.id("gridCheck1"));
		c.get(0);
		c.get(1);
		d.findElement(By.xpath("//button[@data-target='#exampleModal']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
		
		
		d.quit();

	}
	
	@DataProvider
	public Object[][] orderData()
	{
		Object[][] data=new Object[1][9];
		 
			data[0][0]="Tom"; //FN
			data[0][1]="Jerry";//Sn
			data[0][2]="tom_j@gmail.com";//mail
			data[0][3]="tomjer";//pwd
			data[0][4]="0987654321";//mob
			data[0][5]="california";//add1
			data[0][6]="lv";//add2
			data[0][7]="Newyork";//city
			data[0][8]="3";//qty
				return data;
	}
	
}

