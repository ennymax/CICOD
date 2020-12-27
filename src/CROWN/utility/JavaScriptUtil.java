package CROWN.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JavaScriptUtil {

	WebDriver driver;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void DoscrolltoViewClickFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
		Thread.sleep(1100);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
		Utility utility = new Utility(driver);
		utility.DowaitForElementWithFluentWait(locator, timeOut);
		WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
		utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ti11);
		ti11.click();
		System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
	}

	public void DoscrolltoViewClickWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
		Thread.sleep(1100);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
		Utility utility = new Utility(driver);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement ti11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
		utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ti11);
		ti11.click();
		System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
	}

	public void DoClickFluentwaitJS(String locator, int timeOut) throws IOException, InterruptedException {
		Utility utility = new Utility(driver);
		utility.DowaitForElementWithFluentWait(locator, timeOut);
		WebElement ele = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public void DoClickWhenReadyJS(String locator, int timeOut) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public String DogetTitleByJS() throws InterruptedException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}

	public void DorefreshBrowserByJS() throws InterruptedException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public void DogenerateAlert(String message) throws InterruptedException {
		Thread.sleep(1400);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	public String DogetPageInnerText() throws InterruptedException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	public void DoscrollPageDown() throws InterruptedException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void DoscrollPageDown(String height) throws InterruptedException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	public void DoscrollPageUp() throws InterruptedException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void DoscrollIntoView(String element) throws InterruptedException, IOException {
		Thread.sleep(800);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Utility.fetchLocator(element));
		Thread.sleep(600);
	}

}
