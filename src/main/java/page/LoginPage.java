package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import util.BasePage;

public class LoginPage extends BasePage{
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='username']") WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement LOGIN_BUTTON;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Forgot password") WebElement FORGOT_PASSWORD_BUTTON;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Reset Password')]") WebElement RESET_PASSWORD_BUTTON;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_HEADER;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger fade in']") WebElement ERROR_MESSAGE;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']") WebElement PASSWORD_RESET_MESSAGE;
	
	public void enterUserName(String username) {
		USERNAME_FIELD.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}
	
	public void clickLogInButton() throws InterruptedException {
		LOGIN_BUTTON.click();
		Thread.sleep(2000);
	}
	
	public void resetPassword(String username) throws InterruptedException {
		FORGOT_PASSWORD_BUTTON.click();
		USERNAME_FIELD.sendKeys(username);
		RESET_PASSWORD_BUTTON.click();
		Thread.sleep(2000);
	}
	
	public void validateHomePage() {
		Assert.assertTrue(DASHBOARD_HEADER.isDisplayed(),"home page is not displayed");
	}
	
	public void validateErrorMessage() {
		String expectedErrorMessage = "Invalid Username or Password";
		String actualErrorMessage = ERROR_MESSAGE.getText().substring(1).trim();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"error message not visible");
	}
	
	public void validatePasswordResetMessage() throws InterruptedException {
		String expectedErrorMessage = "Check your email to reset Password";
		String actualErrorMessage = PASSWORD_RESET_MESSAGE.getText().substring(1).trim();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"password reset message not visible");
	}
	
	public void validatePasswordResetErrorMessage() throws InterruptedException {
		String expectedErrorMessage = "User Not Found!";
		String actualErrorMessage = ERROR_MESSAGE.getText().substring(1).trim();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"error message not visible");
	}
}
