package CROWN.ModuleEKEDC;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import org.testng.annotations.Test;
import java.io.IOException;

public class Log_The_User_Out_After_30_Minute_Of_Inactivity extends TestBase {

    @Test
    public void LOG_THE_USER_OUT_AFTER_30_MINUTE_OF_INACTIVITY() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();
        Thread.sleep(300);
        driver.navigate().refresh();
    }
}
