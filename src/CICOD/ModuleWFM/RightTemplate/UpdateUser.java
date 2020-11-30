package CICOD.ModuleWFM.RightTemplate;

import CICOD.base.TestBase;
import CICOD.utility.ExcelUtil;
import CICOD.utility.FileUpload;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class UpdateUser  extends TestBase {

    @Test
    public void UpdateUser() throws IOException, InterruptedException{
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        SecureRandom rn = new SecureRandom();

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT",50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT",50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT",50);
        utility.DoclickWhenReady("UserActionBTNN_XPATH", "ActionBBTN_TEXT",50);
        utility.DoscrolltoViewClickWhenReady("UpdateBtton_XPATH","UpdateBTNN_TEXT",40);
        utility.DosendKeysRandomListwordsWhenReady("NewUserFname_XPATH", "NewUser_TEXT",50);
        utility.DosendKeysRandomListwordsWhenReady("NewUserLastName_XPATH", "FirstNa_TEXT",50);

        utility.DoclickWhenReady("CreateNewUser_XPATH", "UpCreta_TEXT",50);
        utility.DoAssertContainsWhenReady("AssertNewUserCreation_XPATH","Su_TEXT" ,"DplPass1_XPATH", "DplFail1_XPATH",30);
        utility.DoclickWhenReady("NewUserOKBTN_XPATH","Ok_TEXT",40);
    }
}
