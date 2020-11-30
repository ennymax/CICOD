package CICOD.ModuleWFM.RightTemplate;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ViewUser extends TestBase {
    @Test
    public void ViewUser() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT", 50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT", 50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT", 50);
        utility.DoclickWhenReady("EniActionButton_XPATH", "ActionBBTN_TEXT", 50);
        utility.DoscrolltoViewClickWhenReady("viewUser_XPATH", "viewuser_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("pi_XPATH","Userpas_TEXT","userfail_TEXT",20);
    }
}
