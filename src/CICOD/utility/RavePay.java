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
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("RavePayCardnumber_XPATH", "Ca_TEXT","CardNumber_TEXT",60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH", "ValidTm_TEXT","e1_TEXT", 60);
        utility.DoSendKeysByActionClassWhenReady("RavePayValidTill_XPATH","e2_TEXT","V_TEXT",60);
        utility.DoSendKeysWhenReady("RavPayCVV_XPATH", "CVVd_TEXT","CVV_TEXT", 60);
        utility.DoclickWhenReady("fg_XPATH","P_TEXT",60);
    }


    public void RavePay2() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("RavePayCardnumber_XPATH", "Ca_TEXT","CardNumber_TEXT",60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH", "ValidTm_TEXT","e1_TEXT", 60);
        utility.DoSendKeysByActionClassWhenReady("RavePayValidTill_XPATH","e2_TEXT","V_TEXT",60);
        utility.DoSendKeysWhenReady("RavPayCVV_XPATH", "CVVd_TEXT","CVV_TEXT", 60);
        utility.DoclickWhenReady("fg_XPATH","P_TEXT",60);
        Thread.sleep(3000);

    }


    public void RavePay() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("RavePayCardnumber_XPATH", "Ca_TEXT","CardNumber_TEXT",60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH", "ValidTm_TEXT","e1_TEXT", 60);
        utility.DoSendKeysByActionClassWhenReady("RavePayValidTill_XPATH","e2_TEXT","V_TEXT",60);
        utility.DoSendKeysWhenReady("RavPayCVV_XPATH", "CVVd_TEXT","CVV_TEXT", 60);
        utility.DoclickWhenReady("fg_XPATH","P_TEXT",60);

        utility.DoSendKeysByActionClassWhenReady("a1_XPATH","a11_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a2_XPATH","a21_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a3_XPATH","a31_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a4_XPATH","a41_TEXT","E_TEXT",60);
    }

    public void RavePay1() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("RavePayCardnumber_XPATH", "Ca_TEXT","CardNumber_TEXT",60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH", "ValidTm_TEXT","e1_TEXT", 60);
        utility.DoSendKeysByActionClassWhenReady("RavePayValidTill_XPATH","e2_TEXT","V_TEXT",60);
        utility.DoSendKeysWhenReady("RavPayCVV_XPATH", "CVVd_TEXT","CVV_TEXT", 60);
        utility.DoclickWhenReady("fg_XPATH","P_TEXT",60);

        utility.DoSendKeysByActionClassWhenReady("a1_XPATH","a11_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a2_XPATH","a21_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a3_XPATH","a31_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a4_XPATH","a41_TEXT","E_TEXT",60);
    }

    public void RavePayWorkShop() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
        driver.switchTo().frame("checkout");
        Utility utility = new Utility(driver);

        utility.DoSendKeysWhenReady("RavePayCardnumber_XPATH", "Ca_TEXT","CardNumber_TEXT",60);
        utility.DoSendKeysWhenReady("RavePayValidTill_XPATH", "ValidTm_TEXT","e1_TEXT", 60);
        utility.DoSendKeysByActionClassWhenReady("RavePayValidTill_XPATH","e2_TEXT","V_TEXT",60);
        utility.DoSendKeysWhenReady("RavPayCVV_XPATH", "CVVd_TEXT","CVV_TEXT", 60);
        utility.DoclickWhenReady("fg_XPATH","P_TEXT",60);

        utility.DoSendKeysByActionClassWhenReady("a1_XPATH","a11_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a2_XPATH","a21_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a3_XPATH","a31_TEXT","E_TEXT",60);
        utility.DoSendKeysByActionClassWhenReady("a4_XPATH","a41_TEXT","E_TEXT",60);

        utility.DoSendKeysByActionClassWhenReady("OTP_XPATH","otp_TEXT","otp_TEXT",60);

        utility.DoclickWhenReady("AuthorizePaymentBTN_XPATH","Authorize_TEXT",60);
    }
}
