package com.example.day9;

import org.testng.Assert;
import org.testng.annotations.Test;

public class day7_2 {
	
	int a=20;
	int b=10;
  @Test(priority=1)
  public void add(int a2, int b2) {
	  int sum=a+b;
	  Assert.assertEquals(sum,30);
  }
  
  @Test(priority=2)
  public void sub() {
	  int minus=a-b;
	  Assert.assertEquals(minus,10);
  }
  
  @Test(priority=3)
  public void mul() {
	  int product=a*b;
	  Assert.assertEquals(product,200);
  }
  
  @Test(priority=4)
  public void div() {
	  int divide=a/b;
	  Assert.assertEquals(divide,2);
  }
}
