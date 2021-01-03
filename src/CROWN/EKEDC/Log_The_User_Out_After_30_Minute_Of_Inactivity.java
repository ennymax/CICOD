package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Log_The_User_Out_After_30_Minute_Of_Inactivity extends TestBase {

    @Test
    public void LOG_THE_USER_OUT_AFTER_30_MINUTE_OF_INACTIVITY() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Assertion assertion = new Assertion(driver);

        login.LoginEKEDC();

        Thread.sleep(2100000);
        driver.navigate().refresh();
        assertion.DoAssertXpathAbsentWhenReady("aaaaaaa_XPATH","BFPass_TEXT","BFFail_TEXT",30);
        Thread.sleep(2100000);
    }
}
