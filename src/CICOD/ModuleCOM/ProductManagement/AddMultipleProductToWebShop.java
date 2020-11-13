package CICOD.ModuleCOM.ProductManagement;

import CICOD.base.TestBase;
import CICOD.utility.FileUpload;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddMultipleProductToWebShop extends TestBase {

    @Test
    public void ADD_MULTIPLE_PRODUCT_TO_WEBSHOP() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("ADD MULTIPLE PRODUCT TO WEBSHOP");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();
        Randomstuff randomstuff = new Randomstuff();

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("productCategory_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ProductCategoryConfirm_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product Category Page is opened");
        } else {
            test.log(Status.FAIL, "Product Category Page is not accessible");
        }

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("Ch_XPATH")))).click();

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("BulkActionBTN_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        Thread.sleep(2000);

        driver.quit();
    }

}
