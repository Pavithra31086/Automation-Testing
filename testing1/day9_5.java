package com.example.testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day9_5 {
  WebDriver driver;
  @BeforeTest
  public void BeforeMethod() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @Test
  public void Test() throws InterruptedException {
	  String actual_url=driver.getCurrentUrl();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Suvitha");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String expected_url=driver.getCurrentUrl();
	  Assert.assertEquals(actual_url, expected_url); 
	  Thread.sleep(3000);
	  }
  
  @AfterTest
  public void AfterMethod()
  {
	  driver.close();
  }
}
