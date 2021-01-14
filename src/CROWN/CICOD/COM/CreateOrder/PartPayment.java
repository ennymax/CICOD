package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.io.IOException;

@Epic("Part Payment")
@Story("Test Part Payment Module..")
public class PartPayment extends TestBase {

    @Description("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void login() throws Exception {
        Login login = new Login(driver);
        login.Login();

    }

    @Description("COM")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Description("Test Create Order")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void CreateOrder() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Createorderbtn_XPATH", 30);
    }

    @Description("Search Customer By Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SearchCustomerByName() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("SearchByName_XPATH", 30);
        util.DoSendKeysWhenReady("SeaerchInput_XPATH", "CustomerName_TEXT", 20);
        util.DoscrolltoViewClickWhenReady("Searchbtn_XPATH", 30);
    }

    @Description("View Customer By Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void ViewCustomerDetails() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("ViewDetails_XPATH", 30);
    }

    @Description("Assert View Customer Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void AssertViewCustomerDetails() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertSearchByName_XPATH","cot_TEXT","searpass_TEXT","searfail_TEXT",20);
    }

    @Description("Search Product By Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void SearchProduct() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoSendKeysWhenReady("SearchProductinput_XPATH", "ID_TEXT", 20);
        util.DoscrolltoViewClickWhenReady("SearchProductbtnq_XPATH", 30);
    }

    @Description("Add Product to Chart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void AddProducttoChart() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("AddBTN_XPATH", 30);
        Thread.sleep(2000);
        util.DoscrolltoViewClickWhenReady("AddBTN_XPATH", 30);
    }

    @Description("Test Apply Discount Module")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void ApplyDiscount() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Applydiscount_XPATH", 30);
        util.DoSendKeysWhenReady("DiscountByPercent_XPATH", "10_TEXT", 30);
        util.DoscrolltoViewClickWhenReady("OkDiscount_XPATH", 30);
        util.DoscrolltoViewClickWhenReady("ConfirmOKDiscount_XPATH", 30);
    }

    @Description("Test Discount Module")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void SelectRegion() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Description("Select Payment Option")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void PaymentOption() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("PaymentOptions_XPATH", "PaymentOPT_TEXT", 50);
        utility.DoclickWhenReady("NewPayAccount_XPATH", "Payno_TEXT", 40);
    }

    @Description("Test Select Part Payment Option")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void PartPayment() throws IOException, InterruptedException {
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        javaScriptUtil.DoscrolltoViewClickWhenReady("PartPayment_XPATH", "MakePayment_TEXT", 40);
    }

    @Description("Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void Payment() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        javaScriptUtil.DoscrolltoViewClickWhenReady("MakePayment_XPATH", "MakePayment_TEXT", 40);
    }

    @Description("Pay Amount for Part Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void PayAmount() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PartPaymentAmount_XPATH"))).sendKeys(Utility.fetchLocator("pamt_TEXT"));
    }

    @Description("Select Payment Date")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 17)
    public void SelectPaymentDate() throws IOException {
        DatePicker datePicker = new DatePicker(driver);
        datePicker.DatePickerJE("PartPaymentDate_XPATH","10/10/2020");
    }

    @Description("Proceed To Make Part Payment")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 18)
    public void MakePartPayment() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBTN_XPATH"))).click();
    }

    @Description("Select PayOnline")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 19)
    public void AssertPayOnline() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("PayOnline_XPATH", "PAyOnline_TEXT", 40);
        utility.DoswitchtoframeWhenReady(0, 13000);
    }

    @Description("Rave Pay")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 20)
    public void RavePay() throws Exception {
        RavePay ravePay = new RavePay(driver);
        ravePay.RavePay3();
    }
}
