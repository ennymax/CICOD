package CICOD.utility;

import CICOD.base.TestBase;
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

public class Utility extends TestBase{

    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    public static Object fetchProperty(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/config.properties");
        Properties property = new Properties();
        property.load(file);
        return 	property.get(key);
    }

    public static String fetchLocator(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/Locators.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }

    //**********************Alert ********************
    public void DowaitandAcceptAlerwhenReady(int timeOut) throws InterruptedException {
        Utility utility = new Utility(driver);
        utility.DowaitForAlertPresent(timeOut);
        Thread.sleep(1100);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("waited for Alert to be present on the page -->" + timeOut + " milliseconds");
        }
    }

    public void DowaitandDismisalertwhen(int timeOut) throws InterruptedException {
        Thread.sleep(1100);
        Utility utility = new Utility(driver);
        utility.DowaitForAlertPresent(timeOut);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            System.out.println("waited for Alert to be present on the page -->" + timeOut + " milliseconds");
        }
    }

    //**********************Send Keys ********************

    public void DosendKeysRandomNumberFluentWait(String locator, String ObjectName ,int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomEmailsFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeyRRFluentWait(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        mcj.clear();
        mcj.sendKeys(actualText);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysFluentWait(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomListwordsFluentWait(String locator,String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Randomstuff randomstuff = new Randomstuff();
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysByActionClassFluentWait(String locator, String value, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        Actions ac = new Actions(driver);
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        ac.sendKeys((locat), Utility.fetchLocator(value)).perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeyRRWhenReady(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement mcj = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        mcj.clear();
        mcj.sendKeys(actualText);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysByActionClassWhenReady(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        Actions ac = new Actions(driver);
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        ac.sendKeys((locat), Utility.fetchLocator(actualText)).perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoClearActionclassWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        Actions ac = new Actions(driver);
        ac.sendKeys((locat), Keys.DELETE ).perform();
    }

    public void DoSendKeysWhenReady(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysWhenReadyEnter(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText) + Keys.ENTER + Keys.ENTER + Keys.ENTER );
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomEmailsWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a );
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DosendKeysRandomNumberWhenReady(String locator, String ObjectName ,int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
        System.out.println("waited for element to be present on the page -->" + timeOut + "secs");
    }

    public void DosendKeysRandomListwordsWhenReady(String locator,String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        Randomstuff randomstuff = new Randomstuff();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSendKeysRobotClassFluentWait(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException, AWTException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Robot r = new Robot();
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
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
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().build().perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoswitchtoframeWhenReady(int frameIndex, int sleepindex ) throws IOException, InterruptedException {
        Thread.sleep(sleepindex);
        driver.switchTo().frame(frameIndex);
        System.out.println("waited for frame to be present on the page -->" + sleepindex + " milliseconds");
    }

    public void DohoverWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Actions builder = new Actions(driver);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }


    //**********************Clicks ********************
    public void DoubleClickActionWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element11p = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element11p.click();
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element11p).doubleClick().perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoClickActionclassWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Actions ac = new Actions(driver);
        ac.click(locat).perform();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
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

    public void DoclickFluentWait(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.click();
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoclickWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
            utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
            element.click();
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

    //**********************Assertion********************
    public void DoAssertContainsWhenReady(String locator, String Containstext, String DisplayPassmsg, String DisplayFailmsg, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        System.out.println(msg11);
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains(Utility.fetchLocator(Containstext))) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertXpathPresentWhenReady(String locator, String DisplayPassmessage, String DisplayFailmessage, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        if ( wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator))))).isDisplayed()) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmessage));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }

    public void DoAssertXpathAbsentWhenReady(String locator, String DisplayPassmessage, String DisplayFailmessage, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(Utility.fetchLocator(locator))).size() == 0) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmessage));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }

    public void DoAssertEqualWhenReady(String locator, String assertionString, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1600);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        assertEquals(assertionString, driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
    }

    //**********************CheckBox and Radio Button********************
    public void DoCheckBoxWhenReady(String locator, String NameOfEvent, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Utility utility = new Utility(driver);
        utility.isElementDisplayedandEnabled(locator, NameOfEvent, timeOut);
        WebElement check_box = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public void DoCheckBoxFluentWait(String locator, String NameOfEvent, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        utility.isElementDisplayedandEnabled(locator, NameOfEvent, timeOut);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
    }

    public void DoRadioButtonWhenReady(String locator, String NameOfEvent, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement check_box = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, NameOfEvent, timeOut);
        if (check_box.isSelected()) {
            test.log(Status.PASS, "Successful " + Utility.fetchLocator(NameOfEvent) + " is Selected");
        } else {
            test.log(Status.PASS, "Successful " + Utility.fetchLocator(NameOfEvent) + " is Selected");
            check_box.click();
        }
    }

    public void DoRadioButtonFluentWait(String locator, String NameOfEvent, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, NameOfEvent, timeOut);
        if (check_box.isSelected()) {
            test.log(Status.PASS, "Successful " + Utility.fetchLocator(NameOfEvent) + " is Selected");
        } else {
            test.log(Status.PASS, "Successful " + Utility.fetchLocator(NameOfEvent) + " is Selected");
            check_box.click();
        }
        System.out.println("waited for element to be present on the page -->" + timeOut + "secs");
    }

    //********************drop down utils **************************
    public void DoSelectValuesByVisibleText(String locator, String value, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByVisibleText(Utility.fetchLocator(value));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSelectValuesByIndex(String locator, String ObjectName, int index, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByIndex(index);
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    public void DoSelectValuesByValue(String locator, String ObjectName, String value, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByValue(Utility.fetchLocator(value));
        System.out.println("waited for " + Utility.fetchLocator(ObjectName) + " to be present on the page -->" + timeOut + " milliseconds");
    }

    //***************************Get Tittle ******************************
    public void DoAssertTittle(String TittleText,String DisplayPassmsg, String DisplayFailmessage) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        String expectedTitle = Utility.fetchLocator(TittleText);
        String actualTitle = driver.getTitle();

        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } catch (Throwable e) {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }



    public String DoGetPageTitleWithContains(int timeOut, String title) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleContains(Utility.fetchLocator(title)));
        return driver.getTitle();

    }

    public String DoGetPageTitleWithIsTitle(int timeOut, String title) throws IOException, InterruptedException {
        Thread.sleep(1100);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleIs(Utility.fetchLocator(title)));
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
        Utility utility = new Utility(driver);
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
        test.log(Status.PASS, Utility.fetchLocator(ObjectName) +" is Displayed");

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
                .pollingEvery(Duration.ofSeconds(3))
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
