package CROWN.CICOD.COM.CreateOrder;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.AssertJUnit.assertEquals;

public class PartPayment extends TestBase {
    @Test
    public void PartPayment() throws IOException, InterruptedException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;

        login.Login();

        //COM
        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CREATE ORDER BUTTON
        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        //SEARCH BY NAME
        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH"))).click();

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();

        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1200);
        WebElement tid = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tid);

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(st);

        Thread.sleep(1200);
        WebElement tidd = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tidd);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPayment_XPATH"))).click();

        Thread.sleep(1200);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentAmount_XPATH"))).sendKeys(Utility.fetchLocator("pamt_TEXT"));

        Thread.sleep(2000);
        WebElement msg = (new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("assertamt100_TEXT"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("100")) {
            test.log(Status.PASS, "Fixed Amount Works");
        } else {
            test.log(Status.FAIL, "Fixed Amount Unsuccessful");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentDate_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("option-payment-amount-xs")).getText());
        assertEquals("NGN101.50", driver.findElement(By.id("option-payment-amount-xs")).getText());

        //Back Back
        driver.navigate().back();

        //SEARCH BY NAME
        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH"))).click();

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();

        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11pp = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsepp = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11pp);
        ti11pp.click();

        Thread.sleep(1200);
        WebElement tidpp = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tidpp);

        Thread.sleep(2000);
        WebElement ele111pp = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11pp = new Select(ele111);
        sel11pp.selectByIndex(st);

        Thread.sleep(1200);
        WebElement tiddll = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tiddll);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPayment_XPATH"))).click();

        Thread.sleep(1200);
        WebElement ti112nn = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2nn = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112nn);
        ti112nn.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentAmount_XPATH"))).sendKeys(Utility.fetchLocator("pamt_TEXT"));

        Thread.sleep(2000);
        WebElement msgtt = (new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("assertamt100_TEXT"))));
        String texttt = msg.getText();
        if (msg.isEnabled() && text.contains("100")) {
            test.log(Status.PASS, "Fixed Amount Works");
        } else {
            test.log(Status.FAIL, "Fixed Amount Unsuccessful");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentDate_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBTN_XPATH"))).click();


        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();

        Thread.sleep(1200);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Payment yet to be received on Order")) {
            test.log(Status.PASS, "Pay with POS Functional");
        } else {
            test.log(Status.FAIL, "Pay with POS Failed");
        }

        Thread.sleep(1200);
        WebElement tidda = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tidda);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPayment_XPATH"))).click();

        Thread.sleep(1200);
        WebElement ti112l = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2l = (JavascriptExecutor) driver;
        jse2l.executeScript("arguments[0].scrollIntoView();", ti112l);
        ti112l.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentAmount_XPATH"))).sendKeys(Utility.fetchLocator("pamt_TEXT"));

        Thread.sleep(2000);
        WebElement msg1 = (new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("assertamt100_TEXT"))));
        String text1 = msg.getText();
        if (msg1.isEnabled() && text1.contains("100")) {
            test.log(Status.PASS, "Fixed Amount Works");
        } else {
            test.log(Status.FAIL, "Fixed Amount Unsuccessful");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentDate_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBTN_XPATH"))).click();
    }
}
