package CROWN.utility;

import CROWN.Base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class Assertion extends TestBase {

    WebDriver driver;

    public Assertion(WebDriver driver) {
        this.driver = driver;
    }

    public void DoCheckBoxSelected(String locator,String DisplayPassmsg, String DisplayFailmsg, int timeOut) throws IOException, InterruptedException {
        Thread.sleep(1100);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Thread.sleep(1200);
        WebElement check_box1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator))));
        if(check_box1.isSelected()) {
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } else {
            check_box1.click();
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmsg));
        }
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
            assertEquals(Utility.fetchLocator(assertionString), wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Utility.fetchLocator(locator)))).getText());
            test.log(Status.PASS, Utility.fetchLocator(DisplayPassmsg));
        } catch (Throwable e) {
            System.out.println(driver.findElement(By.xpath(Utility.fetchLocator(locator))).getText());
            test.log(Status.FAIL, Utility.fetchLocator(DisplayFailmessage));
        }
    }

    public void DoAssertTittle(String TittleText, String DisplayPassmsg, String DisplayFailmessage) throws IOException, InterruptedException {
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

    public boolean DoAssertElementEnabled(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebElement element = null;
        boolean flag = false;
        for (int i = 0; i < timeout; i++) {

            try {
                element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
                flag = element.isEnabled();
                break;
            } catch (Exception e) {
                System.out.println("waiting for element to be present on the page -->" + i + "secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
            }

        }
        test.log(Status.PASS, Utility.fetchLocator(ObjectName) + " is Enabled");

        return flag;
    }

    public boolean DoAssertElementDisplayed(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
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

    public boolean DoAssertElementSelected(String locator, String ObjectName, int timeout) throws InterruptedException, IOException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        WebElement element = null;
        boolean flag = false;
        for (int i = 0; i < timeout; i++) {

            try {
                element = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
                flag = element.isSelected();
                break;
            } catch (Exception e) {
                System.out.println("waiting for element to be present on the page -->" + i + "secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
            }

        }
        test.log(Status.PASS, Utility.fetchLocator(ObjectName) + " is Selected");

        return flag;
    }
}
