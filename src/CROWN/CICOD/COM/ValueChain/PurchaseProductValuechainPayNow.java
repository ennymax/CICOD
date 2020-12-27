package CROWN.CICOD.COM.ValueChain;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class PurchaseProductValuechainPayNow extends TestBase {
    @Test
    public void PURCHASE_PRODUCT_VIA_VALUE_CHAIN_PAYNOW() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginDefault();
        Assertion assertion = new Assertion(driver);

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("Suppliers_XPATH"))).click();

        Thread.sleep(1000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SuppliersProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateOrderfromSuppler_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryPlus_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectBeverages_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11l = driver.findElement(By.xpath(Utility.fetchLocator("mdd_XPATH")));
        JavascriptExecutor jsel = (JavascriptExecutor) driver;
        jsel.executeScript("arguments[0].scrollIntoView();", ti11l);

        Thread.sleep(200);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();
        test.log(Status.PASS, "PayOnline Button is displayed and enabled");

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("option-payment-amount-xs")).getText());

        Thread.sleep(8000);
        assertEquals("NGN2,131.50", driver.findElement(By.id("option-payment-amount-xs")).getText());
        test.log(Status.PASS, "PayOnline Was Successful");

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        test.log(Status.INFO, "MAKE PAYMENT WITH POS");

        Thread.sleep(2000);
        driver.get("https://emaxkemiyop.cicod.com/cuorma/web/value-chain/order?id=10147");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryPlus_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectBeverages_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11lxx = driver.findElement(By.xpath(Utility.fetchLocator("mdd_XPATH")));
        JavascriptExecutor jselxx = (JavascriptExecutor) driver;
        jselxx.executeScript("arguments[0].scrollIntoView();", ti11lxx);

        WebElement ti112aa = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2aa = (JavascriptExecutor) driver;
        jse2aa.executeScript("arguments[0].scrollIntoView();", ti112aa);
        ti112aa.click();

        Thread.sleep(2000);
        WebElement ti112ll = driver.findElement(By.xpath(Utility.fetchLocator("POS_XPATH")));
        JavascriptExecutor jse2ll = (JavascriptExecutor) driver;
        jse2ll.executeScript("arguments[0].scrollIntoView();", ti112ll);
        ti112ll.click();

        Thread.sleep(3000);
        WebElement ti11pp = driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH")));
        JavascriptExecutor jsepp = (JavascriptExecutor) driver;
        jsepp.executeScript("arguments[0].scrollIntoView();", ti11pp);
        ti11pp.click();
        test.log(Status.PASS, "Payment Via POS Successful");

        test.log(Status.INFO, "MAKE PAYMENT WITH USSD");
        Thread.sleep(2000);
        driver.get("https://emaxkemiyop.cicod.com/cuorma/web/value-chain/order?id=10147");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryPlus_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectBeverages_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11lxxo = driver.findElement(By.xpath(Utility.fetchLocator("mdd_XPATH")));
        JavascriptExecutor jselxxo = (JavascriptExecutor) driver;
        jselxxo.executeScript("arguments[0].scrollIntoView();", ti11lxxo);

        Thread.sleep(1200);
        WebElement ti112aao = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2aao = (JavascriptExecutor) driver;
        jse2aao.executeScript("arguments[0].scrollIntoView();", ti112aao);
        ti112aao.click();

        Thread.sleep(2000);
        WebElement ti112llm = driver.findElement(By.xpath(Utility.fetchLocator("ValueChainPayUSSD_XPATH")));
        JavascriptExecutor jse2llm = (JavascriptExecutor) driver;
        jse2llm.executeScript("arguments[0].scrollIntoView();", ti112llm);
        ti112llm.click();

        assertion.DoAssertXpathPresentWhenReady("con1_XPATH", "UssdPass_TEXT", "UssdFail_TEXT", 30);
    }
}
