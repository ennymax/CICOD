package CROWN.CICOD.COM.Loyalty;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.ExcelUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class UpdatePointSetUp extends TestBase {

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

    @Description("Loyalty")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void Loyalty() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("LoyaltyBTN_XPATH", 30);
    }

    @Description("Point SetUp")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void PointSetUp() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("PointSetup_XPATH", 30);
    }

    @Description("Action")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void Action() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("ActionPointSetUp_XPATH", 30);
    }

    @Description("Update Point")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void UpdatePoint() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoclickWhenReady("UpdateActionPoint_XPATH", 30);
    }

    @Description("EE")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void ProductSpendA() throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(50) + 1;
        WebElement K = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.name("ProductSpecificSpend[point]")));
        K.clear();
        K.sendKeys(Utility.fetchLocator("Empty_TEXT") + st);
    }

    @Description("Save Product Specific Spend")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void SaveProductSpecificSpend() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("SaveCreateProductSpecificSpend_XPATH", 20);
    }

    @Description("Assert Update Point SetUp")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void AssertUpdatePointSetUp() throws IOException, InterruptedException, AWTException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertProductCate_XPATH", "contP_TEXT", "ContP_TEXT", "ContF_TEXT", 20);
    }
}
