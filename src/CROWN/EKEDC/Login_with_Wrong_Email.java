package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_with_Wrong_Email extends TestBase {
    @Test
    public void LOGIN_WITH_WRONG_EMAIL() throws IOException {
        Login login = new Login(driver);

        login.Login_with_Wrong_EmailEKEDC();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UserAlreadyExist_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Already Exist message was displayed Successfully");
        } else {
            test.log(Status.FAIL, "Already Exist message was not displayed Successfully");
        }
    }
}
