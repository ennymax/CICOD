package CROWN.CICOD.COM.SaleAgentManagement;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateSalesCommissionOnTarget extends TestBase {

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

    @Description("Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void SalesManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickFluentWait("SaleManagementBTN_XPATH", "SaleManagementBTN_XPATH", 60);
    }

    @Description("Sale Commission")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SaleCommission() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickFluentWait("SaleCommissionBTN_XPATH", "SaleCommissionBTN_XPATH", 60);
    }

    @Description("Create Sale Commission")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void CreateSaleCommission() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickFluentWait("CreateSaleCommissiontBTN_XPATH", "CreateSaleCommissiontBTN_XPATH", 60);
    }

    @Description("Commission Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void CommissionName() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DosendKeysRandomListwordsWhenReady("ComissionName_XPATH", 20);
    }

    @Description("EE")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void EE() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoSelectValuesByIndex("ccc_XPATH", 2, 20);
        excelUtil.DoSelectValuesByIndex("vb_XPATH", 1, 20);
    }

    @Description("Actual Value")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void ActualValue() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoSendKeysWhenReady("ActualValue_XPATH", "45_TEXT", 20);
    }

    @Description("AA")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void AA() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("AAAA_XPATH", 20);
        Thread.sleep(6000);
    }

    @Description("Assert Create Sales Commission")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void AssertCreateSalesCommission() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("mct_XPATH", "Commissioncont_TEXT", "comOPass_TEXT", "comOFail_TEXT", 20);
    }
}
