package CROWN.CICOD.COM.Account;

import CROWN.Base.TestBase;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.AssertJUnit.assertEquals;


public class CreateCreditNote extends TestBase {

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

    @Description("Account Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void AccountButton() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("AccountBTN_XPATH", "CreditN_TEXT", 60);
    }

    @Description("Credit Note Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void CreditNoteButton() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("CreditNote_XPATH", "CreditN_TEXT", 60);
    }

    @Description("Create Credit Note Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void CreateCreditNoteButton() throws IOException, InterruptedException {
        JavaScriptUtil utility = new JavaScriptUtil(driver);
        utility.DoscrolltoViewClickFluentWait("CreateCreditNote_XPATH", "CreateCN_TEXT", 60);
    }

    @Description("Input Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void InputCustomerName() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoSendKeysRobotClassFluentWait("CCustomer_XPATH", "EnterName_TEXT", "EnterName_TEXT", 60);
    }

    @Description("Select Reason")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void SelectReason() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoSelectValuesByIndex("cReason_XPATH", "SS_TEXT", 2, 60);
    }

    @Description("input Invoice Number")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void inputInvoiceNumber() throws IOException, InterruptedException, AWTException {
        SecureRandom rn = new SecureRandom();
        int aa = rn.nextInt(60000) + 1;
        driver.findElement(By.xpath(Utility.fetchLocator("InvoiceNum_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + aa);
    }

    @Description("Enter Quantity")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void EnterQuantity() throws IOException, InterruptedException, AWTException {
        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Quant_XPATH"))).sendKeys("2000");
    }

    @Description("Enter Amount")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void EnterAmount() throws IOException, InterruptedException, AWTException {
        Thread.sleep(1200);
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        driver.findElement(By.xpath(Utility.fetchLocator("Amount_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + a);
    }

    @Description("Description")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void Description() throws IOException, InterruptedException, AWTException {
        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Cdes_XPATH"))).sendKeys("Testing Credit note");
    }

    @Description("Send Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void SendButton() throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Senddd_XPATH"))).click();
    }

    @Description("Assert Credit Note Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void AssertCreditNoteCreation() throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        assertEquals("×\n" + "Credit note created successfully", driver.findElement(By.xpath(Utility.fetchLocator("AssertBanner_XPATH"))).getText());
    }
}
