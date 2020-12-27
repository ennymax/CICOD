package CROWN.CICOD.COM.CustomerManagment;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewCreditHistory extends TestBase {
    @Test
    public void VIEW_CREDIT_HISTORY() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Customermanagmentbtn_XPATH", "Commana_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("CreditLimi_XPATH","creditlimit_TEXT",60);
        assertion.DoAssertContainsWhenReady("AssertViewCreditLimi_XPATH","assertcredit_TEXT","creditpass_TEXT","creditfail_TEXT",60);
    }
}
