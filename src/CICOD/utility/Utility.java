package CICOD.utility;

import CICOD.base.TestBase;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import static org.testng.AssertJUnit.assertEquals;

public class Utility extends TestBase {
    SecureRandom rn = new SecureRandom();
    int nn = rn.nextInt(10) + 1;

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

    public void DoubleClickAction(String doubleclickXPATH) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement element11p = driver.findElement(By.xpath(Utility.fetchLocator(doubleclickXPATH)));
        element11p.click();
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element11p).doubleClick().perform();
    }

    public void DoClick(String locator) throws IOException, InterruptedException {
        driver.findElement(By.xpath(Utility.fetchLocator(locator))).click();
    }

    public void Dohover(String locator) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        builder.moveToElement(element1).build().perform();
    }

    public void DohoverWhenReady(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        builder.moveToElement(element1).build().perform();
    }

    public void DoscrolltoViewClick(String locator) throws IOException, InterruptedException {
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }

    public void DoscrolltoViewClickWhenReady(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }

    public void DoAssertTittleWhenReady(int timeOut, String TittleText, String DisplayFailmsg, String DisplayPassmsg) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        String title = driver.getTitle();
        System.out.println(title);
        if (title == Utility.fetchLocator(TittleText) ) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertTittle(String TittleText, String DisplayFailmsg, String DisplayPassmsg) throws IOException, InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        if (title == Utility.fetchLocator(TittleText) ) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertContains(String locator, String ContainsText, String DisplayFailmsg, String DisplayPassmsg) throws IOException, InterruptedException {
        WebElement msg = (WebElement) driver.findElements(By.xpath(Utility.fetchLocator(locator)));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains(Utility.fetchLocator(ContainsText))) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertContainsWhenReady(int timeOut, String locator, String ContainsText, String DisplayFailmsg, String DisplayPassmsg) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg = (WebElement) driver.findElements(By.xpath(Utility.fetchLocator(locator)));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains(Utility.fetchLocator(ContainsText))) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertXpathPresent(String locator, String DisplayPassmsg, String DisplayFailmsg) throws IOException, InterruptedException {
        if (driver.findElements(By.xpath(Utility.fetchLocator(locator))).size() != 0) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertXpathPresentWhenReady(int timeOut, String locator, String DisplayPassmsg, String DisplayFailmsg) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        if (driver.findElements(By.xpath(Utility.fetchLocator(locator))).size() != 0) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
    }

    public void DoAssertEquals(String assertionString, String locator, String Displayedmsg) throws IOException, InterruptedException {
        assertEquals(assertionString, driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
        test.log(Status.PASS, Utility.fetchLocator(Displayedmsg));
    }

    public void DoAssertEqualWhenReady(String assertionString, String locator, String Displayedmsg, int timeOut) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        assertEquals(assertionString, driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
        test.log(Status.PASS, Utility.fetchLocator(Displayedmsg));
    }

    public void DosendKey(String locator, String actualText) throws IOException {
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        mcj.clear();
        mcj.sendKeys(Utility.fetchLocator(actualText));
    }

    public void DoCheckBox(String locator) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        if(check_box.isDisplayed()) {
            test.log(Status.PASS, "Successful CheckBox is Displayed");
        }
        else {
            test.log(Status.FAIL, "Failed CheckBox Not Displayed");
        }
        if(check_box.isEnabled()) {
            test.log(Status.PASS, "Successful CheckBox is Enabled");
        }
        else {
            test.log(Status.FAIL, "Failed CheckBox is not Enabled");
        }

        if(check_box.isSelected()) {
            test.log(Status.PASS, "Successful CheckBx is Selected");
        }
        else {
            test.log(Status.PASS, "Successful CheckBox is Selected");
            check_box.click();
        }
    }

    public void DoRadioButton(String locator) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        if(check_box.isDisplayed()) {
            test.log(Status.PASS, "Successful Radio button is Displayed");
        }
        else {
            test.log(Status.FAIL, "Failed Radio button Not Displayed");
        }
        if(check_box.isEnabled()) {
            test.log(Status.PASS, "Successful Radio button is Enabled");
        }
        else {
            test.log(Status.FAIL, "Failed Radio button is not Enabled");
        }

        if(check_box.isSelected()) {
            test.log(Status.PASS, "Successful Radio button is Selected");
        }
        else {
            test.log(Status.PASS, "Successful Radio button is Selected");
            check_box.click();
        }
    }

    public void DoacceptAlertWhenReady(int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        if (driver.switchTo().alert() != null)
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void DoacceptAlert(){
        if (driver.switchTo().alert() != null)
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void DoalertDismis(){
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void DoalertDismisWhenReady(int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }


    //**********************Actions Methods ********************
    public void DoClickActionclass(String locator) throws IOException {
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        Actions ac = new Actions(driver);
        ac.click(locat).perform();
    }

    public void DoSendKeysByActionClass(String locator, String value) throws IOException {
        Actions ac = new Actions(driver);
        ac.sendKeys((driver.findElement(By.xpath(Utility.fetchLocator(locator)))), Utility.fetchLocator(value)).perform();
    }

    //********************drop down utils **************************

    public void DoSelectValuesByVisibleText(String locator, String value) throws IOException {
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        Select select = new Select(locat);
        select.selectByVisibleText(Utility.fetchLocator(value));
    }

    public void DoSelectValuesByIndex(String locator, int index) throws IOException {
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        Select select = new Select(locat);
        select.selectByIndex(index);
    }

    public void DoSelectValuesByValue(String locator, String value) throws IOException {
        WebElement locat = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        Select select = new Select(locat);
        select.selectByValue(Utility.fetchLocator(value));
    }

    //***************************wait utils ******************************
    public String DoGetPageTitleWithContains(int timeOut, String title) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleContains(Utility.fetchLocator(title)));
        return driver.getTitle();
    }

    public String DoGetPageTitleWithIsTitle(int timeOut, String title) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleIs(Utility.fetchLocator(title)));
        return driver.getTitle();
    }

    public String DoGetPageCurrentUrl(int timeOut, String urlValue) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.urlContains(Utility.fetchLocator(urlValue)));
        return  driver.getCurrentUrl();
    }

    public WebElement DowaitForElementPresent(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementToBeClickable(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementToBeVisible(String locator, int timeOut) throws IOException {
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> DovisibilityOfAllElements(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public void DoclickWhenReady(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.click();
    }

    public void DoSendKeysWhenReady(String locator, String actualText, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.clear();
        element.sendKeys(Utility.fetchLocator(actualText));
    }

    public Alert DowaitForAlertPresent(int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.alertIsPresent());
    }


    public boolean isElementDisplayed(String locator, int timeout) {
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
        return flag;

    }

    //******************* FluentWait Utils ***********************
    public WebElement DowaitForElementWithFluentWaitConcept(String locator, int timeOut) throws IOException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement DowaitForElementWithFluentWait(final String locator, int timeOut) throws IOException{
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
