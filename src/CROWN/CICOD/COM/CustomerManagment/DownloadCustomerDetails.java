package CROWN.CICOD.COM.CustomerManagment;

import CROWN.Base.TestBase;
import CROWN.utility.ExcelUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class DownloadCustomerDetails extends TestBase {

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

    @Description("Select Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SelectCustomer() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("SelectCustomerbtn_XPATH", 20);
    }

    @Description("Download Customer Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void DownloadCustomerDetails() throws IOException, InterruptedException, AWTException {
        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoclickWhenReady("DownloadCUstomerdbtn_XPATH", 20);
    }

}
