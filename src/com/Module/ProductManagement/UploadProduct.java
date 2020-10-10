package com.Module.ProductManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
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
        test = extent.createTest("UPLOAD PRODUCT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();
        Randomstuff randomstuff = new Randomstuff();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Product Management button fully functional");

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

        WebElement jj = driver.findElement(By.xpath((Utility.fetchLocator("ScrowlIntoViewUploadList_XPATH"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", jj);

        System.out.println("********************UPLOAD PRODUCT*******************");
        driver.quit();
    }
}
