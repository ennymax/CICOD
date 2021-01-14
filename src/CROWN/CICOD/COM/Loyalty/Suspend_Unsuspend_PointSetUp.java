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

import java.io.IOException;
import java.security.SecureRandom;

public class Suspend_Unsuspend_PointSetUp extends TestBase {

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

    @Description("Loyalty")
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

    @Description("Suspend Point Set Up")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void SuspendPointSetUp() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("SuspendPointSetUp_XPATH", 30);
    }

    @Description("Accept Alert")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void AcceptAlert() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DowaitandAcceptAlerwhenReady(20);
    }

    @Description("Accept Alert")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void AssertPointSetUp() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertProductCate_XPATH", "PoitCont_TEXT", "PoitPass_TEXT", "PoitFail_TEXT", 20);
    }

    @Description("Action")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void Action1() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("ActionPointSetUp_XPATH", 30);
    }

    @Description("Unsuspend Point Set Up")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void UnsuspendPointSetUp() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("UnsuspendPointSetUp_XPATH", 30);
    }

    @Description("Accept Alert")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void AcceptAlert1() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DowaitandAcceptAlerwhenReady(20);
    }

    @Description("Assert Unsuspend Point Set Up")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void AssertUnsuspendPointSetUp() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("Asser_XPATH", "coint_TEXT", "PoitPass1_TEXT", "PoitFail1_TEXT", 20);
    }
}
