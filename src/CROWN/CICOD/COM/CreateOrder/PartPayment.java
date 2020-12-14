package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.*;
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

@Epic("Part Payment")
@Story("Test Part Payment Module..")
public class PartPayment extends TestBase {

    @Description("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
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

    @Description("Assrt View Customer Details")
    @Severity(SeverityLevel.CRITICAL)
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
        utility.DoscrolltoViewClickWhenReady("PaymentOptions_XPATH", "PaymentOPT_TEXT", 50);
        utility.DoclickWhenReady("NewPayAccount_XPATH", "Payno_TEXT", 40);
    }

    @Description("Test Select Part Payment Option")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void PartPayment() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoscrolltoViewClickWhenReady("PartPayment_XPATH", "MakePayment_TEXT", 40);
    }

    @Description("Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void Payment() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoscrolltoViewClickWhenReady("MakePayment_XPATH", "MakePayment_TEXT", 40);
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
    public void SelectPaymentDate() throws IOException, InterruptedException {
        DatePicker datePicker = new DatePicker(driver);
        datePicker.DatePickerJE("PartPaymentDate_XPATH","10/10/2020");

        Thread.sleep(99999999);
    }

    @Test(priority = 18)
    public void MakePartPayment() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBTN_XPATH"))).click();
    }


    @Test(priority = 1400)
    public void PartPaymentv() throws IOException, InterruptedException {

        Thread.sleep(999999999);
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
        String text1 = msg1.getText();
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
