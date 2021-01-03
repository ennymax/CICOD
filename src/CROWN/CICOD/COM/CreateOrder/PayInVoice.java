package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class PayInVoice extends TestBase {


    @Description("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Access COM")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Description("Create Order Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void CreateOrder() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Createorderbtn_XPATH", 30);
    }

    @Description("Search Customer By Name")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4)
    public void SearchCustomerByName() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("SearchByName_XPATH", 30);
        util.DoSendKeysWhenReady("SeaerchInput_XPATH", "CustomerName_TEXT", 20);
        util.DoscrolltoViewClickWhenReady("Searchbtn_XPATH", 30);
    }

    @Description("View Customer Details")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5)
    public void ViewCustomerDetails() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("ViewDetails_XPATH", 30);
    }

    @Description("Assert if Customer can be viewed")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6)
    public void AssertViewCustomerDetails() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertSearchByName_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Email Address")) {
            test.log(Status.PASS, "Search By Name Success");
        } else {
            test.log(Status.FAIL, "Search By Name Failed");
        }
    }

    @Description("Search Product")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7)
    public void SearchProduct() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoSendKeysWhenReady("SearchProductinput_XPATH", "ID_TEXT", 20);
        util.DoscrolltoViewClickWhenReady("SearchProductbtnq_XPATH", 30);
    }

    @Description("Add Product to chart")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 8)
    public void AddProducttoChart() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("AddBTN_XPATH", 30);
    }

    @Description("Test Apply Discount Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 9)
    public void ApplyDiscount() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Applydiscount_XPATH", 30);
        util.DoSendKeysWhenReady("DiscountByPercent_XPATH", "10_TEXT", 30);
        util.DoscrolltoViewClickWhenReady("OkDiscount_XPATH", 30);
        util.DoscrolltoViewClickWhenReady("ConfirmOKDiscount_XPATH", 30);
    }

    @Description("Select region")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 10)
    public void SelectRegion() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Description("Select Payment Option")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 11)
    public void PaymentOption() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        javaScriptUtil.DoscrolltoViewClickWhenReady("PaymentOptions_XPATH", "PaymentOPT_TEXT", 50);
        utility.DoclickWhenReady("NewPayAccount_XPATH", "Payno_TEXT", 40);
    }

    @Description("Select PayAccount")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 12)
    public void PayAccount() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("MakePayment_XPATH", "MakePayment_TEXT", 40);
        utility.DowaitandAcceptAlerwhenReady(60);
    }



    @Test
    public void Pay_Invoice() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayInVoice_XPATH"))).click();

        WebElement tid = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tid);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("GenerateOrderCode_XPATH"))).click();
        test.log(Status.PASS, "Order Code Was Generated Successfully");

        Thread.sleep(2000);
        login.AcceptAlert();

        Thread.sleep(1500);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("SendOrderConfirmation_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Send Order Confirmation")) {
            test.log(Status.PASS, "Order Confirmation page is Functional");
        } else {
            test.log(Status.FAIL, "Failed to Load Order confirmation Page");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SendOrderConfirmation_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowPayAccount_XPATH"))).click();

        Thread.sleep(1300);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("PayfromAccount_XPATH"))).click();
        test.log(Status.PASS, "Pay from Account Fully Functional");

        Thread.sleep(2000);
        login.AcceptAlert();

    }
}
