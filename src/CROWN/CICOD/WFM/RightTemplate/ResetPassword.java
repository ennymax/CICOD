package CROWN.CICOD.WFM.RightTemplate;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResetPassword extends TestBase {
    @Test
    public void ResetPassworD() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT", 50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT", 50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT", 50);
        utility.DoclickWhenReady("EniActionButton_XPATH", "ActionBBTN_TEXT", 50);
        javaScriptUtil.DoscrolltoViewClickWhenReady("ResetPasswordBTN_XPATH", "Resetpass_TEXT", 40);
        utility.DowaitandAcceptAlerwhenReady(20);
        assertion.DoAssertContainsWhenReady("lcont_XPATH", "usercontext_TEXT", "ResetpassPass_TEXT", "ResetpassFail_TEXT", 30);
        utility.DoclickWhenReady("OkBTNNREsetpassw_XPATH", "Ree_TEXT", 50);
    }
}
