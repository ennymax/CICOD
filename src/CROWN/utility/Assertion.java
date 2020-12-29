package CROWN.utility;

import CROWN.Base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class Assertion extends TestBase {

    WebDriver driver;

    public Assertion(WebDriver driver) {
        this.driver = driver;
    }

    public void DoAssertContainsWhenReady(String locator, String Containstext, String DisplayPassmsg, String DisplayFailmsg, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement msg11 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
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
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator)))).isDisplayed()) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmessage));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }

    public void DoAssertXpathAbsentWhenReady(String locator, String DisplayPassmessage, String DisplayFailmessage, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator)))).isDisplayed()) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmessage));
        } else {
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }

    public void DoAssertEqualWhenReady(String locator, String assertionString, String DisplayPassmsg, String DisplayFailmessage, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1600);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            assertEquals(assertionString, wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator)))).getText());
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } catch (Throwable e) {
            System.out.println(driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }

}
