package CICOD.utility;

import CICOD.base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class RavePay extends TestBase {

    WebDriver driver;
    public RavePay(WebDriver driver) {
        this.driver = driver;
    }

    public void RavePay3() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("RavePayCardnumber_XPATH", "Ca_TEXT","CardNumber_TEXT",60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH", "ValidTm_TEXT","e1_TEXT", 60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH","V_TEXT" ,"e2_TEXT", 60);
        utility.DoSendKeysWhenReady("RavPayCVV_XPATH", "CVVd_TEXT","CVV_TEXT", 60);
        utility.DoclickWhenReady("fg_XPATH","P_TEXT",60);
    }


    public void RavePay2() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("RavePayCardnumber_XPATH")))).sendKeys(Utility.fetchLocator("CardNumber_TEXT"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("e1_TEXT"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("e2_TEXT"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("RavPayCVV_XPATH"))).sendKeys(Utility.fetchLocator("CVV_XPATH"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("fg_XPATH"))).click();
        Thread.sleep(3000);

    }


    public void RavePay() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("RavePayCardnumber_XPATH")))).sendKeys(Utility.fetchLocator("CardNumber_TEXT"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("e1_TEXT"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("e2_TEXT"));

        Thread.sleep(3500);
        driver.findElement(By.xpath(Utility.fetchLocator("RavPayCVV_XPATH"))).sendKeys(Utility.fetchLocator("CVV_XPATH"));

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("fg_XPATH"))).click();
        test.log(Status.PASS, "Card Details was successfully Accepted By RavePay");

        Thread.sleep(3500);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("a1_XPATH")))).sendKeys(Utility.fetchLocator("a11_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("a2_XPATH"))).sendKeys(Utility.fetchLocator("a21_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a3_XPATH"))).sendKeys(Utility.fetchLocator("a31_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a4_XPATH"))).sendKeys(Utility.fetchLocator("a41_TEXT"));

    }

    public void RavePay1() throws IOException, InterruptedException {

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("RavePayCardnumber_XPATH")))).sendKeys(Utility.fetchLocator("CardNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("e1_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("e2_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RavPayCVV_XPATH"))).sendKeys(Utility.fetchLocator("CVV_XPATH"));

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("fg_XPATH"))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("a1_XPATH")))).sendKeys(Utility.fetchLocator("a11_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("a2_XPATH"))).sendKeys(Utility.fetchLocator("a21_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a3_XPATH"))).sendKeys(Utility.fetchLocator("a31_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a4_XPATH"))).sendKeys(Utility.fetchLocator("a41_TEXT"));

        Thread.sleep(3000);
    }

    public void RavePayWorkShop() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
        driver.switchTo().frame("checkout");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(260, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                WebElement mj = null;
                try {

                    mj = driver.findElement(By.xpath(Utility.fetchLocator("RavePayCardnumber_XPATH")));
                    mj.sendKeys(Utility.fetchLocator("CardNumber_TEXT"));

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return mj;
            }
        });

        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("Expire_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RavPayCVV_XPATH"))).sendKeys(Utility.fetchLocator("CVV_XPATH"));

        Thread.sleep(10000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayWorkShop_XPATH"))).click();

        //PIN
        WebElement fooo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                WebElement mjj = null;
                try {
                    mjj = driver.findElement(By.xpath(Utility.fetchLocator("a1_XPATH")));
                    mjj.sendKeys(Utility.fetchLocator("a11_TEXT"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return mjj;
            }
        });

        driver.findElement(By.xpath(Utility.fetchLocator("a2_XPATH"))).sendKeys(Utility.fetchLocator("a21_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a3_XPATH"))).sendKeys(Utility.fetchLocator("a31_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a4_XPATH"))).sendKeys(Utility.fetchLocator("a41_TEXT"));

        //OTP
        WebElement foooo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                WebElement mjjj = null;
                try {
                    mjjj = driver.findElement(By.xpath(Utility.fetchLocator("OTP_XPATH")));
                    mjjj.sendKeys(Utility.fetchLocator("otp_TEXT"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return mjjj;
            }
        });

        driver.findElement(By.xpath(Utility.fetchLocator("AuthorizePaymentBTN_XPATH"))).click();
    }
}
