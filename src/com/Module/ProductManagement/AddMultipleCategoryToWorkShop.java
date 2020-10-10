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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddMultipleCategoryToWorkShop extends TestBase {

    @Test
    public void ADD_MULTIPLE_CATEGORY_TO_WORKSHOP() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("ADD MULTIPLE CATEGORY TO WORKSHOP");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("cat1_XPATH"))).click();
        test.log(Status.PASS, "First Category Added to Webshop");

        driver.findElement(By.xpath(Utility.fetchLocator("cat2_XPATH"))).click();
        test.log(Status.PASS, "Second Category Added to webshop");

        driver.findElement(By.xpath(Utility.fetchLocator("cat3_XPATH"))).click();
        test.log(Status.PASS, "Third Category Added to webshop");

        Thread.sleep(1500);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("BulkAction_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(1200);
        login.AcceptAlert();

        Thread.sleep(2000);
        driver.navigate().to("https://nexusnigeria.cicod.com/webshop");

        Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("Assertcat1_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmed Product One was added to webshop successfully");
        } else {
            test.log(Status.FAIL, "Confirmed Product One wasn't added to webshop");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Assertcat2_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmed Product two was added to webshop successfully");
        } else {
            test.log(Status.FAIL, "Confirmed Product two wasn't added to webshop");
        }

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

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


        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("cat1_XPATH"))).click();
        test.log(Status.PASS, "First Category Removed to Webshop");

        driver.findElement(By.xpath(Utility.fetchLocator("cat2_XPATH"))).click();
        test.log(Status.PASS, "Second Category Removed to webshop");

        driver.findElement(By.xpath(Utility.fetchLocator("cat3_XPATH"))).click();
        test.log(Status.PASS, "Third Category Removed to webshop");

        Thread.sleep(1500);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("BulkAction_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(2);

        Thread.sleep(1200);
        login.AcceptAlert();

        Thread.sleep(2000);
        driver.navigate().to("https://nexusnigeria.cicod.com/webshop");

        Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("Assertcat1_XPATH"))).size() == 0) {
            test.log(Status.PASS, "Confirmed Product One was Removed from webshop successfully");
        } else {
            test.log(Status.FAIL, "Confirmed Product One wasn't Removed webshop");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Assertcat2_XPATH"))).size() == 0) {
            test.log(Status.PASS, "Confirmed Product two was Removed from webshop successfully");
        } else {
            test.log(Status.FAIL, "Confirmed Product two wasn't Removed from webshop");
        }


        System.out.println("********************Add Multiple CATEGORY To WorkShop*******************");
        driver.quit();
    }
}
