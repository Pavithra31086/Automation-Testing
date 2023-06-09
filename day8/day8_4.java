package com.example.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day8_4 {
	public static void main( String[] args ) throws InterruptedException
    {
    	WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.abhibus.com/bus-ticket-booking");
        driver.manage().window().maximize();
        WebElement leave = driver.findElement(By.id("source"));
        leave.sendKeys("madurai");
        WebElement going = driver.findElement(By.id("destination"));
        going.sendKeys("coimbatore");
        
        WebElement date = driver.findElement(By.xpath("//*[@id=\"datepicker1\"]"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','03/06/2023')",date);
        
        Thread.sleep(2000);
        driver.close();
      
    }
}
