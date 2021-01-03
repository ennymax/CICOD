package CROWN.utility;

import CROWN.Base.TestBase;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static org.testng.AssertJUnit.assertEquals;

public class k {

    WebDriver driver;

    public k(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement retryingElement(String locator) throws InterruptedException, IOException {

        WebElement element = null;
        int attempts = 0;

        while (attempts < 10) {

            try {
                Thread.sleep(500);
                element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));;
                break;
            }

            catch (StaleElementReferenceException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {

                }
            }

            catch (NoSuchElementException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {

                }

                System.out.println("element is not found in attempt : " + (attempts + 1));
            }

            attempts++;
            System.out.println("Element found in attempt : " + (attempts + 1));
        }

        return element;

    }

    //**********************Send Keys ********************

    public void DosendKeysRandomNumber(String locator, int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        retryingElement(locator);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
    }

    public void DosendKeysRandomEmailsFluentWait(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a);
    }

    public void DosendKeyRRFluentWait(String locator, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        mcj.clear();
        mcj.sendKeys(actualText);
    }

    public void DoSendKeysFluentWait(String locator, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
    }

    public void DosendKeysRandomListwordsFluentWait(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        Randomstuff randomstuff = new Randomstuff();
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
    }

    public void DosendKeyRRWhenReady(String locator, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement mcj = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        mcj.clear();
        mcj.sendKeys(actualText);
    }

    public void DoClearActionclassWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        Actions ac = new Actions(driver);
        ac.sendKeys((locat), Keys.DELETE ).perform();
    }

    public void DoSendKeysWhenReady(String locator, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
    }

    public void DoSendKeysWhenReadyEnter(String locator, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText) + Keys.ENTER + Keys.ENTER + Keys.ENTER );
    }

    public void DosendKeysRandomEmailsWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a );
    }

    public void DosendKeysRandomNumberWhenReady(String locator, int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
    }

    public void DosendKeysRandomListwordsWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        Randomstuff randomstuff = new Randomstuff();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
    }

    public void DoSendKeysRobotClassFluentWait(String locator, String actualText, int timeOut) throws IOException, InterruptedException, AWTException {
        Thread.sleep(1200);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Robot r = new Robot();
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
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
    }

    //**********************Special ********************
    public void DoFileUpWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(3200);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().build().perform();
    }

    public void DoswitchtoframeWhenReady(int frameIndex, int sleepindex ) throws IOException, InterruptedException {
        Thread.sleep(sleepindex);
        driver.switchTo().frame(frameIndex);
    }

    //**********************Clicks ********************

    public void DoscrolltoViewClickFluentWait(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }

    public void DoclickFluentWait(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        element.click();
    }

    public void DoclickWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.click();
    }

    public void DoscrolltoViewClickWhenReady(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement ti11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }

    //**********************Assertion********************
    public void DoAssertEqualWhenReady(String locator, String assertionString, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        assertEquals(assertionString, driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
    }


}
