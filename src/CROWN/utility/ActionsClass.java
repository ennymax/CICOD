package CROWN.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ActionsClass {

    WebDriver driver;

    public ActionsClass(WebDriver driver) {
        this.driver = driver;
    }

    public void DoSendKeysWithMoveToElement(String locator, String value, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions action = new Actions(driver);
        action.moveToElement(element).sendKeys(Utility.fetchLocator(value)).build().perform();
    }

    public void DoActionsSendKeys(String locator, String value, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions action = new Actions(driver);
        action.sendKeys(element, Utility.fetchLocator(value)).perform();
    }

    public void DoActionsSendKeysRandomListword(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        Randomstuff randomstuff = new Randomstuff();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions action = new Actions(driver);
        action.sendKeys(element, randomstuff.ListRandom()).perform();
    }

    public void DoSendKeysByActionClassFluentWait(String locator, String value, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        Actions ac = new Actions(driver);
        ac.sendKeys((locat), Utility.fetchLocator(value)).perform();
    }

    public void DoSendKeysByActionClassWhenReady(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions ac = new Actions(driver);
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        ac.sendKeys((locat), Utility.fetchLocator(actualText)).perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }


    //**********************Clicks ********************
    public void DoActionsClick(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void DoClickWithMoveToElement(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    public void DoDoubleClickActionWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element11p = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        element11p.click();
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element11p).doubleClick().perform();
    }

    public void DoClickActionclassWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions ac = new Actions(driver);
        ac.click(locat).perform();
    }

    public void DoClickActionclassFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Actions ac = new Actions(driver);
        ac.click(locat).perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoClearActionclassWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        Actions ac = new Actions(driver);
        ac.sendKeys((locat), Keys.DELETE).perform();
    }

    public void DoHovereffectClickWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
    	Thread.sleep(500);
        Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement subMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }
}
