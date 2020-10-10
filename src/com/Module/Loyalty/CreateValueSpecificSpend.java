package com.Module.Loyalty;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
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
import java.security.SecureRandom;

public class CreateValueSpecificSpend extends TestBase {
    @Test
    public void CREATE_VALUE_SPECIFIC_SPEND() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE VALUE SPECIFIC SPEND");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(50) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("com_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("LoyaltyBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ValueSpecificSpendBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateProductSpecificValue_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("A_XPATH")))).sendKeys(Utility.fetchLocator("Amount_TEXT"));

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.name("ValueSpecificSpend[point]"))).sendKeys("45");

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("Period_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaveProductSpecificEnd_XPATH")))).click();

        Thread.sleep(4000);
        System.out.println("No Alert When Creating Value Specific Spend");
        System.out.println("********************CREATE VALUE SPECIFIC SPEND********************");
        driver.quit();
    }
}
