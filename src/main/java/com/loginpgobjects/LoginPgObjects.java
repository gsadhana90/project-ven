package com.loginpgobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPgObjects {
	
	private final WebDriver driver;
	private final WebDriverWait wait;

	public LoginPgObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='mat-tab-label-content' and text()='Company']")
	private WebElement company;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement emailid1;
	
	@FindBy(xpath="//div[@class='mat-form-field-flex ng-tns-c27-0']")
	private WebElement emailid;

	@FindBy(xpath="//div[@class='mat-form-field-flex ng-tns-c27-1']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password1;

	@FindBy(xpath="//span[@class='mat-button-wrapper' and text()=' Login ']")
	private WebElement submit;
	
	public void login(String username,String Password) {
		company.click();
		emailid.click();
		emailid1.sendKeys(username);
		password.click();
		password1.sendKeys(Password);
	}
	public void clickBtn() {
		this.wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		}
	
	
}
