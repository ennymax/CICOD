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

public class PayNow extends TestBase {

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

    @Description("Search Customer By Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SearchCustomerByName() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("SearchByName_XPATH", 30);
        util.DoSendKeysWhenReady("SeaerchInput_XPATH", "CustomerName_TEXT", 20);
        util.DoscrolltoViewClickWhenReady("Searchbtn_XPATH", 30);
    }

    @Description("View Customer Details")
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
        assertion.DoAssertContainsWhenReady("AssertSearchByName_XPATH", "cot_TEXT", "searpass_TEXT", "searfail_TEXT", 20);
    }

    @Description("Search Product")
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

    @Description("Add Product to Chart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void ViewFreebies() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("ViewFreebies_XPATH", 30);
    }

    @Description("Add Product to Chart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void Check_Offer_AddOffer() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("quiCheck_XPATH", 30);
        util.DoscrolltoViewClickWhenReady("AddQui_XPATH", 30);
    }

    @Description("Add Product to Chart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void SelectOffer() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Offer1_XPATH", 30);
    }

    @Description("Assert Product Offer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void AssertProductOffer() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathPresentWhenReady("assFreebies_XPATH", "assfrepass_TEXT", "assfreefail_TEXT", 20);
    }

    @Description("Assert Product Offer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void Assert_Product_Offer_Price() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertEqualWhenReady("Assertfreebies_XPATH", "asserStriTEXT", "assfrepass1_TEXT", "assfreefail1_TEXT", 20);
    }


    @Description("Select Region")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 14)
    public void SelectRegion() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Description("Make Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void MakePayment() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

    }

    @Description("Pay POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void PayPOS() throws IOException, InterruptedException {
        Thread.sleep(2000);
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoActionsClick("PayPoS_XPATH", 20);
        actionsClass.DoActionsClick("ConfirmPAymantPOS_XPATH", 20);
    }

    @Description("Assert Pay POS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 16)
    public void AssertPayPOS() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("ComfirmPOSPayment_XPATH", "fr_TEXT", "frPass_TEXT", "frFail_TEXT", 20);
    }
}
