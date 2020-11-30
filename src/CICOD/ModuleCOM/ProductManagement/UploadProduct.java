package CICOD.ModuleCOM.ProductManagement;

import CICOD.base.TestBase;
import CICOD.utility.FileUpload;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UploadProduct extends TestBase {

    @Test
    public void UPLOAD_PRODUCT() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementProduct_XPATH"))).click();

        Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("UploadProductManagement_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product Management Page is displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Product Management Page is not displayed");
        }

        //Add Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UploadProductManagement_XPATH"))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ChooseFile_XPATH")))).click();

        fileUpload.UploadXLSX();

        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertProductCate_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product(s) uploaded successfully")) {
            test.log(Status.PASS, "Product was Uploaded successfully successfully");
        } else {
            test.log(Status.FAIL, "Product cant be Uploaded");
        }
    }
}
