package CROWN.CICOD.WFM.RightTemplate;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class UpdateUser  extends TestBase {

    @Test
    public void UpdateUser() throws IOException, InterruptedException{
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        Assertion assertion = new Assertion(driver);

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT",50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT",50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT",50);
        utility.DoclickWhenReady("UserActionBTNN_XPATH", "ActionBBTN_TEXT",50);
        javaScriptUtil.DoscrolltoViewClickWhenReady("UpdateBtton_XPATH","UpdateBTNN_TEXT",40);
        utility.DosendKeysRandomListwordsWhenReady("NewUserFname_XPATH", "NewUser_TEXT",50);
        utility.DosendKeysRandomListwordsWhenReady("NewUserLastName_XPATH", "FirstNa_TEXT",50);

        utility.DoclickWhenReady("CreateNewUser_XPATH", "UpCreta_TEXT",50);
        assertion.DoAssertContainsWhenReady("AssertNewUserCreation_XPATH","Su_TEXT" ,"DplPass1_XPATH", "DplFail1_XPATH",30);
        utility.DoclickWhenReady("NewUserOKBTN_XPATH","Ok_TEXT",40);
    }
}
