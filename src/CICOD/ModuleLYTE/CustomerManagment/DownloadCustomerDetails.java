package CICOD.ModuleLYTE.CustomerManagment;

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

public class DownloadCustomerDetails extends TestBase {


    @Test
    public void DOWNLOAD_CUSTOMER_DETAILS() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD CUSTOMER DETAILS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustmerMGNLYTE_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functionl");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustmerLyte_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadCUstomerdbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Detail was downloaded");

        System.out.println("********************DOWNLOAD CUSTOMER DETAILS TEST IS COMPLETED********************");
        driver.quit();
    }
}
