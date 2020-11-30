package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.RavePay;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class ContinueSavedOrder extends TestBase {
    @Test
    public void CONTINUE_SAVE_ORDER() throws IOException, InterruptedException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;
        Utility utility = new Utility(driver);
        ScreenShot screenshot = new ScreenShot(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Createorderbtn_XPATH", "CreateOrder_TEXT",40);
        utility.DoscrolltoViewClickWhenReady("ViewSavedOrer_XPATH", "ViewSa_TEXT",40);
        utility.DoclickWhenReady("SelectOre11_XPATH", "ViewSa_TEXT",40);
        utility.DoAssertContainsWhenReady("AssertAlert_XPATH","alercon_TEXT","SOpass_TEXT","SOFail_TEXT",60);
        utility.DoAssertXpathPresentWhenReady("Ooo_XPATH","SOpass_TEXT","SOFail_TEXT",60);
        utility.DoAssertXpathPresentWhenReady("Ooo_XPATH","ASERTORE_XPATH","SOFail_TEXT",60);

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(4000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(st);

        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("option-payment-amount-xs")).getText());
        assertEquals("NGN203.00", driver.findElement(By.id("option-payment-amount-xs")).getText());
        test.log(Status.PASS, "Vat Exemption is confirmed");

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        test.log(Status.INFO, "MAKE PAYMENT WITH POS");

        Thread.sleep(2000);
        driver.get("https://nexusnigeria.cicod.com/cuorma/web/index.php/site/order-product?inv_search_text=Tomatoes");

        //SEARCH BY NAME
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH"))).click();

        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11kk = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsekk = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11kk);
        ti11kk.click();

        Thread.sleep(2000);
        WebElement ele111ll = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11ll = new Select(ele111ll);
        sel11ll.selectByIndex(st);

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        test.log(Status.INFO, "MAKE PAYMENT WITH POS");

        Thread.sleep(2000);
        WebElement ti112lll = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2lll = (JavascriptExecutor) driver;
        jse2lll.executeScript("arguments[0].scrollIntoView();", ti112lll);
        ti112lll.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();

        Thread.sleep(200);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Payment yet to be received on Order")) {
            test.log(Status.PASS, "Pay with POS Functional");
        } else {
            test.log(Status.FAIL, "Pay with POS Failed");
        }
    }
}