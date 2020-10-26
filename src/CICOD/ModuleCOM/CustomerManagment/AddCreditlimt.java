package CICOD.ModuleCOM.CustomerManagment;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddCreditlimt extends TestBase {
    @Test
    public void ADD_CREDIT_LIMIT() throws IOException, InterruptedException {
        test = extent.createTest("ADD CREDIT LIMIT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Utility utility = new Utility(driver);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Customermanagmentbtn_XPATH", "Commana_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("CreditLimi_XPATH","creditlimit_TEXT",60);
        utility.DoAssertContainsWhenReady("AssertViewCreditLimi_XPATH","assertcredit_TEXT","creditpass_TEXT","creditfail_TEXT",60);
        utility.DoclickWhenReady("AddCreditLimiBTN_XPATH", "ClickCredti_TEXT",60);
        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstname_TEXT","CustomerFirstname_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
        utility.DoAssertXpathPresentWhenReady("AssertCreditSearchbyName_XPATH","credpass_TEXT","crditfail_TEXT",60);
        utility.DoclickWhenReady("Creditselecter_XPATH", "CredtSel_TEXT",60);

        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstnam_TEXT","CustomerFirstnam_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
        utility.DoAssertXpathPresentWhenReady("Creditselecter33_XPATH","credpass_TEXT","crditfail_TEXT",60);
        utility.DoclickWhenReady("Creditselecter33_XPATH", "CredtSel_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("RemoveCCC_XPATH","Remove_TEXT",60);

        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstnam_TEXT","CustomerFirstnam_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
        utility.DoAssertXpathPresentWhenReady("Creditselecter33_XPATH","credpass_TEXT","crditfail_TEXT",60);
        utility.DoclickWhenReady("Creditselecter33_XPATH", "CredtSel_TEXT",60);
        utility.DoSendKeysWhenReady("CreditAmt_XPATH","AM_TEXT","AM_TEXT",60);
        utility.DoclickWhenReady("AddlimitBTN_XPATH","Addl_TEXT",60);
        utility.DowaitandAcceptAlerwhenReady(60);
        utility.DoAssertContainsWhenReady("AssertCreditlimitCreation_XPATH","Contcc_TEXT","AssertCreditlimitCreationpass_TEXT","AssertCreditlimitCreationfail_TEXT",60);

        System.out.println("********************ADD CREDIT LIMIT********************");
        driver.quit();
    }
    
}
