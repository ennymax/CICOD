package CICOD.ModuleLYTE.Administration;

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
import java.util.concurrent.TimeUnit;

public class DOWNLOAD_User extends TestBase {

    @Test
    public void DOWNLOAD_USER() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD USER");

        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdminLyte_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementLYTE_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("UserDownload_XPATH"))).click();
    }
}
