package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Profile extends TestBase {
    @Test
    public void VIEW_PROFILE() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("ProfileBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertProfil_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Profile Page was Displayed");
        } else {
            test.log(Status.FAIL, "Profile Page was not displayed");
        }
    }
}
