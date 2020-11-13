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

public class RemoveFromWebShop extends TestBase {
    @Test
    public void REMOVE_FROM_WEBSHOP() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("REMOVE FROM WEBSHOP");
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
        sel11.selectByIndex(2);

        login.AcceptAlert();

        //Add Product
        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertProductCate_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product category removed from webshop successfully")) {
            test.log(Status.PASS, "Product Category was Removed successfully");
        } else {
            test.log(Status.FAIL, "Product Category Removed Created");
        }

        driver.quit();
    }

}
