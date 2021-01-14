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

public class CreateSaleTarget extends TestBase {

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

    @Description("Sales Target Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SalesTargetManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickFluentWait("SaleTargetManagementBTN_XPATH", "SaleTargetManagementBTN_XPATH", 60);
    }

    @Description("Create Sales Target Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void CreateSalesTargetManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickFluentWait("CreateThe_XPATH", "CreateThe_XPATH", 60);
    }

    @Description("Sales Target Group Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void SalesTargetGroupName() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DosendKeysRandomListwordsWhenReady("SalesTargetGroupName_XPATH", "SalesTargetGroupName_XPATH", 60);
    }

    @Description("Sales Target Amount")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void SalesTargetAmount() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DosendKeysRandomNumberWhenReady("SalesTargetAmount_XPATH", 45, 60);
    }

    @Description("Target Type")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void TargetType() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoSelectValuesByIndexRandom("TargetType_XPATH", 2, 20);
    }

    @Description("Input")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void Input() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("InputA_XPATH", 20);
        excelUtil.DoclickWhenReady("InputB_XPATH", 20);
        excelUtil.DoclickWhenReady("InputC_XPATH", 20);
    }

    @Description("Create Sales Target")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void CreateSalesTarget() throws IOException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("CreateSaleTargetSaveBTN_XPATH", 20);
    }

    @Description("Assert Create Sales Target")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void AssertCreateSalesTarget() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("InvoiceAlert_XPATH", "Cccc_TEXT", "CcccPass_TEXT", "CcccFail_TEXT", 20);
    }
}
