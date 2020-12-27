package CROWN.CICOD.WFM.RightTemplate;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewUser extends TestBase {
    @Test
    public void ViewUser() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        Assertion assertion = new Assertion(driver);
        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT", 50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT", 50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT", 50);
        utility.DoclickWhenReady("EniActionButton_XPATH", "ActionBBTN_TEXT", 50);
        javaScriptUtil.DoscrolltoViewClickWhenReady("viewUser_XPATH", "viewuser_TEXT", 40);
        assertion.DoAssertXpathPresentWhenReady("pi_XPATH","Userpas_TEXT","userfail_TEXT",20);
    }
}
