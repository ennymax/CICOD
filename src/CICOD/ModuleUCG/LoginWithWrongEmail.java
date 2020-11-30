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

public class LoginWithWrongEmail extends TestBase {

    @Test
    public void LOGIN_WITH_WRONG_EMAIL() throws IOException, InterruptedException {
        test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        Login login = new Login(driver);

        login.LoginWrongEmail();

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInvalidEmailOrPassword_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login Failed");
        }
    }
}
