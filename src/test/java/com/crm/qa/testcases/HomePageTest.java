package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","HomePage title didnt matched");
	}
	
	//@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactspage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
