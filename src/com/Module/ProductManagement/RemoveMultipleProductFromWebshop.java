package com.Module.ProductManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RemoveMultipleProductFromWebshop extends TestBase {
    @Test
    public void REMOVE_MULTIPLE_PRODUCT_FROM_WEBSHO() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("REMOVE MULTIPLE PRODUCT FROM WEBSHO");
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
        driver.findElement(By.xpath(Utility.fetchLocator("RemoveProduct_XPATH"))).click();

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("ProductBulkAction_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(2);

        Thread.sleep(2000);

        System.out.println("********************REMOVE MULTIPLE PRODUCT FROM WEBSHOP*******************");
        driver.quit();
    }
}
