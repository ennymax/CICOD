package CICOD.ModuleUCG;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithWrongPassword extends TestBase {

    @Test
    public void LOGIN_WITH_WRONG_PASSWORD() throws IOException, InterruptedException {
        test = extent.createTest("LOGIN WITH WRONG PASSWORD");
        Login login = new Login(driver);

        login.LoginWrongPassWord();

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInvalidEmailOrPassword_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful FAILED");
        } else {
            test.log(Status.FAIL, "Login Successful");
        }
    }
}
