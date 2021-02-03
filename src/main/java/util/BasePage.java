package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void explicitWait(String action, WebDriver driver, int time, WebElement element) {
		if(action.equalsIgnoreCase("visible")) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		} else if(action.equalsIgnoreCase("invisible")) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		else if(action.equalsIgnoreCase("clickable")) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
			
	}
}
