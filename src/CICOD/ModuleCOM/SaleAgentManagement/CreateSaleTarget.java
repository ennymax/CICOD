package CICOD.ModuleCOM.SaleAgentManagement;

import CICOD.base.TestBase;
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
import java.security.SecureRandom;

public class CreateSaleTarget extends TestBase {

    @Test
    public void CREATE_VALUE_SPECIFIC_SPEND() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE VALUE SPECIFIC SPEND");
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;
        Randomstuff randomstuff = new Randomstuff();

        login.Login();

        //COM
        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("com_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleManagementBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleTargetManagementBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateThe_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SalesTargetGroupName_XPATH")))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SalesTargetAmount_XPATH")))).sendKeys("45");

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("TargetType_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(st);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("InputA_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("InputB_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("InputC_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateSaleTargetSaveBTN_XPATH")))).click();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("InvoiceAlert_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Sales target created")) {
            test.log(Status.PASS, "Sale Target was created successfully");
        } else {
            test.log(Status.FAIL, "Failed to create Sales Target");
        }
    }
}
