package CROWN.CICOD.COM.CustomerManagment;

import CROWN.Base.TestBase;
import CROWN.utility.ExcelUtil;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Suspend_UnsuspendCustomerFromCustomerManagementPage extends TestBase {

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
        excelUtil.DoclickWhenReady("SelectCustomerbtn_XPATH", 20);

    }

    @Description("Action Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void ActionButton() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("ActionSuspend_XPATH", 20);
    }

    @Description("View Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void ViewCustomer() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickWhenReady("VIEWCustomer_XPATH", 20);
    }

    @Description("Suspend Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void SuspendCustomer() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        Utility utility = new Utility(driver);
        excelUtil.DoscrolltoViewClickWhenReady("SuspendFromCustomerPage_XPATH", 20);
        utility.DowaitandAcceptAlerwhenReady(20);
    }

    @Description("Unsuspend Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void UnsuspendCustomer() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        Utility utility = new Utility(driver);
        excelUtil.DoscrolltoViewClickWhenReady("UnsuspendfromCustomerPage_XPATH", 20);
        utility.DowaitandAcceptAlerwhenReady(20);
    }
}
