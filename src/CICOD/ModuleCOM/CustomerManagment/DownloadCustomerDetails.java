package CICOD.ModuleCOM.CustomerManagment;

import CICOD.base.TestBase;
import CICOD.utility.API_Watch_Service;
import CICOD.utility.FileDownload;
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

public class DownloadCustomerDetails extends TestBase {


    @Test
    public void DOWNLOAD_CUSTOMER_DETAILS() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functionl");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadCUstomerdbtn_XPATH"))).click();
    }
}
