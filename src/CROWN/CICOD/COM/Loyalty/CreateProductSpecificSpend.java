package CROWN.CICOD.COM.Loyalty;

import CROWN.Base.TestBase;
import CROWN.utility.ExcelUtil;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateProductSpecificSpend extends TestBase {

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

    @Description("Create Product Specific Spend")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void CreateProductSpecificSpend() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("CreateProductSpecificSpendBTN_XPATH", 30);
    }

    @Description("Create Product Spend")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void CreateProductSpend() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("CreateProductSpe_XPATH", 30);
        util.DoscrolltoViewClickWhenReady("cd_XPATH", 30);
    }

    @Description("Product Spend Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void ProductSpendName() throws IOException, InterruptedException, AWTException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DosendKeysRandomListwordsWhenReady("Danny_XPATH", 20);
        Robot r = new Robot();
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyPress(KeyEvent.VK_ENTER);
    }

    @Description("Product Spend Amount")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void ProductSpendAmount() throws IOException, InterruptedException, AWTException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DosendKeysRandomNumberWhenReady("A_XPATH", 1000000000, 20);
    }

    @Description("EE")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void ProductSpendA() throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(50) + 1;
        WebElement K = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.name("ProductSpecificSpend[point]")));
        K.clear();
        K.sendKeys(Utility.fetchLocator("Empty_TEXT") + st);
    }

    @Description("Period")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void Period() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoSelectValuesByIndex("Period_XPATH", 1, 20);
    }

    @Description("Save Product Specific Spend")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void SaveProductSpecificSpend() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("SaveCreateProductSpecificSpend_XPATH", 20);
    }
}
