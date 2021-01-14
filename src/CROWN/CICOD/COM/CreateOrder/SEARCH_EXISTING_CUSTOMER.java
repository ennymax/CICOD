package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.io.IOException;

public class SEARCH_EXISTING_CUSTOMER extends TestBase {
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

    @Description("Create Order")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void CreateOrder() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Createorderbtn_XPATH", 30);
    }

    @Description("Search Customer By Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SearchCustomerByName() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("SearchByName_XPATH", 30);
        util.DoSendKeysWhenReady("SeaerchInput_XPATH", "CustomerName_TEXT", 20);
        util.DoscrolltoViewClickWhenReady("Searchbtn_XPATH", 30);
    }

    @Description("View Customer Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void ViewCustomerDetails() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("ViewDetails_XPATH", 30);
    }

    @Description("Assert View Customer Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void AssertViewCustomerDetails() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertSearchByName_XPATH","cot_TEXT","searpass_TEXT","searfail_TEXT",20);
    }

}
