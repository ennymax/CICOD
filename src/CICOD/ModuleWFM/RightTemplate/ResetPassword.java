package CICOD.ModuleWFM.RightTemplate;

import CICOD.base.TestBase;
import CICOD.utility.ExcelUtil;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ResetPassword extends TestBase {
    @Test
    public void ResetPassworD() throws IOException, InterruptedException {
        test = extent.createTest("RESET PASSWORD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT", 50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT", 50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT", 50);
        utility.DoclickWhenReady("EniActionButton_XPATH", "ActionBBTN_TEXT", 50);
        utility.DoscrolltoViewClickWhenReady("ResetPasswordBTN_XPATH", "Resetpass_TEXT", 40);
        utility.DowaitandAcceptAlerwhenReady(20);
        utility.DoAssertContainsWhenReady("lcont_XPATH", "usercontext_TEXT", "ResetpassPass_TEXT", "ResetpassFail_TEXT", 30);
        utility.DoclickWhenReady("OkBTNNREsetpassw_XPATH", "Ree_TEXT", 50);

        driver.quit();
    }
}
