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

public class ViewCreditHistory extends TestBase {
    @Test
    public void VIEW_CREDIT_HISTORY() throws IOException, InterruptedException {
        test = extent.createTest("VIEW CREDIT HISTORY");
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Customermanagmentbtn_XPATH", "Commana_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("CreditLimi_XPATH","creditlimit_TEXT",60);
        utility.DoAssertContainsWhenReady("AssertViewCreditLimi_XPATH","assertcredit_TEXT","creditpass_TEXT","creditfail_TEXT",60);
    }
}
