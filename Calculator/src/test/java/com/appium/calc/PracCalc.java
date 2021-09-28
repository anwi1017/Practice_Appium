package com.appium.calc;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PracCalc {
	
	static AndroidDriver<MobileElement> driver;
	
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        
//      IP 127.0.0.1
//      Port  4723
      
      
//      URL
      URL url = new URL("http://127.0.0.1:4723/wd/hub");
//      Desired Capability
      
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability("platformName", "Android");
      cap.setCapability("platformVersion", "11");
      cap.setCapability("appPackage", "com.google.android.calculator");
      cap.setCapability("appActivity", "com.android.calculator2.Calculator");
      
//      {
//            "platformName": "Android",
//            "platformVersion": "11",
//            "appPackage": "com.google.android.calculator",
//            "appActivity": "com.android.calculator2.Calculator"
//          }
      
      
      
//      AndroidDriver
      driver = new AndroidDriver<MobileElement>(url, cap);
//      SessionId sessionId = driver.getSessionId();
//      System.out.println(sessionId);

//      Mobile Element
      String op1 = "2";
      String op2 = "8";
      String add = Add(op1,op2);
      System.out.println(add);
      System.out.println("Wait for sleep..");
      for (int i = 0; i < 60; i++) {
          Thread.sleep(5000);
      }
      System.out.println("Execution Over");
    }

  private static String Add(String op1, String op2) {
      driver.findElement(By.xpath("//android.widget.Button[@text='"+op1+"']")).click();
//
      driver.findElement(By.xpath("//android.widget.Button[@text='+']")).click();
      driver.findElement(By.xpath("//android.widget.Button[@text='"+op2+"']")).click();
      driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();
      String strOutput = driver.findElement(By.xpath("//android.widget.TextView")).getAttribute("text");
      return strOutput;
      
  }
}
