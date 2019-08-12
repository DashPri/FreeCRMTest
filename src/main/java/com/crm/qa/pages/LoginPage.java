package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory-OR(Object Repository:
	
	/*@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath= "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath= "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo ;*/
	
	WebElement username = driver.findElement(By.name("username"));
	WebElement password = driver.findElement(By.name("password"));
	WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	WebElement signUpBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
	WebElement crmLogo = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]"));
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.submit();
		
		return new HomePage();
	}
	
}
