package com.example.day9;

import org.testng.annotations.Test;

public class CalculatorLogic {
  @Test
  public int add(int a, int b) {
	  int sum=a+b;
	  return sum;
  }
  
  @Test(priority=2)
  public int sub(int a,int b) {
	  int minus=a-b;
	  return minus;
  }
  
  @Test(priority=3)
  public int mul(int a,int b) {
	  int product=a*b;
	  return product;
  }
  
  @Test(priority=4)
  public int div(int a,int b) {
	  int divide=a/b;
	  return divide;
  }
  
}
