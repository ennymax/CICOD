package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.AssertJUnit.assertEquals;

public class ContinueSavedOrder extends TestBase {

    @Description("login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Customer Order Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Description("Create Order")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void CreateOrder() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Createorderbtn_XPATH", 30);
    }

    @Description("View Saved Order")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void ViewSavedOrder() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("ViewSavedOrer_XPATH", "ViewSa_TEXT",40);
        utility.DoclickWhenReady("SelectOre11_XPATH", "ViewSa_TEXT",40);
    }

    @Description("Assert View Saved Order")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void AssertViewSavedOrder() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertAlert_XPATH","alercon_TEXT","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","ASERTORE_XPATH","SOFail_TEXT",60);
    }

    @Description("Select Region")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void SelectRegion() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Description("Make Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void MakePayment() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();
    }

    @Description("Rav Pay")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void RavPay() throws IOException, InterruptedException {
        RavePay ravePay = new RavePay(driver);
        ravePay.RavePay2();
    }

    @Description("Assert Pay Online")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void AssertPayOnline() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("Auth_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Enter your 4-digit card pin to authorize this payment")) {
            test.log(Status.PASS, "Flutterwave Payment Portal Fully Functional");
        } else {
            test.log(Status.FAIL, "Payment Portal down");
        }
    }

    @Description("Navigate URL")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void NavigateURL() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.get("https://nexusnigeria.cicod.com/cuorma/web/index.php/site/order-product?inv_search_text=Tomatoes");
    }

    @Description("View Saved Order POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void ViewSavedOrderPOS() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("ViewSavedOrer_XPATH", "ViewSa_TEXT",40);
        utility.DoclickWhenReady("SelectOre11_XPATH", "ViewSa_TEXT",40);
    }

    @Description("AssertViewSavedOrderPOS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void AssertViewSavedOrderPOS() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertAlert_XPATH","alercon_TEXT","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","ASERTORE_XPATH","SOFail_TEXT",60);
    }

    @Description("Select Region POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void SelectRegionPOS() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Description("Make Payment POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 14)
    public void MakePaymentPOS() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();
    }

    @Description("POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void POS() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();
    }

    @Description("Assert Pay POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 16)
    public void AssertPayPOS() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("ComfirmPOSPayment_XPATH", "fr_TEXT", "frPass_TEXT", "frFail_TEXT", 20);
    }
}