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

    @org.springframework.context.annotation.Description("Assert View Customer Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void AssertViewCustomerDetails() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertSearchByName_XPATH", "cot_TEXT", "searpass_TEXT", "searfail_TEXT", 20);
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

    @Description("Pay Invoice")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 12)
    public void PayInvoice() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("PayInVoice_XPATH", 20);
    }

    @Description("Generate Order Code")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 13)
    public void GenerateOrderCode() throws IOException, InterruptedException {
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        javaScriptUtil.DoscrolltoViewClickWhenReady("GenerateOrderCode_XPATH", "GenerateOrderCode_XPATH", 20);
    }

    @Description("Accept Alert")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 14)
    public void AcceptAlert() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DowaitandAcceptAlerwhenReady(20);
    }

    @Description("Assert Order Code Generation")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 15)
    public void AssertOrderCodeGeneration() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("SendOrderConfirmation_XPATH", "sss_TEXT", "OrderCodePass_TEXT", "OrderCodeFailed_TEXT", 20);
    }

    @Description("Send Order Confirmation")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 15)
    public void SendOrderConfirmation() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("SendOrderConfirmation_XPATH", 20);
    }

    @Description("Pay Now Pay Account")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 17)
    public void PayNowPayAccount() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("PayNowPayAccount_XPATH", 20);
    }

    @Description("PayfromAccount")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 18)
    public void PayfromAccount() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("PayfromAccount_XPATH", 20);
    }

    @Description("Accept Alert Pay Account")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 19)
    public void AcceptAlertPayAccount() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DowaitandAcceptAlerwhenReady(20);
    }
}
