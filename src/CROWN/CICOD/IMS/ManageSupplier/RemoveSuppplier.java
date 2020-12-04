package CROWN.CICOD.IMS.ManageSupplier;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class RemoveSuppplier extends TestBase {
    @Test
    public void REMOVE_SUPPLIER() throws IOException, InterruptedException {
        test = extent.createTest("REMOVE SUPPLIER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successfull");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ManageSupplier_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTN_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("RemoveSupplierBTN_XPATH"))).click();

        login.AlertDismis();

        driver.quit();
        System.out.println("********************REMOVE SUPPLIER********************");
    }

}