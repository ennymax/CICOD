package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.RavePay;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class PayAccount extends TestBase {
    @Test(invocationCount = 2)
    public void Pay_Account() throws IOException, InterruptedException {
        test = extent.createTest("PAY ACCOUNT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        Login login = new Login(driver);
        RavePay ravePay = new RavePay(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Createorderbtn_XPATH", "CreateOrder_TEXT",40);
        utility.DoclickWhenReady("SearchByName_XPATH", "SearchBox_TEXT",40);
        utility.DoSendKeysWhenReady("SeaerchInput_XPATH", "CustomerName_TEXT","CustomerName_TEXT", 40);
        utility.DoclickWhenReady("Searchbtn_XPATH", "SearchBTN_TEXT",40);
        utility.DoclickWhenReady("ViewDetails_XPATH", "ViewD_TEXT",40);
        utility.DoSendKeysWhenReady("SearchProductinput_XPATH", "ID_TEXT","ID_TEXT", 40);
        utility.DoclickWhenReady("SearchProductbtnq_XPATH", "SearchProductBTN_TEXT",40);
        utility.DoclickWhenReady("AddBTN_XPATH", "add_TEXT",40);
        utility.DoscrolltoViewClickWhenReady("jjregion_XPATH", "jjregion_TEXT",40);
        utility.DoSelectValuesByIndex("SelectRegion_XPATH", "Sele_TEXT",3,20);
        utility.DoscrolltoViewClickWhenReady("jjregion_XPATH", "jjregion_TEXT",40);
        utility.DoSelectValuesByIndex("SelectRegion_XPATH", "Sele_TEXT",3,20);
        utility.DoscrolltoViewClickWhenReady("PaymentOptions_XPATH","PaymentOPT_TEXT",50);
        utility.DoclickWhenReady("NewPayAccount_XPATH", "Payno_TEXT",40);
        utility.DoscrolltoViewClickWhenReady("MakePayment_XPATH", "MakePayment_TEXT",40);
        utility.DowaitandAcceptAlerwhenReady(60);
        utility.DoAssertContainsWhenReady("AssertOrdeIDgenerated_XPATH", "OrDerID_TEXT","OrDerID_TEXT", "OrderIDPass_TEXT",30);
        utility.DoclickWhenReady("PayNowPayAccount_XPATH", "PayAcct_TEXT",40);
        utility.DoclickWhenReady("PayOnline_XPATH", "PAyOnline_TEXT",40);
        utility.DoswitchtoframeWhenReady(0, 13000);
        ravePay.RavePay3();

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************PAY ACCOUNT********************");
        driver.quit();
    }
}
