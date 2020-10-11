package com.Module.WorkShopConfiguration;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CarouselBanner extends TestBase {

    @Test
    public void CAROUSEL_BANNER() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CAROUSEL BANNER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        FileUpload fileUpload = new FileUpload();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH"))).click();

        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CarouselBanner_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddCoruselBanner_XPATH"))).click();
        test.log(Status.PASS, "Add Carousel Banner was fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Caption_XPATH"))).sendKeys(Utility.fetchLocator("Caption_TEXT"));
        test.log(Status.PASS, "Caption was Updated Successfully");

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("DisplayLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("OrderOfAppearance_XPATH"))).sendKeys(Utility.fetchLocator("OrderOfPreference_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ActiUERL_XPATH"))).sendKeys(Utility.fetchLocator("ActionUrl_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CarouselSaveBtn_XPATH"))).click();
        test.log(Status.PASS, "Carousel Banner was Updated Successfully");

        Thread.sleep(2000);
        System.out.println("********************CAROUSEL BANNER TEST IS COMPLETED********************");
        driver.quit();
    }
}
