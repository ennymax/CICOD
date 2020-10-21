package CICOD.utility;

import CICOD.base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import static org.testng.AssertJUnit.assertEquals;

public class Utility extends TestBase {

    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    public static String fetchLocator(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/Locators.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }

    //**********************Alert ********************
    public void DoacceptAlert(int timeOut) throws InterruptedException {
        Utility utility = new Utility(driver);
        utility.DowaitForAlertPresent(timeOut);
        Thread.sleep(1000);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void DoalertDismis(int timeOut) throws InterruptedException {
        Thread.sleep(1000);
        Utility utility = new Utility(driver);
        utility.DowaitForAlertPresent(timeOut);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    //**********************Send Keys ********************

    public void DosendKeyRRWhenReadyFlu(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        mcj.clear();
        mcj.sendKeys(actualText);
    }

    public void DosendKeyRRWhenReady(String locator, String actualText, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement mcj = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        mcj.clear();
        mcj.sendKeys(actualText);
    }

    public void DoSendKeysByActionClass(String locator, String value, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1500);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        Actions ac = new Actions(driver);
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        ac.sendKeys((locat), Utility.fetchLocator(value)).perform();
    }

    public void DoSendKeysWhenReady(String locator, String ObjectName, String actualText, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
    }

    public void DosendKeysRandomEmailsWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Randomstuff randomstuff = new Randomstuff();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "@gmail.com";
        element.sendKeys(randomstuff.ListRandom() + a);
    }

    public void DosendKeysRandomNumberWhenReady(String locator, String ObjectName ,int span, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(span) + 1;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + resourcetype);
    }

    public void DosendKeysRandomListwordsWhenReady(String locator,String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        Randomstuff randomstuff = new Randomstuff();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.clear();
        String a = "";
        element.sendKeys(a + randomstuff.ListRandom());
    }

    public void DoFileUpWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().build().perform();
    }

    public void DoswitchtoframeWhenReady(int frameIndex,int sleepindex ) throws IOException, InterruptedException {
        Thread.sleep(sleepindex);
        driver.switchTo().frame(frameIndex);
    }

    public void DohoverWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Actions builder = new Actions(driver);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        builder.moveToElement(element1).build().perform();
    }


    //**********************Clicks ********************
    public void DoubleClickActionWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element11p = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element11p.click();
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element11p).doubleClick().perform();
    }

    public void DoClickActionclassWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement locat = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Actions ac = new Actions(driver);
        ac.click(locat).perform();
    }

    public void DoclickWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        element.click();
    }

    public void DoscrolltoViewClickWhenReady(String locator, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(3000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement ti11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }


    public void DoAssertTittle(String TittleText, String DisplayFailmsg, String DisplayPassmsg) throws IOException, InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        if (title == Utility.fetchLocator(TittleText)) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertContainsWhenReady(String locator, String Containstext, String DisplayPassmsg, String DisplayFailmsg, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        System.out.println(msg11);
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains(Utility.fetchLocator(Containstext))) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
        test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
    }

    public void DoAssertXpathPresentWhenReady(String locator, String DisplayPassmsg, String DisplayFailmsg, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        if (driver.findElements(By.xpath(Utility.fetchLocator(locator))).size() != 0) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertEqualWhenReady(String locator, String assertionString, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg11 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        assertEquals(assertionString, driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
    }


    public void DoCheckBoxWhenReady(String locator, String NameOfEvent, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Utility utility = new Utility(driver);
        WebElement check_box = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        utility.isElementDisplayedandEnabled(locator, NameOfEvent, timeOut);

    }

    public void DoRadioButton(String locator, String NameOfEvent, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
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

    //********************drop down utils **************************

    public void DoSelectValuesByVisibleText(String locator, String value, String ObjectName, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByVisibleText(Utility.fetchLocator(value));
    }

    public void DoSelectValuesByIndex(String locator, String ObjectName, int index, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByIndex(index);
    }

    public void DoSelectValuesByValue(String locator, String ObjectName, String value, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        utility.isElementDisplayedandEnabled(locator, ObjectName, timeOut);
        Select select = new Select(locat);
        select.selectByValue(Utility.fetchLocator(value));
    }

    //***************************Get Tittle ******************************
    public String DoGetPageTitleWithContains(int timeOut, String title) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleContains(Utility.fetchLocator(title)));
        return driver.getTitle();
    }

    public String DoGetPageTitleWithIsTitle(int timeOut, String title) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleIs(Utility.fetchLocator(title)));
        return driver.getTitle();
    }

    public String DoGetPageCurrentUrl(int timeOut, String urlValue) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.urlContains(Utility.fetchLocator(urlValue)));
        return driver.getCurrentUrl();
    }


    //***************************wait utils ******************************
    public WebElement DowaitForElementPresent(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementToBeVisible(String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Alert DowaitForAlertPresent(int timeOut) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        test.log(Status.PASS, "Alert is Present");
        return wait.until(ExpectedConditions.alertIsPresent());
    }


    public boolean isElementDisplayed(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(2000);
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
        Thread.sleep(2000);
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
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementWithFluentWait(final String locator, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(2000);
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
