package com.example.day9;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day7_4 {
	 WebDriver driver;
     @Test
     public void Login() throws InterruptedException 
    {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  String actual_url=driver.getCurrentUrl();
	  WebElement name=driver.findElement(By.name("username"));
	  name.sendKeys("Admin");
	  WebElement pass=driver.findElement(By.name("password"));
	  pass.sendKeys("admin123",Keys.ENTER);
	  String expected_url=driver.getCurrentUrl();
	  Assert.assertNotEquals(actual_url, expected_url);  
	  
  }
   @Test(dependsOnMethods="Login")
   public void Logout() throws InterruptedException 
   {
	   Thread.sleep(5000);
	  WebElement acc=driver.findElement(By.xpath("//p[contains(text(),'Paul Collings')]"));
	  acc.click();	
	  Thread.sleep(5000);
	  WebElement logout = driver.findElement(By.linkText("Logout"));
	  logout.click();
	  Thread.sleep(5000);
	  
      driver.quit();  
  }
}
