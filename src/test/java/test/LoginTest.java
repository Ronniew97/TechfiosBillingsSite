package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	@Test(priority=1)
	public void userWithValidCredentialsShouldBeAbleToLogin() throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName("demo@techfios.com");
		login.enterPassword("abc123");
		login.clickLogInButton();
		login.validateHomePage();
		driver.close();
	}
	
	@Test(priority=2)
	public void userWithInvalidPasswordShouldNotBeAbleToLogin() throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName("demo@techfios.com");
		login.enterPassword("ac12");
		login.clickLogInButton();
		login.validateErrorMessage();
		driver.close();
	}
	
	@Test(priority=3)
	public void userWithInvalidUsernameShouldNotBeAbleToLogin() throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName("de@techfios.com");
		login.enterPassword("abc123");
		login.clickLogInButton();
		login.validateErrorMessage();
		driver.close();
	}
	
	@Test(priority=4)
	public void userWithValidEmailShouldBeAbleToResetPassword() throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.resetPassword("demo@techfios.com");
		login.validatePasswordResetMessage();
		driver.close();
	}
	
	@Test(priority=5)
	public void userWithInvalidEmailShouldNotBeAbleToResetPassword() throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.resetPassword("deo@techfios.com");
		login.validatePasswordResetErrorMessage();
		driver.close();
	}
}
