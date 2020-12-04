package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Account extends TestBase {

    @Test
    public void VIEW_ACCOUNT() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        Thread.sleep(2700);
        if (driver.findElements(By.xpath(Utility.fetchLocator("DashBoard_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Account Details was Displayed Successfully");
        } else {
            test.log(Status.FAIL, "Account Details was not displayed");
        }
    }
}
