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

public class Suspend_UnsuspendUser extends TestBase {
    @Test
    public void Suspend_UnsuspendUser() throws IOException, InterruptedException {
        test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        ExcelUtil excelUtil = new ExcelUtil(driver);

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT", 50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT", 50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT", 50);
        Thread.sleep(999999999);
        utility.DoclickWhenReady("UserActionBTNN_XPATH", "ActionBBTN_TEXT", 50);
        utility.DoscrolltoViewClickWhenReady("SuspendUserrr_XPATH", "SuspendUserrr_TEXT", 40);
        utility.DowaitandAcceptAlerwhenReady(20);
        utility.DoAssertContainsWhenReady("Userpasscont_XPATH", "suss_TEXT", "usersusPass_TEXT", "usersusFail_TEXT", 30);
        excelUtil.DoclickWhenReady("Okbtnnn_XPATH",20);

        utility.DoclickWhenReady("UserActionBTNN_XPATH", "ActionBBTN_TEXT", 50);
        utility.DoscrolltoViewClickWhenReady("UserUnsus_XPATH", "UnSuspendUserrr_TEXT", 40);
        utility.DowaitandAcceptAlerwhenReady(20);
        utility.DoAssertContainsWhenReady("Userpasscont_XPATH", "unsuss_TEXT", "userUnsusPass_TEXT", "userUnsusFail_TEXT", 30);
        excelUtil.DoclickWhenReady("Okbtnnn_XPATH",20);
    }
}
