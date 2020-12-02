package CROWN.CICOD.COM.SaleAgentManagement;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateSalesCommissionOnTarget extends TestBase {

    @Test
    public void CREATE_SALE_COMMISSION_ON_TARGET() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        Randomstuff randomstuff = new Randomstuff();

        login.Login();

        //COM
        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("com_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleManagementBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleCommissionBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateSaleCommissiontBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ComissionName_XPATH")))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("ccc_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(2);

        Thread.sleep(3000);
        WebElement ele11a = driver.findElement(By.xpath(Utility.fetchLocator("vb_XPATH")));
        Select sel1a = new Select(ele11a);
        sel1a.selectByIndex(1);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ActualValue_XPATH")))).sendKeys("45");

        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        Thread.sleep(6000);

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("mct_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Sales commission could not be created\n" + "Commission / Target Type exists")) {
            test.log(Status.PASS, "Create Sales Commission On Target Fully Functional");
        } else {
            test.log(Status.FAIL, "Create Sales Commission On Target Failed");
        }
    }
}
