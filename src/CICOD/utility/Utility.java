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

    public void DoClick(String clickXPATH) throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator(clickXPATH))).click();
    }

    public void Dohover(String action) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator(action)));
        builder.moveToElement(element1).build().perform();
    }

    public void DoscrolltoViewClick(String jamy) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator(jamy)));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }

    public void DoAssert(String assertionString, String assertXPATH) throws IOException, InterruptedException {
        Thread.sleep(2000);
        assertEquals(assertionString, driver.findElement(By.xpath(Utility.fetchLocator(assertXPATH))).getText());
        test.log(Status.PASS, "Successful Assertion Passed");
    }

    public void DosendKeyS(String SendKeyXPATH, String actualText) throws IOException {
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator(SendKeyXPATH)));
        mcj.clear();
        mcj.sendKeys(Utility.fetchLocator(actualText));
    }

    public void DoCheckBox(String checkboxXPATH) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator(checkboxXPATH)));
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

    public void DoRadioButton(String checkboxXPATH) throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator(checkboxXPATH)));
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

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("element could not be created..." + locator);
        }

        return element;
    }

    public boolean doIsDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }


    //**********************Actions Methods ********************
    public void doActionsClick(String sel) throws IOException {
        WebElement locator = driver.findElement(By.xpath(Utility.fetchLocator(sel)));
        Actions ac = new Actions(driver);
        ac.click(locator).perform();
    }

    public void SendKeysByActionClass(String StringLocator, String value){
        Actions ac = new Actions(driver);
        ac.sendKeys((StringLocator), value).perform();
    }

    //********************drop down utils **************************

    public void doSelectValuesByVisibleText(String sel, String value) throws IOException {
        WebElement locator = driver.findElement(By.xpath(Utility.fetchLocator(sel)));
        Select select = new Select(locator);
        select.selectByVisibleText(value);
    }

    public void doSelectValuesByIndex(String sel, int index) throws IOException {
        WebElement locator = driver.findElement(By.xpath(Utility.fetchLocator(sel)));
        Select select = new Select(locator);
        select.selectByIndex(index);
    }

    public void doSelectValuesByValue(String sel, String value) throws IOException {
        WebElement locator = driver.findElement(By.xpath(Utility.fetchLocator(sel)));
        Select select = new Select(locator);
        select.selectByValue(value);
    }

    public List<String> getDropDownOptionsValues(String sel) throws IOException {
        WebElement locator = driver.findElement(By.xpath(Utility.fetchLocator(sel)));
        List<String> optionsList = new ArrayList<String>();

        Select select = new Select(locator);

        List<WebElement> dropList = select.getOptions();
        System.out.println(dropList.size());

        for (int i = 0; i < dropList.size(); i++) {
            String text = dropList.get(i).getText();
            optionsList.add(text);
        }

        return optionsList;
    }

    /**
     *
     * @param locator
     * @param value
     */
    public void selectValuesFromDropDown(By locator, String value){
        List<WebElement> daysList = driver.findElements(locator);

        for(int i=0; i<daysList.size(); i++){
            String text  = daysList.get(i).getText();
            if(text.equals(value)){
                daysList.get(i).click();
                break;
            }
        }
    }


    //***************************wait utils ******************************
    public String doGetPageTitleWithContains(int timeOut, String title) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    public String doGetPageTitleWithIsTitle(int timeOut, String title) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleIs(title));
        return driver.getTitle();
    }

    public String doGetPageCurrentUrl(int timeOut, String urlValue) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.urlContains(urlValue));
        return  driver.getCurrentUrl();
    }

    public WebElement waitForElementPresent(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeVisible(By locator, int timeOut){
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> visibilityOfAllElements(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickWhenReady(String locator, int timeOut) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
        element.click();
    }

    public Alert waitForAlertPresent(int timeOut){
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
    public WebElement waitForElementWithFluentWaitConcept(String locator, int timeOut) throws IOException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.xpath(Utility.fetchLocator(locator)))));
    }

    public WebElement waitForElementWithFluentWait(final String locator, int timeOut) throws IOException{
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
