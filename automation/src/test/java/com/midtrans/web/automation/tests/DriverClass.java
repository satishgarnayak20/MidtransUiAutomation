package com.midtrans.web.automation.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.midtrans.web.automation.utilities.PropertyManager;

public class DriverClass {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public void SetUpBrowser() {
		
		
	}
	
	public void LaunchPage(String url){
		
	}

	
	public void QuitBrowser() {
		
	}

}
