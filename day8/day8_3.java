package com.example.day8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day8_3 {

	public static void main( String[] args ) throws InterruptedException
    {
    	WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();
        WebElement value = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        value.sendKeys("401");
        WebElement submit = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        submit.click();
        Alert a = driver.switchTo().alert();
        //for cancel button
        a.dismiss();
        Thread.sleep(2000);
        //clear values
        value.clear();
        value.sendKeys("402");
        submit.click();
        //for ok button
        a.accept();
        Thread.sleep(3000);
        
        Alert b = driver.switchTo().alert();
        String text = b.getText();
        b.accept();
        driver.close();
        System.out.println(text);
    }
}

