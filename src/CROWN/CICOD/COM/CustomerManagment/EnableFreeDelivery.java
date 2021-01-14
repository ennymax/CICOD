package CROWN.CICOD.COM.CustomerManagment;

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

import java.awt.*;
import java.io.IOException;

public class EnableFreeDelivery extends TestBase {

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

    @Description("Customer Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void CustomerManagement() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("Customermanagmentbtn_XPATH", 20);
    }

    @Description("Action Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void ActionButton() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("ActionSuspend_XPATH", 20);
    }

    @Description("Update customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void UpdateCustomer() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("UpdateCustoo_XPATH", 20);
    }

    @Description("Enable VAT Exemption")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void EnableVatExemption() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("EnableVatExemption_XPATH", 20);
    }

    @Description("Update Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void UpdateDetails() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DosendKeysRandomListwordsWhenReady("FirstName_XPATH", 20);
        excelUtil.DosendKeysRandomListwordsWhenReady("LastName_XPATH", 20);
    }

    @Description("Assert Free Delivery")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void AssertFreeDelivery() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        assertion.DoCheckBoxSelected("EnableFreeDeliv_XPATH", "VatPaa_TEXT", "VatPaa_TEXT", 20);
    }

    @Description("Enable VAT Exemption")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void EnableVATExemption() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        assertion.DoCheckBoxSelected("EnableVatExemption_XPATH", "VatEx_TEXT", "VatEx_TEXT", 20);
    }

    @Description("House Address")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void HouseAddress() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DosendKeysRandomListwordsWhenReady("Houshhh_XPATH", 20);
        excelUtil.DosendKeysRandomListwordsWhenReady("Strrrr_XPATH", 20);
        excelUtil.DosendKeysRandomListwordsWhenReady("cLan_XPATH", 20);
    }

    @Description("Customer Delivery Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void CustomerDeliveryDetails() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoSelectValuesByVisibleText("Country_XPATH", "Country_TEXT", 20);
        excelUtil.DoSelectValuesByVisibleText("Cstate_XPATH", "State_TEXT", 20);
        excelUtil.DoSelectValuesByVisibleText("Clga_XPATH", "LGA_TEXT", 20);
    }

    @Description("Set Default Address")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void SetDefaultAddress() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        assertion.DoCheckBoxSelected("etAsDef_XPATH", "SetDefault_TEXT", "SetDefault_TEXT", 20);
    }

    @Description("Update Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void UpdateButton() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("Csave_XPATH", 20);
    }

    @Description("Assert Update Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 14)
    public void AssertUpdateCustomer() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("cccg_XPATH", "mi_TEXT", "M1Pass_TEXT", "m1fail_TEXT", 20);
    }


    //Creating  Order To Verify Tax Exemption
    @Description("Update Customer Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void UpdateCustomerButton() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("CreatV_XPATH", 20);
    }

    @Description("Search Product")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 16)
    public void SearchProduct() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoSendKeysWhenReady("SearchProductinput_XPATH", "ID_TEXT", 20);
    }

    @Description("Search Product Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 17)
    public void SearchProductButton() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("SearchProductbtnq_XPATH", 20);
    }

    @Description("Add Product To Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 18)
    public void AddProductToCart() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("AddBTN_XPATH", 20);
    }

    @Description("Delivery Address")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 19)
    public void DeliveryAddress() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("Deliv_XPATH", 20);
        excelUtil.DoclickWhenReady("DELLL_XPATH", 20);
    }

    @Description("Specific Delivery Address")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 20)
    public void SpecificDeliveryAddress() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        assertion.DoCheckBoxSelected("SpecificCusAddress_XPATH", "SpeciPass_TEXT", "SpeciPass_TEXT", 20);
    }

    @Description("Address")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 21)
    public void Address() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("SelectAdd_XPATH", 20);
        excelUtil.DoscrolltoViewClickWhenReady("jjregion_XPATH", 20);
        excelUtil.DoSelectValuesByIndex("SelectRegion_XPATH", 1, 20);
    }

    @Description("Make Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 22)
    public void MakePayment() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("MakePayment_XPATH", 20);
    }

    @Description("Pay Online")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 23)
    public void PayOnline() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("PayOnline_XPATH", 20);
    }

    @Description("Assert free Delivery")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 24)
    public void AssertfreeDelivery() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        Thread.sleep(13000);
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        assertion.DoAssertEqualWhenReady("ASSenable_XPATH", "NGN203.00", "AssertDelPass_TEXT", "AssertDelFailed_TEXT", 60);
    }
}