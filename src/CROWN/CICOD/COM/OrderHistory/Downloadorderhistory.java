package CROWN.CICOD.COM.OrderHistory;

import CROWN.Base.TestBase;
import CROWN.utility.ExcelUtil;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Downloadorderhistory extends TestBase {


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

    @Description("Order History")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void OrderHistory() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("OrderHistorybtn_XPATH", 30);
    }

    @Description("Download Order History")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void DownloadOrderHistory() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("DownloadOrderHistorybtn_XPATH", 30);
    }
}