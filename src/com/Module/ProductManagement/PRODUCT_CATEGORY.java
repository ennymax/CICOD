package com.Module.ProductManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PRODUCT_CATEGORY extends TestBase {

    @Test
    public void PRODUCT_category() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("PRODUCT CATEGORY");
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
        driver.findElement(By.xpath(Utility.fetchLocator("productCategory_XPATH"))).click();
        test.log(Status.PASS, "Product Category button fully functional");

        if (driver.findElements(By.xpath(Utility.fetchLocator("ProductCategoryConfirm_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product Category Page is opened");
        } else {
            test.log(Status.FAIL, "Product Category Page is not accessible");
        }

        //Add Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProductbtn_XPATH"))).click();
        test.log(Status.PASS, "Add Product button fully functional");

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ProductName_XPATH")))).sendKeys(randomstuff.ListRandom());

        driver.findElement(By.xpath(Utility.fetchLocator("ProductDiscription_XPATH"))).sendKeys(Utility.fetchLocator("ProductDiscription_TEXT"));

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();

        Thread.sleep(4000);
        fileUpload.UploadFileImage3MB();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("savvbtn_XPATH"))).click();

        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertProductCate_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product category created")) {
            test.log(Status.PASS, "Product Category was created successfully");
        } else {
            test.log(Status.FAIL, "Product Category wasn't Created");
        }

        System.out.println("********************PRODUCT CATEGORY*******************");
        driver.quit();
    }
}