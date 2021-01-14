package CROWN.CICOD.COM.OrderHistory;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class VIEW_ORDER_HISTORY extends TestBase {
    ScreenShot screenshot = new ScreenShot(driver);

    @Test(priority = 1)
    public void loginAsAdmin() throws IOException, InterruptedException {
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

    @Description("Order Record")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void OrderRecord() throws IOException, InterruptedException {
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnOrderRecordsbtn_XPATH"))).click();
    }

    @Description("Assert ORDER History")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void Assert_ORDER_history() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathPresentWhenReady("AssertRecord_XPATH", "OrderPass_TEXT", "OrderFail_TEXT", 20);
    }
}
