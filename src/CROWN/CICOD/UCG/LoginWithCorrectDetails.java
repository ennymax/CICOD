package CROWN.CICOD.UCG;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithCorrectDetails extends TestBase {

    @Test
    public void LOGIN_WITH_CORRECT_DETAILS() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }
    }
}
