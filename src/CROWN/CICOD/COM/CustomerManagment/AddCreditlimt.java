package CROWN.CICOD.COM.CustomerManagment;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddCreditlimt extends TestBase {

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
    public void COM() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Description("Customer Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("Customermanagmentbtn_XPATH", "Customermanagmentbtn_XPATH", 60);
    }

    @Description("Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void CreditLimit() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("CreditLimi_XPATH", "creditlimit_TEXT", 60);
    }

    @Description("Assert Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void AssertCreditLimit() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertViewCreditLimi_XPATH","assertcredit_TEXT","creditpass_TEXT","creditfail_TEXT",60);
    }

    @Description("Add Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void AddCreditLimit() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("AddCreditLimiBTN_XPATH", "ClickCredti_TEXT",60);
    }

    @Description("Search Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void SearchcustomerName() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstname_TEXT","CustomerFirstname_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
    }

    @Description("Assert Search Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void AssertSearchcustomerName() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathPresentWhenReady("AssertCreditSearchbyName_XPATH","credpass_TEXT","crditfail_TEXT",60);
    }

    @Description("Assert Search Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void SelectCreditLimit() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("Creditselecter_XPATH", "CredtSel_TEXT",60);
    }

    @Description("Search Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void SearchCustomer2() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstnam_TEXT","CustomerFirstnam_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
    }

    @Description("Search Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void AssertSearchCustomer2() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathPresentWhenReady("Creditselecter33_XPATH","credpass_TEXT","crditfail_TEXT",60);
    }

    @Description("Search Customer Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void SelectCreditLimit2() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("Creditselecter33_XPATH", "CredtSel_TEXT",60);
    }

    @Description("Remove Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void RemoveCreditLimit2() throws IOException, InterruptedException {
        JavaScriptUtil actionsClass = new JavaScriptUtil(driver);
        actionsClass.DoscrolltoViewClickWhenReady("RemoveCCC_XPATH","Remove_TEXT",60);
    }

    @Description("Search Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 14)
    public void SearchCustomer3() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstnam_TEXT","CustomerFirstnam_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
    }

    @Description("Assert Search Customer 3")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void AssertCustomer3() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathPresentWhenReady("Creditselecter33_XPATH","credpass_TEXT","crditfail_TEXT",60);
    }

    @Description("Select Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 16)
    public void SelectCreditLimit3() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("Creditselecter33_XPATH", "CredtSel_TEXT",60);
    }

    @Description("Select Credit Limit")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 17)
    public void ADD_CREDIT_LIMIT() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        utility.DoSendKeysWhenReady("CreditAmt_XPATH","AM_TEXT","AM_TEXT",60);
        utility.DoclickWhenReady("AddlimitBTN_XPATH","Addl_TEXT",60);
        utility.DowaitandAcceptAlerwhenReady(60);
        assertion.DoAssertContainsWhenReady("AssertCreditlimitCreation_XPATH","Contcc_TEXT","AssertCreditlimitCreationpass_TEXT","AssertCreditlimitCreationfail_TEXT",60);
    }
}
