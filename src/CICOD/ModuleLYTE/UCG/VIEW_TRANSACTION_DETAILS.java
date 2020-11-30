package CICOD.ModuleLYTE.UCG;

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

public class VIEW_TRANSACTION_DETAILS extends TestBase {

    @Test
    public void VIEW_TRANSACTION_DETAIL() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginTestAccount();

        driver.findElement(By.xpath(Utility.fetchLocator("Ucgbtn_XPATH"))).click();

        Thread.sleep(9999);
        if (driver.findElements(By.xpath(Utility.fetchLocator("mjj_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Transaction Details was successfully Displayed");
        } else {
            test.log(Status.FAIL, "Transaction Details Failed to load");
        }
    }
}
