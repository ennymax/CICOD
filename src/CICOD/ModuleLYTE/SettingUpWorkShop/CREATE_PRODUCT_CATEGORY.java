package CICOD.ModuleLYTE.SettingUpWorkShop;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CREATE_PRODUCT_CATEGORY extends TestBase {
    @Test
    public void CREATE_PRODUCT_CATEGORy() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        screenshot.ScreenShot();

        //product Management
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        screenshot.ScreenShot();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("productCategory_XPATH"))).click();

        //Add Product
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProductbtn_XPATH"))).click();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductName_XPATH"))).sendKeys(Utility.fetchLocator("ProductName2_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductDiscription_XPATH"))).sendKeys(Utility.fetchLocator("NewDiscription2_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCheckBox_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("savvbtn_XPATH"))).click();
    }
}
