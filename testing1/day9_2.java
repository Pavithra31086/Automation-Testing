package com.example.testing1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day9_2 {
	 @Test(groups= {"SmokeTest"})
	  public void godaddy() throws InterruptedException 
	  {
		  WebDriverManager.edgedriver().setup();
		  WebDriver driver = new EdgeDriver();
		  driver.get("https://www.godaddy.com/en-in");
		  driver.manage().window().maximize();
		  String actualTitle=driver.getTitle();
		  Assert.assertEquals(actualTitle, driver.getTitle());
		  String actual_url = driver.getCurrentUrl();
	      String expected_url=driver.getCurrentUrl();
		  
		  Assert.assertEquals(actual_url,expected_url);
		  Thread.sleep(1500);
		  driver.close();
	  }
	  @Test(groups= {"RegressionTest"})
	  public void godaddy1() throws InterruptedException
	  {
		  WebDriverManager.edgedriver().setup();
		  WebDriver driver = new EdgeDriver();
		  driver.get("https://www.godaddy.com/en-in");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
		  driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul[1]/li[2]/div/span/div/span/a")).click();
		  Thread.sleep(1500);
		  driver.close();	  
	  }
	  
	  WebDriver driver;
	 @Test(groups= {"regression"})
	  public void Test3() throws InterruptedException {
		  
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  driver.get("https://www.godaddy.com/en-in");
		  driver.manage().window().maximize();
		  Thread.sleep(5000);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebElement domains=driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button"));
		  domains.click();
		  Thread.sleep(5000);
		  WebElement DNS=driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul[1]/li[2]/div/span/div/span/a"));
		  DNS.click();
		 
		  String expected_title=driver.getTitle();
		  System.out.println(expected_title);
		  Assert.assertEquals(expected_title,driver.getTitle());
		  
	  }
	  @Test(dependsOnMethods="Test3")
	  public void Test4() throws InterruptedException {
		  Thread.sleep(3000);
		  WebElement verify_search = driver.findElement(By.xpath("//input[@name='searchText']"));
		  verify_search.isDisplayed();
		  Thread.sleep(3000);
		  WebElement verify_buyit = driver.findElement(By.xpath("//button[@aria-label='Open Menu']"));
		  verify_buyit.isDisplayed();
		  Thread.sleep(3000);
		  WebElement search=driver.findElement(By.xpath("//input[@name='searchText']"));
		  search.sendKeys("mydomain",Keys.ENTER);
		  Thread.sleep(5000);
		  
	  }
	  @Test(dependsOnMethods={"Test4"})
	  public void Test5() throws InterruptedException {
		  WebElement addto_cart=driver.findElement(By.xpath("//*[@id=\"mydomainweb.me_2\"]/div/div/div/div/div/div/div[2]/div/div/button"));
		  addto_cart.isDisplayed();
		  
		  WebElement price=driver.findElement(By.xpath("//*[@id=\"mydomainweb.me_1\"]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/div"));
		  price.isDisplayed();
		  
		  driver.close();
	  }
}
