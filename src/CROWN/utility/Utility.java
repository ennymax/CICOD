package CROWN.utility;

import CROWN.Base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.testng.AssertJUnit.assertEquals;

public class Utility extends TestBase {

    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    public static Object fetchProperty(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/config.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key);
    }

    public static String fetchLocator(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/Locators.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }

    //**********************Alert ********************
    public void DowaitandAcceptAlerwhenReady(int timeOut) throws InterruptedException {
        DowaitForAlertPresent(timeOut);
        Thread.sleep(1100);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("waited for Alert to be present on the page -->" + timeOut + " milliseconds");
        }
    }

    public void DowaitandDismisalertwhen(int timeOut) throws InterruptedException {
        Thread.sleep(1100);
        DowaitForAlertPresent(timeOut);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            System.out.println("waited for Alert to be present on the page -->" + timeOut + " milliseconds");
        }
    }

    //**********************Send Keys ********************

    public void DosendKeysRandomNumberFluentWait(String locator, String ObjectName, int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomEmailsFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        DowaitForElementWithFluentWait(locator, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeyRRFluentWait(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        DowaitForElementWithFluentWait(locator, timeOut);
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        mcj.clear();
        mcj.sendKeys(actualText);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysFluentWait(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomListwordsFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Randomstuff randomstuff = new Randomstuff();
        DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeyRRWhenReady(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement mcj = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        mcj.clear();
        mcj.sendKeys(actualText);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysWhenReady(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysWhenReadyEnter(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText) + Keys.ENTER + Keys.ENTER + Keys.ENTER);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomEmailsWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomNumberWhenReady(String locator, int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
        System.out.println("waited for element to be present on the page -->" + timeOut + "secs");
    }

    public void DosendKeysRandomListwordsWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Randomstuff randomstuff = new Randomstuff();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysRobotClassFluentWait(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException, AWTException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Robot r = new Robot();
        DowaitForElementWithFluentWait(locator, timeOut);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.click();
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element).doubleClick().perform();

        StringSelection stringSelection = new StringSelection(Utility.fetchLocator(actualText));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    //**********************Special ********************
    public void DoFileUpWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(3200);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().build().perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoswitchtoframeWhenReady(int frameIndex, int sleepindex) throws IOException, InterruptedException {
        Thread.sleep(sleepindex);
        driver.switchTo().frame(frameIndex);
        System.out.println("waited for frame to be present on the page -->" + sleepindex + " milliseconds");
    }

    //**********************Clicks ********************
    public void DoclickFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.click();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoclickWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.click();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }


    //********************drop down utils **************************
    public void doClickFromList(String locator, String linkText) throws IOException {
        java.util.List<WebElement> footerList = driver.findElements(By.xpath(Utility.fetchLocator(locator)));
        for (int i = 0; i < footerList.size(); i++) {
            String text = footerList.get(i).getText();
            if (text.equals(linkText)) {
                footerList.get(i).click();
                break;
            }
        }
    }

    public void DoSelectValuesByVisibleText(String locator, String value, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByVisibleText(Utility.fetchLocator(value));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSelectValuesByIndex(String locator, String ObjectName, int index, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByIndex(index);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSelectValuesByValue(String locator, String ObjectName, String value, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByValue(Utility.fetchLocator(value));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    //***************************Get Tittle ******************************
    public String DoGetPageTitleWithContains(int timeOut, String title) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleContains(Utility.fetchLocator(title)));
        return driver.getTitle();

    }

    public String DoGetPageTitleWithIsTitle() throws IOException, InterruptedException {
        Thread.sleep(1100);
        return driver.getTitle();
    }

    public String DoGetPageCurrentUrl(int timeOut, String urlValue) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.urlContains(Utility.fetchLocator(urlValue)));
        return driver.getCurrentUrl();
    }


    //***************************wait utils ******************************
    public WebElement DowaitForElementPresent(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementToBeVisible(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Alert DowaitForAlertPresent(int timeOut) throws InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        test.log(Status.PASS, "Alert is Present");
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    //**********************Displayed and Enabled ********************
    public boolean isElementDisplayed(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(500);
        WebElement element = null;
        boolean flag = false;
        for (int i = 0; i < timeout; i++) {

            try {
                element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
                flag = element.isDisplayed();
                break;
            } catch (Exception e) {
                System.out.println("waiting for element to be present on the page -->" + i + "secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
            }

        }
        test.log(Status.PASS, Utility.fetchLocator(ObjectName) + " is Displayed");

        return flag;

    }

    public boolean isElementDisplayedandEnabled(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(500);
        WebElement element = null;
        boolean flag = false;
        for (int i = 0; i < timeout; i++) {

            try {
                element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
                flag = element.isDisplayed() && element.isEnabled();
                break;
            } catch (Exception e) {
                System.out.println("waiting for element to be present on the page --> " + i + " secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
            }

        }
        test.log(Status.PASS, Utility.fetchLocator(ObjectName) + " is Displayed and Enabled");

        return flag;
    }


    public boolean isElementEnabled(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebElement element = null;
        boolean flag = false;
        for (int i = 0; i < timeout; i++) {

            try {
                element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
                flag = element.isDisplayed() && element.isEnabled();
                break;
            } catch (Exception e) {
                System.out.println("waiting for element to be present on the page -->" + i + "secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
            }

        }
        test.log(Status.PASS, Utility.fetchLocator(ObjectName) + " is Displayed and Enabled");

        return flag;

    }

    //******************* FluentWait Utils ***********************
    public WebElement DowaitForElementWithFluentWaitConcept(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementWithFluentWait(final String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    return driver.findElement(By.xpath(Utility.fetchLocator(locator)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        return element;
    }
}
