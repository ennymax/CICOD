package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("PayAccount")
@Story("Testing The PayAccount Module ")
public class PayAccount extends TestBase {

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

    @org.springframework.context.annotation.Description("Assert View Customer Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void AssertViewCustomerDetails() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertSearchByName_XPATH","cot_TEXT","searpass_TEXT","searfail_TEXT",20);
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

    @Description("Assert PayAccount")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 13)
    public void AssertPayAccount() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertOrdeIDgenerated_XPATH", "OrDerID_TEXT", "OrDerID_TEXT", "OrderIDPass_TEXT", 30);
    }

    @Description("Proceed to make PAyment")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 14)
    public void PayNowAccount() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("PayNowPayAccount_XPATH", "PayAcct_TEXT", 40);
    }

    @Description("Select PayOnline")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 15)
    public void AssertPayOnline() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("PayOnline_XPATH", "PAyOnline_TEXT", 40);
        utility.DoswitchtoframeWhenReady(0, 13000);
    }

    @Description("Demo Rave Pay")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 16)
    public void RavePay() throws IOException, InterruptedException {
        RavePay ravePay = new RavePay(driver);
        ravePay.RavePay3();
    }

    @Description("Navigate Back To Select USSD")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 18)
    public void MakePaymentUSSD() throws IOException, InterruptedException {
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("p1_XPATH", "PayAcct_TEXT", 40);
    }

    @Description("Pay USSD")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 19)
    public void USSD() throws IOException, InterruptedException {
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();
    }

    @Description("Assert USSD")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 20)
    public void AssertUSSD() throws IOException, InterruptedException {
        Thread.sleep(200);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Payment yet to be received on Order")) {
            test.log(Status.PASS, "Pay with POS Functional");
        } else {
            test.log(Status.FAIL, "Pay with POS Failed");
        }
    }

    @Description("Make Payment POS")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 21)
    public void MakePaymentPOS() throws IOException, InterruptedException {
        driver.navigate().refresh();
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("PayNowPayAccount_XPATH", "PayAcct_TEXT", 40);
    }

    @Description("POS")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 22)
    public void POS() throws IOException, InterruptedException {
        Thread.sleep(20);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();
    }

    @org.springframework.context.annotation.Description("Assert Pay POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 23)
    public void AssertPayPOS() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("ComfirmPOSPayment_XPATH", "fr_TEXT", "frPass_TEXT", "frFail_TEXT", 20);
    }
}
