package com.logintstcases;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.loginpgobjects.LoginPgObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTstCases {
	WebDriver driver;
	private LoginPgObjects loginpage;
	String expectedUrl = "https://cloud-test.vendolite.com/portal/home";
	
	@BeforeClass
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://cloud-test.vendolite.com/home/login");
	}
	@Test
	public void logintestcase() {
		loginpage= new LoginPgObjects(driver);
		loginpage.login("loginuser","12345678");
		System.out.println("login successfully");
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
